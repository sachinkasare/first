package com.watersoftware.common.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", message);
			map.put("status", status.value());
            map.put("data", responseObj);

            return new ResponseEntity<Object>(map,status);
    }
	
	public static Map<String, Object> generateResponse1(Boolean code,Object responseObj, String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        	map.put("Success", code);
        	map.put("data", responseObj);
            map.put("message", message);
            
			//return new ResponseEntity<Object>(map,status);
			return map;
    }
}
