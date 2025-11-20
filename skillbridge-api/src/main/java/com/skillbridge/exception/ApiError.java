package com.skillbridge.exception;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private int status;
    private String message;
    private List<String> errors;
    public ApiError(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
