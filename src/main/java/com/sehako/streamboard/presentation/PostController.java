package com.sehako.streamboard.presentation;

import com.sehako.streamboard.application.PostService;
import com.sehako.streamboard.common.response.JsonResponse;
import com.sehako.streamboard.common.response.message.code.SuccessCode;
import com.sehako.streamboard.presentation.request.PostWriteRequest;
import java.net.URI;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private static final String POST_RETRIEVE_URI = "/post/%s";

    private final PostService postService;
    private final MessageSource messageSource;

    @PostMapping
    public Mono<ResponseEntity<JsonResponse<Void>>> createPost(
            @RequestBody PostWriteRequest request,
            Locale locale
    ) {
        Mono<Integer> postNo = postService.createPost(request);

        SuccessCode success = SuccessCode.SUCCESS;
        String message = messageSource.getMessage(success.getCode(), null, locale);

        return postNo.map(no -> ResponseEntity
                .created(URI.create(String.format(POST_RETRIEVE_URI, no)))
                .body(JsonResponse.of(SuccessCode.SUCCESS, message))
        );
    }
}
