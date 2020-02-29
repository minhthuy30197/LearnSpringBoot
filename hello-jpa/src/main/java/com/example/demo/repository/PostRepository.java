package com.example.demo.repository;

import com.example.demo.entity.Post;
import com.example.demo.model.dto.AuthorInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(nativeQuery = true, name = "getAuthorInfo")
    AuthorInfoDto getAuthorInfo(int authorId);
}
