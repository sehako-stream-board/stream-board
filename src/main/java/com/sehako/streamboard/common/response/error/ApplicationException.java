package com.sehako.streamboard.common.response.error;

import com.sehako.streamboard.common.response.message.code.ErrorCode;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    public final ErrorCode errorCode;

    public ApplicationException(ErrorCode message) {
        this.errorCode = message;
    }
}
