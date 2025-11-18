package com.sehako.streamboard.infrastructure;

import com.sehako.streamboard.common.R2dbcAuditingConfiguration;
import com.sehako.streamboard.infrastructure.domain.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ActiveProfiles("test")
@DataR2dbcTest
@Import(R2dbcAuditingConfiguration.class)
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("사용자가 게시판에 글을 작성하면 데이터베이스에 저장된다.")
    public void postSaveTest() {
        // given
        Post post = new Post(1, "title", "content");

        // when
        Mono<Post> save = postRepository.save(post);
        // then
        StepVerifier.create(save)
                .expectNextMatches(p ->
                        p.getNo() != null && p.getCreatedAt() != null
                )
                .verifyComplete();
    }
}
