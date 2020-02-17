package redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.TimeZone;

public class RedisApplication implements CommandLineRunner {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));
        System.out.println("## 1s ##");
        SpringApplication.run(RedisApplication.class, args);
        System.out.println("## 1e ##");
    }

    @Autowired
    RedisTemplate redisTemplate; // Redisの操作を行うクラス

    @Override
    public void run(String... args) {
//        final RedisUser user = new RedisUser("kc","watai");
//        redisTemplate.opsForValue().set("kc",user); // "kc" keyに、userオブジェクトを保存。
//        RedisUser kc = (RedisUser) redisTemplate.opsForValue().get("kc"); // "kc" keyの値を取得し、userオブジェクトに変換。
//        System.out.println(kc.getName());
        System.out.println("## 2 ##");
    }
}