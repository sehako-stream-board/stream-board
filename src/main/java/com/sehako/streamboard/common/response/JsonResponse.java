package com.sehako.streamboard.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sehako.streamboard.common.response.message.code.Code;

@JsonPropertyOrder({"code", "message", "result"})
public record JsonResponse<T>(
        String code,
        String message,
        @JsonInclude(Include.NON_NULL) T result
) {

    public static <T> JsonResponse<T> of(Code code, String message, T result) {
        return new JsonResponse<>(code.getCode(), message, result);
    }

    public static <T> JsonResponse<T> of(Code code, String message) {
        return new JsonResponse<>(code.getCode(), message, null);
    }
}
