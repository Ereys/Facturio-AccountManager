package com.facturio.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class UserDtoRequest {

    private String email;
    private String name;
    private String password;
}
