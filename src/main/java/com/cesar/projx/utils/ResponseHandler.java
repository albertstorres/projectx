package com.cesar.projx.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> generate(
            String mensagem,
            HttpStatus statusCode) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mensagem", mensagem);
        return new ResponseEntity<Object>(map, statusCode);
    }
}
