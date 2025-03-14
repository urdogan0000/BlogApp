package com.haydarurdogan.blog.exception;

import com.haydarurdogan.blog.dto.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(BaseException ex) {
        logger.warn("Handled exception: {} - Params: {}", ex.getErrorCode().name(), ex.getParams());

        String localizedMessage = messageSource.getMessage(
                ex.getErrorCode().getMessageKey(),
                ex.getParams() != null ? ex.getParams().toArray() : null,
                LocaleContextHolder.getLocale()
        );

        ErrorResponse errorResponse = new ErrorResponse(
                ex.getErrorCode().name(),
                ex.getErrorCode().getCode(),
                localizedMessage,
                null
        );

        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }
}
