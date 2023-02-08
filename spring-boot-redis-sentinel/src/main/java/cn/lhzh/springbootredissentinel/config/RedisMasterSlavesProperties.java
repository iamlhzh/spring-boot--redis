package cn.lhzh.springbootredissentinel.config;


import cn.lhzh.springbootredismasterslave.bean.RedisMaster;
import cn.lhzh.springbootredismasterslave.bean.RedisSlave;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author xgk
 * @date
 */
@ConfigurationProperties(prefix = "redis.ms")
@Data
public class RedisMasterSlavesProperties {
    // 主机
    private RedisMaster redisMaster;
    // 从机
    private List<RedisSlave> redisSlaves;
}
