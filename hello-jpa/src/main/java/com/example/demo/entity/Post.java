package com.example.demo.entity;

import com.example.demo.model.dto.AuthorInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@SqlResultSetMappings(value = {
        @SqlResultSetMapping(
                name = "AuthorInfo",
                classes = @ConstructorResult(
                        targetClass = AuthorInfoDto.class,
                        columns = {
                                @ColumnResult(name = "name"),
                                @ColumnResult(name = "avatar"),
                                @ColumnResult(name = "posts", type=String.class)
                        }
                )
        )
})
@NamedNativeQuery(
        name = "getAuthorInfo",
        resultSetMapping = "AuthorInfo",
        query = "SELECT user.name, user.avatar, \n" +
                "(\n" +
                "    SELECT JSON_ARRAYAGG(d.item)\n" +
                "    FROM ( \n" +
                "        SELECT JSON_OBJECT('id',post.id,'title',post.title,'content',post.content) as item\n" +
                "        FROM post \n" +
                "        WHERE post.created_by = user.id \n" +
                "    ) d\n" +
                ") AS posts \n" +
                "FROM user \n" +
                "WHERE user.id = ?1")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
}
