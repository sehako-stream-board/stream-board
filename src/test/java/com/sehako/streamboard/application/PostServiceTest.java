package com.sehako.streamboard.application;

import com.sehako.streamboard.presentation.request.PostWriteRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
@ActiveProfiles("test")
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    @DisplayName("사용자가 게시글을 포스팅하면 생성된 포스팅의 번호가 반환된다.")
    public void postSaveIntegerReturnTest() {
        // given
        PostWriteRequest request = new PostWriteRequest(1, "title", "content");
        // when
        Mono<Integer> postNo = postService.createPost(request);
        // then

        StepVerifier.create(postNo)
                .expectNextMatches(n -> n != null && n > 0)
                .verifyComplete();
    }
}