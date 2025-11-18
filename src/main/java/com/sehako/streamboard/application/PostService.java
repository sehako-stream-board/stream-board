package com.sehako.streamboard.application;

import com.sehako.streamboard.infrastructure.PostRepository;
import com.sehako.streamboard.infrastructure.domain.Post;
import com.sehako.streamboard.presentation.request.PostWriteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Mono<Integer> createPost(PostWriteRequest request) {
        return postRepository.save(request.toEntity())
                .map(Post::getNo);
    }
}
