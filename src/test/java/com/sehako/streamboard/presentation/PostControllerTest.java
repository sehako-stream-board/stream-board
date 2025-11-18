package com.sehako.streamboard.presentation;

import com.sehako.streamboard.application.PostService;
import com.sehako.streamboard.common.response.message.MessageExplorer;
import com.sehako.streamboard.presentation.request.PostWriteRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@WebFluxTest(PostController.class)
@Import(MessageExplorer.class)
@ActiveProfiles("test")
class PostControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockitoBean
    private PostService postService;

    @Test
    @DisplayName("사용자가 요청한 포스팅 생성이 성공하면 201 응답이 반환된다.")
    public void userPostingWriteRequestTest() {
        // given
        PostWriteRequest request = new PostWriteRequest(1, "title", "content");

        // when
        Mockito.when(postService.createPost(request)).thenReturn(Mono.just(1));

        // then
        webTestClient.post().uri("/post")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().valueEquals("Location", "/post/1");
    }
}