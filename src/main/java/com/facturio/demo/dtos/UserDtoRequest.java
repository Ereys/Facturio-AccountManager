package com.facturio.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class UserDtoRequest {
    private String name;
    private String password;
}
