package com.projeto.netflix.dto;

import org.springframework.http.HttpStatus;

public record FoundErrors(HttpStatus status,String message) {

}
