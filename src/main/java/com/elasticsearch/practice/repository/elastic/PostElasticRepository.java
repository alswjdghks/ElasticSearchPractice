package com.elasticsearch.practice.repository.elastic;

import com.elasticsearch.practice.document.PostDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostElasticRepository extends ElasticsearchRepository<PostDocument, Long> {
    List<PostDocument> findByTitle(String title);
}
