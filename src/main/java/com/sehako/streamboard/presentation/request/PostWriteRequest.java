package com.sehako.streamboard.presentation.request;

import com.sehako.streamboard.infrastructure.domain.Post;

public record PostWriteRequest(
        String title,
        String content
) {
    public Post toEntity() {
        return new Post(title, content);
    }
}
