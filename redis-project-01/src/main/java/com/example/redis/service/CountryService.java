package com.example.redis.service;

import com.example.redis.model.Country;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    /*@Autowired
    private RedisTemplate<String, Country> redisTemplate;*/

    private HashOperations<String, Object, Object> hashOperations = null;

    public CountryService(RedisTemplate<String, Country> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    public String addCountry(Country country) {
        hashOperations.put("countries", country.getCode(), country);
        return country.getCode();
    }

    public Country getCountry(String code) {
        return (Country) hashOperations.get("countries", code);
    }

    public List<Object> getCountries() {
        return hashOperations.values("countries");
    }

}
