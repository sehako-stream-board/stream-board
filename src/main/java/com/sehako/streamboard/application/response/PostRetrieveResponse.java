package com.sehako.streamboard.application.response;

import com.sehako.streamboard.infrastructure.domain.Post;
import java.time.LocalDateTime;

public record PostRetrieveResponse(
        Integer no,
        String title,
        LocalDateTime createdAt
) {
    public static PostRetrieveResponse from(Post post) {
        return new PostRetrieveResponse(post.getNo(), post.getTitle(), post.getCreatedAt());
    }
}
