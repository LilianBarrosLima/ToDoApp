package com.lilianLima.todo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter @Getter
@NoArgsConstructor
public class StandardError {
    private Long timestamp;
    private Integer status;
    private String message;
}
