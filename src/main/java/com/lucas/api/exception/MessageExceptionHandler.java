package com.lucas.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageExceptionHandler {

    private Date timestamp;
    private Integer status;
    private String message;
}
