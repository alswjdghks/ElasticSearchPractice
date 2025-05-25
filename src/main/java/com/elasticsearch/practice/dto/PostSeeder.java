package com.elasticsearch.practice.dto;

import com.elasticsearch.practice.domain.Post;
import com.elasticsearch.practice.repository.jpa.PostRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostSeeder {

    private final PostRepository postRepository;

    // @PostConstruct
    public void seedData() {
        for (int i = 1; i <= 100_000; i++) {
            Post post = Post.builder()
                    .username("user" + (i % 100))  // 유저 100명 반복
                    .title("샘플 제목입니다 " + i)
                    .content("이것은 테스트용 본문입니다 " + i)
                    .build();
            postRepository.save(post);
        }
    }
}
