package com.example.demo.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.web.model.University;
import com.example.demo.web.repository.EducationRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@RestController
@RequestMapping("/v1")
public class APIController {

	@Autowired
	EducationRepository er;
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/education/university", produces = MediaType.APPLICATION_JSON_VALUE)
	public JSONObject getUniversityList() throws Exception {
		JSONArray al = er.getDataUniversity();
		JSONObject jo = al.toJSONObject(al);
		return jo;
	}
	
}
