package com.elasticsearch.practice.service;

import com.elasticsearch.practice.document.PostDocument;
import com.elasticsearch.practice.domain.Post;
import com.elasticsearch.practice.dto.PostRequestDto;
import com.elasticsearch.practice.repository.elastic.PostElasticRepository;
import com.elasticsearch.practice.repository.jpa.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostElasticRepository postElasticRepository;
    private final PostRepository postRepository;

    public Post add(PostRequestDto request) {
        Post post = Post.builder()
                .username(request.username())
                .title(request.title())
                .content(request.content())
                .build();
        postRepository.save(post);
        postElasticRepository.save(PostDocument.from(post));
        return post;
    }
}
