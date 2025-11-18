package com.sehako.streamboard.infrastructure;

import com.sehako.streamboard.infrastructure.domain.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PostRepository extends ReactiveCrudRepository<Post, Integer> {
}
