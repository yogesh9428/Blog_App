package com.springboot.blog_app.comments;

import com.springboot.blog_app.articles.ArticleEntity;
import com.springboot.blog_app.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
@Entity(name = "Comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Nullable
    private String title;

    @NonNull
    private String body;

    @CreatedDate
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "articleId" , nullable = false)
    private ArticleEntity article;

    @ManyToOne
    @JoinColumn(name = "authorId" , nullable = false )
    private UserEntity author;
}
