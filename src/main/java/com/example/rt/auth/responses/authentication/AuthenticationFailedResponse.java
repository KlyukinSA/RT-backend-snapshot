package com.example.rt.auth.responses.authentication;

import com.example.rt.auth.responses.ResponseBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationFailedResponse extends ResponseBase {
    private String message;
}