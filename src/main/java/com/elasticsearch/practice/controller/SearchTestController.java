package com.elasticsearch.practice.controller;

import com.elasticsearch.practice.repository.elastic.PostElasticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SearchTestController {

    private final com.elasticsearch.practice.repository.jpa.PostRepository postRepository;
    private final PostElasticRepository postElasticRepository;

    @GetMapping("/api/v1/search-test")
    public Map<String, String> testSearch(@RequestParam String keyword) {
        Map<String, String> result = new HashMap<>();

        long startSql = System.currentTimeMillis();
        postRepository.findByTitleContaining(keyword);
        long endSql = System.currentTimeMillis();
        result.put("SQL을 이용한 검색", endSql - startSql + " ms");

        long startEs = System.currentTimeMillis();
        postElasticRepository.findByTitle(keyword);
        long endEs = System.currentTimeMillis();
        result.put("ElasticSearch를 이용한 검색", endEs - startEs + " ms");

        return result;
    }
}
