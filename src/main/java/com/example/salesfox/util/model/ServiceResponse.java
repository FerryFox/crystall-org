package com.example.salesfox.util.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse<T> {
    private boolean success;
    private String message;
    private T payload;
}

