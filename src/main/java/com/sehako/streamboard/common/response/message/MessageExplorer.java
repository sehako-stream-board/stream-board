package com.sehako.streamboard.common.response.message;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageExplorer {

    private final MessageSource messageSource;

    public String searchMessage(String code, Locale locale) {
        return messageSource.getMessage(code, null, locale);
    }
}
