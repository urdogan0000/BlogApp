package com.haydarurdogan.blog.exception;

import com.haydarurdogan.blog.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Handle BlogNotFoundException
    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBlogNotFound(BlogNotFoundException ex) {
        logger.error("Blog not found: " + ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Handle BadRequestException
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex) {
        logger.warn("Bad request: " + ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("BAD_REQUEST", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundRequest(NotFoundException ex) {
        logger.warn("not found: " + ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Handle InternalServerErrorException
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorResponse> handleInternalServerError(InternalServerErrorException ex) {
        logger.error("Internal server error: " + ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("INTERNAL_SERVER_ERROR", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle any other exceptions (generic fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        logger.error("Unexpected error: " + ex.getMessage(), ex);
        ErrorResponse errorResponse = new ErrorResponse("INTERNAL_SERVER_ERROR", "An unexpected error occurred");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
