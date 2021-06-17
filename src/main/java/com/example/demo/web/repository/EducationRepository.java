package com.example.demo.web.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class EducationRepository {

	public JSONArray getDataUniversity() throws JSONException, ParseException {
		try {
			URL url = new URL("http://202.44.139.145/api/public/opendata/univ_uni_11_06");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			
			int responseCode = connection.getResponseCode();
			
			JSONArray jsonArr = null;
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
				String readAPIResponse = " ";
				
				StringBuilder jsonString = new StringBuilder();
				
				while((readAPIResponse = br.readLine()) != null) {
					jsonString.append(readAPIResponse);	
				}
				
				jsonArr = new JSONArray(jsonString.toString());
				
				System.out.println(jsonArr);
				
			}
			
			connection.disconnect();
			
			return jsonArr;
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
