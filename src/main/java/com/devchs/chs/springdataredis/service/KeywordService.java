package com.devchs.chs.springdataredis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class KeywordService {

    private final RedisTemplate<String, String> redisTemplate;

    public void setCount(String keyword) {
        redisTemplate.opsForZSet().incrementScore("keyword", keyword, 1);
    }

    public List<String> findKeywordRank() {
        Set<String> keywordRank = redisTemplate.opsForZSet().reverseRange("keyword", 0, 9);
        return keywordRank.stream().collect(Collectors.toList());
    }
}
