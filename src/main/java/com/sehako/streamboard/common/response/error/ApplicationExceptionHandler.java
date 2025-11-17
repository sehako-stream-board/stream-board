package com.sehako.streamboard.common.response.error;

import com.sehako.streamboard.common.response.JsonResponse;
import com.sehako.streamboard.common.response.message.MessageExplorer;
import com.sehako.streamboard.common.response.message.code.Code;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@RequiredArgsConstructor
public class ApplicationExceptionHandler {
    private final MessageExplorer messageSource;

    @ExceptionHandler(ApplicationException.class)
    public Mono<ResponseEntity<JsonResponse<Void>>> handleApplicationException(
            ApplicationException e,
            ServerWebExchange exchange) {

        Code error = e.getErrorCode();
        Locale locale = exchange.getLocaleContext().getLocale();
        String message = messageSource.searchMessage(error.getCode(), locale);

        return Mono.just(ResponseEntity.internalServerError()
                .body(JsonResponse.of(
                        error,
                        message)
                ));
    }
}
