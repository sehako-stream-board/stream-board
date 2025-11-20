package com.sehako.streamboard.infrastructure.domain;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("post")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    private Integer no = null;
    private String title;
    private String content;
    @Column("created_at")
    @CreatedDate
    private LocalDateTime createdAt = null;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
