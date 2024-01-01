package com.example.spring_boot_redis.repository;

import com.example.spring_boot_redis.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRedisRepository extends CrudRepository<Person,String> {
}
