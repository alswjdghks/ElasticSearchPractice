package com.elasticsearch.practice.dto;

public record PostRequestDto(
        String username,
        String title,
        String content
) {
}
