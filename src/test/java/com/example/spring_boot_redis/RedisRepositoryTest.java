package com.example.spring_boot_redis;

import com.example.spring_boot_redis.entity.Person;
import com.example.spring_boot_redis.repository.PersonRedisRepository;
import com.example.spring_boot_redis.service.RedisService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RedisRepositoryTest {
    final String key = "key";
    final String value = "value";
    final Duration duration = Duration.ofMillis(5000);

    @Autowired
    private RedisService redisService;
    @Autowired
    private PersonRedisRepository personRedisRepository;

    @BeforeEach
    void shutDown() {
        redisService.setValues(key, value, duration);
    }

//    @AfterEach
//    void tearDown() {
//        redisService.deleteValues(key);
//    }

    @Test
    @DisplayName(value = "Redis에 데이터를 저장하면 정상적으로 조회된다.")
    void saveAndFindTest() throws Exception {
        String findValue = redisService.getValues(key);
        assertThat(value).isEqualTo(findValue);

    }

//    @Test
//    void test() {
//        Person person = new Person("Kim", 28);
//        personRedisRepository.save(person);
//        personRedisRepository.findById(person.getId());
//        personRedisRepository.count();
//        personRedisRepository.delete(person);
//    }
}
