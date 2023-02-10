package cn.lhzh.springbootredissentinel.test;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
public class RedisDemoApplicationTest {

    // 注入 RedisTemplate
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // String 类型
    @Test
    void testString () {
        redisTemplate.opsForValue().set("name", "xiaobai");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    // Hash 类型
    @Test
    public void testHash () {
        redisTemplate.opsForHash().put("user1", "name", "clarence");
        redisTemplate.opsForHash().put("user1", "age", "25");
        Map map = redisTemplate.opsForHash().entries("user1");
        System.out.println(map);
    }

    // List 类型
    @Test
    public void testList () {
        redisTemplate.opsForList().leftPushAll("names", "xiaobai", "xiaohei", "xiaolan");
        List<String> names = redisTemplate.opsForList().range("names", 0, 3);
        System.out.println(names);
    }

    // Set 类型
    @Test
    public void testSet () {
        redisTemplate.opsForSet().add("set", "a", "b", "c");
        Set<String> set = redisTemplate.opsForSet().members("set");
        System.out.println(set);
    }

    // SortedSet 类型
    @Test
    public void testSortedSet () {
        redisTemplate.opsForZSet().add("class", "xiaobai", 90);
        Set aClass = redisTemplate.opsForZSet().rangeByScore("class", 90, 100);
        System.out.println(aClass);
        Set<ZSetOperations.TypedTuple<String>> set = new HashSet<>();
        set.add(new DefaultTypedTuple<>("xiaohei", 88.0));
        set.add(new DefaultTypedTuple<>("xiaohui", 94.0));
        set.add(new DefaultTypedTuple<>("xiaolan", 84.0));
        set.add(new DefaultTypedTuple<>("xiaolv", 82.0));
        set.add(new DefaultTypedTuple<>("xiaohong", 99.0));
        redisTemplate.opsForZSet().add("class", set);
        Set aClass1 = redisTemplate.opsForZSet().range("class", 0, 6);
        System.out.println(aClass1);
    }
}
