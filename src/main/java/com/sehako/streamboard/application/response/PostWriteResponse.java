package com.sehako.streamboard.application.response;

import com.sehako.streamboard.infrastructure.domain.Post;

public record PostWriteResponse(
        Integer no
) {
    public static PostWriteResponse from(Post post) {
        return new PostWriteResponse(post.getNo());
    }
}
