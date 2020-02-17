package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/SampleRedis")
public class RedisSampleController {

    @Autowired
    private RedisTemplate<String, RedisSampleData> redisTemplate;

    @PostMapping
    public void post(@RequestBody RedisSampleData redisSampleData) {
        redisTemplate.delete("redis-tutorial:string");
        redisTemplate.opsForValue()
                .set("redis-tutorial:string", redisSampleData);
//                .set("redis-tutorial:string", redisSampleData.getString());
        redisTemplate.delete("redis-tutorial:list");
        redisTemplate.opsForList()
                .rightPushAll("redis-tutorial:list",
                        redisSampleData);
//                        redisSampleData.getList().toArray(new String[0]));
        redisTemplate.delete("redis-tutorial:map");
        redisTemplate.opsForHash()
                .putAll("redis-tutorial:map", redisSampleData.getMap());
    }

    @GetMapping
    public RedisSampleData get() {
        RedisSampleData redisSampleData = new RedisSampleData();
        redisSampleData.setString(
                redisTemplate.opsForValue()
                        .get(redisSampleData)
//                        .get("redis-tutorial:string")
        );
        redisSampleData.setList(
                redisTemplate.opsForList()
                        .range("redis-tutorial:list", 0, -1)
//                        .range("redis-tutorial:list", 0, -1)
        );
        redisSampleData.setMap(
                redisTemplate.<String, String>opsForHash()
                        .entries("redis-tutorial:map")
        );
        return redisSampleData;
    }
}