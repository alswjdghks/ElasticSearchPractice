package com.elasticsearch.practice.document;

import com.elasticsearch.practice.domain.Post;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(indexName = "posts", writeTypeHint = WriteTypeHint.FALSE)
/*
    Elasticsearch 인덱스를 지정하고, 해당 클래스가 Elasticsearch 도큐먼트로 매핑되도록 정의
    indexName: Elasticsearch 인덱스 이름 지정 (필수)
    writeTypeHint: 도큐먼트 타입 힌트작성 여부 (기본값: true), 기본적으로 Spring Data Elasticsearch는 도큐먼트에 '_class' 필드 생성한다
    createIndex: 인덱스 자동 생성 여부 (기본값: true)
*/
@Setting(settingPath = "elastic/post-setting.json") //  Elasticsearch 인덱스의 설정을 정의하는 JSON 파일 경로 지정
@Mapping(mappingPath = "elastic/post-mapping.json")
/*
    Elasticsearch 인덱스의 매핑을 정의하는 JSON 파일의 경로 지정 (런타임 필드로 인덱스 매핑을 정의하면, 클래스 경로에 해당 JSON 파일의 경로를 설정해야한다.)
*/
public class PostDocument {
    @Id
    private Long id;
    private String username;
    private String title;
    private String content;

    @Builder
    public PostDocument(Long id, String username, String title, String content) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
    }

    public static PostDocument from(Post post) {
        return PostDocument.builder()
                .id(post.getId())
                .username(post.getUsername())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
