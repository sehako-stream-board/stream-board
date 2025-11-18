package com.sehako.streamboard.presentation.request;

import com.sehako.streamboard.infrastructure.domain.Post;

public record PostWriteRequest(
        Integer userNo,
        String title,
        String content
) {
    public Post toEntity() {
        return new Post(userNo, title, content);
    }
}
