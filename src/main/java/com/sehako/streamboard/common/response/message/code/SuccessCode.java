package com.sehako.streamboard.common.response.message.code;

public enum SuccessCode implements Code {
    SUCCESS;

    @Override
    public String getCode() {
        return this.name().toUpperCase();
    }
}
