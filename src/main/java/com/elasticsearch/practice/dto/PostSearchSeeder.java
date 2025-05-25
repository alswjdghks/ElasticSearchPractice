package com.elasticsearch.practice.dto;

import com.elasticsearch.practice.document.PostDocument;
import com.elasticsearch.practice.repository.elastic.PostElasticRepository;
import com.elasticsearch.practice.repository.jpa.PostRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostSearchSeeder {

    private final PostRepository postRepository;
    private final PostElasticRepository postElasticRepository;

    // @PostConstruct
    public void syncToElastic() {
        postRepository.findAll().forEach(post ->
                postElasticRepository.save(PostDocument.from(post))
        );
    }
}
