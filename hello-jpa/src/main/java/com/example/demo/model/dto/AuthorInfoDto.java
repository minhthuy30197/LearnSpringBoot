package com.example.demo.model.dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import java.io.IOException;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AuthorInfoDto {
    private String name;
    private String avatar;
    private List<PostDto> posts;

    public AuthorInfoDto(String name, String avatar, Object posts) {
        this.name = name;
        this.avatar = avatar;
        if (posts != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                this.posts = mapper.readValue((String) posts, new TypeReference<List<PostDto>>(){});
            } catch (IOException e) {
                this.posts = null;
            }
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostDto {
        private int id;
        private String title;
        private String content;
    }
}
