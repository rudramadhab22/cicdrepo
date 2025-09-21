package com.rmp.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CicdController {
	@GetMapping("/getAllDetails")
	public ResponseEntity<Map<String, Object>>getAllDetails(){
		Map<String, Object>map=new LinkedHashMap<>();
		map.put("Name","Rudra");
		map.put("city","Hydreabad");
		map.put("age","24");
		map.put("Gender","Male");
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		
	}

}
