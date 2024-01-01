package com.example.spring_boot_redis.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@RedisHash(value = "people", timeToLive = 30)
//value : Redis의 KeySpace, timeToLive : 만료시간을 seconds 단위로 설정
public class Person {
    @Id
    private String id;
    private String name;
    private Integer age;
    private LocalDateTime created;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.created = LocalDateTime.now();
    }
}
