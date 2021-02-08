package com.se.hackathon.helper.exception.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data

public class ErrorResponse {

    private HttpStatus status;

    @ToString.Exclude
    private int code;

    /**
     * property holds a user-friendly message about the apierror.
     */
    private String message;
    /**
     * system message describing the api error in more detail.
     */
    private List<String> details = new ArrayList<>();

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy.MM.dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime timestamp = LocalDateTime.now();

    public ErrorResponse() {
    }

    public ErrorResponse(HttpStatus status, String message, List<String> details) {
        this.status = status;
        this.code = status.value();
        this.message = message;
        this.details = details;
    }


    @Override
    public String toString() {
        return "ErrorResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", details=" + details +
                ", timestamp=" + timestamp +
                '}';
    }
}
