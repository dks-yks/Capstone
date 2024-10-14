package com.example.swagger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportResponse<T> {
    private boolean isSuccess;
    private int code;
    private String message;
    private T result;
}
