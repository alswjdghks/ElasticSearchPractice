package com.elasticsearch.practice.controller;

import com.elasticsearch.practice.document.PostDocument;
import com.elasticsearch.practice.domain.Post;
import com.elasticsearch.practice.dto.PostRequestDto;
import com.elasticsearch.practice.service.PostSearchService;
import com.elasticsearch.practice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostSearchController {
    private final PostSearchService postSearchService;
    private final PostService postService;

    @GetMapping("/posts")
    public String test() {
        return "GET 요청도 받았습니다!";
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> post(@RequestBody PostRequestDto requestDto) {
        Post post =  postService.add(requestDto);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/search")
    ResponseEntity<List<PostDocument>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(postSearchService.searchByKeyword(keyword));
    }
}
