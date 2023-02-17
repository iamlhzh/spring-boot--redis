//package cn.lhzh.springbootrediscluster.config;
//
//
//
//import org.redisson.Redisson;
//import org.redisson.config.ClusterServersConfig;
//import org.redisson.config.Config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Configuration
//public class RedissonConfig {
//
//    @Autowired
//    private RedisConfigProperties redisConfigProperties;
//
//    /**
//     * redis://host:port
//     */
//    private static final String REDIS_ADDRESS = "redis://%s:%s";
//
//    /**
//     * 集群模式-添加redisson的bean
//     * @return
//     */
//    @Bean
//    public Redisson redisson() {
//        //redisson版本是3.5，集群的ip前面要加上“redis://”，不然会报错，3.2版本可不加
//        List<String> clusterNodes = new ArrayList<>();
//        for (int i = 0; i < redisConfigProperties.getCluster().getNodes().size(); i++) {
//            clusterNodes.add("redis://" + redisConfigProperties.getCluster().getNodes().get(i));
//        }
//        Config config = new Config();
//        ClusterServersConfig clusterServersConfig = config.useClusterServers()
//                .addNodeAddress(clusterNodes.toArray(new String[clusterNodes.size()]));
//        clusterServersConfig.setPassword(redisConfigProperties.getPassword());//设置密码，如果没有密码，则注释这一行，否则启动会报错
//        return (Redisson) Redisson.create(config);
//    }
//
////    /**
////     * Redisson单机模式
////     * @return
////     */
////    @Bean
////    public Redisson RedissonConfig(){
////        Config config = new Config();
////		  config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(redisConfigProperties.getDatabase());
////        config.useSingleServer().setAddress(String.format(REDIS_ADDRESS, redisConfigProperties.getHost(), redisConfigProperties.getPort()))
////                .setDatabase(redisConfigProperties.getDatabase())
////                .setPassword(redisConfigProperties.getPassword());
////        return (Redisson) Redisson.create(config);
////    }
//}
//
