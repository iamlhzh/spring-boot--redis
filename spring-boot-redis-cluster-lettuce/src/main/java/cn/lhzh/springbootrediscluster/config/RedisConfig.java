package cn.lhzh.springbootrediscluster.config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisConfig {


    @Value("${spring.redis.cluster.nodes}")
    private String redisServerNodes;

    @Value("${spring.redis.password}")
    private String redisServerPassword;


    @Bean
    public RedisClusterConfiguration getRedisClusterConfiguration() {

        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();

        String[] serverArray = redisServerNodes.split(",");
        Set<RedisNode> nodes = new HashSet<RedisNode>();
        for (String ipPort : serverArray) {
            String[] ipAndPort = ipPort.split(":");
            nodes.add(new RedisNode(ipAndPort[0].trim(), Integer.parseInt(ipAndPort[1])));
        }
        redisClusterConfiguration.setClusterNodes(nodes);
        RedisPassword pwd = RedisPassword.of(redisServerPassword);
        redisClusterConfiguration.setPassword(pwd);
        return redisClusterConfiguration;
    }

    /**
     * 方法描述： 初始化redis连接
     * @param factory redis连接工厂
     * @return {@link RedisTemplate}
     */
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        // 新建redisTemplate对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置工厂
        template.setConnectionFactory(factory);
        //序列化配置
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //1，用StringRedisSerializer进行序列化的值，在Java和Redis中保存的内容是一样的
        //2，用Jackson2JsonRedisSerializer进行序列化的值，在Redis中保存的内容，比Java中多了一对双引号。
        //3，用JdkSerializationRedisSerializer进行序列化的值，对于Key-Value的Value来说，是在Redis中是不可读的。对于Hash的Value来说，比Java的内容多了一些字符。
        //如果Key的Serializer也用和Value相同的Serializer的话，在Redis中保存的内容和上面Value的差异是一样的，所以我们保存时，只用StringRedisSerializer进行序列化
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(stringRedisSerializer);
        // 返回redisTemplate对象
        return template;
    }
}

