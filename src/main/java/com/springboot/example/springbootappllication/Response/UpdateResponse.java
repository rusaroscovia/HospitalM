package com.springboot.example.springbootappllication.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateResponse {
    private String previousName;
    private String newName;
    private String message;
}
