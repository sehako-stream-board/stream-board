package com.sehako.streamboard.common.response.message.code;

public enum ErrorCode implements Code {
    SERVER_ERROR;

    @Override
    public String getCode() {
        return this.name().toUpperCase();
    }
}
