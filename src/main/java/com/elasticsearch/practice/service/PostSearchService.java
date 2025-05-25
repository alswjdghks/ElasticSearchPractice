package com.elasticsearch.practice.service;

import com.elasticsearch.practice.document.PostDocument;
import com.elasticsearch.practice.repository.PostElasticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostSearchService {
    private final PostElasticRepository postElasticRepository;

    public List<PostDocument> searchByKeyword(String keyword) {
        return postElasticRepository.findByTitle(keyword);
    }
}
