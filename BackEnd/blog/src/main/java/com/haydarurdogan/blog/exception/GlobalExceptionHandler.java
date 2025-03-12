package com.haydarurdogan.blog.exception;

import com.haydarurdogan.blog.dto.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles BadRequestException (400).
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex) {
        logger.warn("Bad Request: {}", ex.getMessage());
        return buildErrorResponse(ex, HttpStatus.BAD_REQUEST, "BAD_REQUEST");
    }

    /**
     * Handles NotFoundException (404).
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundRequest(NotFoundException ex) {
        logger.warn("Resource Not Found: {}", ex.getMessage());
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND, "NOT_FOUND");
    }

    /**
     * Handles InternalServerErrorException (500).
     */
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorResponse> handleInternalServerError(InternalServerErrorException ex) {
        logger.error("Internal Server Error: {}", ex.getMessage(), ex);
        return buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");
    }

    /**
     * Generic handler for unexpected exceptions (500).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        logger.error("Unexpected error occurred: {}", ex.getMessage(), ex);
        return buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");
    }

    /**
     * Utility method to build error response.
     */
    private ResponseEntity<ErrorResponse> buildErrorResponse(Exception ex, HttpStatus status, String errorCode) {
        ErrorResponse errorResponse = new ErrorResponse(errorCode, status.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }
}
