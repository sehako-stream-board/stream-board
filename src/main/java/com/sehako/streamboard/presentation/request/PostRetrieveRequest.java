package com.sehako.streamboard.presentation.request;

public record PostRetrieveRequest(
        Integer cursor,
        Integer size
) {
    public static PostRetrieveRequest from(Integer cursor, Integer size) {
        return new PostRetrieveRequest(cursor, size);
    }
}
