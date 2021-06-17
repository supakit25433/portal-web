package com.example.demo.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class IndexController {

	@GetMapping("/index")
	public String index(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		return "index";
	}
	
	@GetMapping("/education")
	public String education(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		return "education";
	}
	
	@GetMapping("/education/university")
	public String getUniversity(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "University");
		
		try {
			URL url = new URL("http://202.44.139.145/api/public/opendata/univ_uni_11_06");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			Map<String, List<String>> m = connection.getHeaderFields();
			System.out.println(m);
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {		
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line = "";	
				StringBuilder responseStrBuilder = new StringBuilder();	
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}
				connection.getInputStream().close();
				JSONArray result = new JSONArray(responseStrBuilder.toString());
				ArrayList<Object> al = new ArrayList<Object>();
				for(int i = 0; i < result.length(); i++) {
					al.add(result.get(i));
				}
				model.addAttribute("Array", al);
				System.out.println(result);
				model.addAttribute("Response", result);
			}
			model.addAttribute("Map", m);
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "education";
	}
	
	@GetMapping("/education/demonstration")
	public String getDemonstrationSchool(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Demonstration School");
		
		try {
			URL url = new URL("http://202.44.139.145/api/public/opendata/satit_sch_11_01");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			Map<String, List<String>> m = connection.getHeaderFields();
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.defaultCharset()));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}
				connection.getInputStream().close();
				JSONArray result = new JSONArray(responseStrBuilder.toString());
				ArrayList<Object> al = new ArrayList<Object>();
				for(int i = 0; i < result.length(); i++) {
					al.add(result.get(i));
				}
				model.addAttribute("Array", al);
				System.out.println(result);
				model.addAttribute("Response", result);
			}
			model.addAttribute("Map", m);
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "education";
	}
	
	@GetMapping("/education/demonstration/nameandsex")
	public String getNumberOfStudents(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Number of Students");
		
		try {
			URL url = new URL("http://202.44.139.145/api/public/opendata/SATIT_STD_11_03");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			Map<String, List<String>> m = connection.getHeaderFields();
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.defaultCharset()));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}
				connection.getInputStream().close();
				JSONArray result = new JSONArray(responseStrBuilder.toString());
				ArrayList<Object> al = new ArrayList<Object>();
				for(int i = 0; i < result.length(); i++) {
					al.add(result.get(i));
				}
				model.addAttribute("Array", al);
				System.out.println(result);				
				model.addAttribute("Response", result);
			}
			model.addAttribute("Map", m);
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "education";
	}
	
	@GetMapping("/health")
	public String health(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		return "health";
	}
	
	@GetMapping("/health/covid-19/daily")
	public String getDailyCovid(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Daily Covid-19");
		
		try {
			URL url = new URL("https://covid19.th-stat.com/json/covid19v2/getTodayCases.json");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			Map<String, List<String>> m = connection.getHeaderFields();
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.defaultCharset()));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}
				connection.getInputStream().close();
				JSONObject result = new JSONObject(responseStrBuilder.toString());
				model.addAttribute("Response", result);
			}
			model.addAttribute("Map", m);
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "health";
	}
	
	@GetMapping("/health/covid-19/timeline")
	public String getTimeCovid(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Timeline Covid-19");
		
		try {
			URL url = new URL("https://covid19.th-stat.com/json/covid19v2/getTimeline.json");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");	
			Map<String, List<String>> m = connection.getHeaderFields();
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.defaultCharset()));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}
				connection.getInputStream().close();
				JSONObject result = new JSONObject(responseStrBuilder.toString());
				JSONArray array = (JSONArray) result.get("Data");
				ArrayList<Object> al = new ArrayList<Object>();
				for(int i = 0; i < array.length(); i++) {
					al.add(array.get(i));
				}
				model.addAttribute("Array", al);
				model.addAttribute("Response", result);
			}
			model.addAttribute("Map", m);
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "health";
	}
	
	@GetMapping("/health/covid-19/bycase")
	public String getCaseCovid(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Summary Case Covid-19");
		
		try {
			URL url = new URL("https://covid19.th-stat.com/json/covid19v2/getSumCases.json");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			Map<String, List<String>> m = connection.getHeaderFields();
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("TIS-620")));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}		
				connection.getInputStream().close();			
				JSONObject result = new JSONObject(responseStrBuilder.toString());	
				JSONArray province = (JSONArray) result.get("Province");
				ArrayList<Object> provinceArray = new ArrayList<Object>();
				for(int i = 0; i < province.length(); i++) {
					provinceArray.add(province.get(i));
				}
				JSONArray nation = (JSONArray) result.get("Nation");
				ArrayList<Object> nationArray = new ArrayList<Object>();
				for(int i = 0; i < nation.length(); i++) {
					nationArray.add(nation.get(i));
				}
				JSONArray gender = (JSONArray) result.get("Gender");
				ArrayList<Object> genderArray = new ArrayList<Object>();
				for(int i = 0; i < gender.length(); i++) {
					genderArray.add(gender.get(i));
				}
				model.addAttribute("Response", result);
				model.addAttribute("ProvinceArray", provinceArray);
				model.addAttribute("NationArray", nationArray);
				model.addAttribute("GenderArray", genderArray);
			}
			model.addAttribute("Map", m);
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "health";
	}
	
//	@GetMapping("/resource")
//	public String resource(Model model) {
//		Date d = new Date();
//		model.addAttribute("Date", d);
//		return "resource";
//	}
//	
//	@GetMapping("/resource/get/airdata")
//	public String getAirData(Model model) {
//		Date d = new Date();
//		model.addAttribute("Date", d);
//		model.addAttribute("search", "Air Data");
//		
//		try {
//			URL url = new URL("https://opendata.royalrain.go.th/upperair");
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			
//			connection.setRequestMethod("GET");
//			connection.setRequestProperty("Content-Type", "application/json; utf-8");
//			
//			Map<String, List<String>> m = connection.getHeaderFields();
//			System.out.println(m);
//			
//			model.addAttribute("Map", m);
//			
//			int responseCode = connection.getResponseCode();
//			
//			if(responseCode == HttpURLConnection.HTTP_OK) {
//				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
//				String inputLine;
//				StringBuffer response = new StringBuffer();
//				while ((inputLine = in.readLine()) != null) {
//					response.append(inputLine);
//				}
//				in.close();
//				System.out.println(response);
//				model.addAttribute("Response", response);
//			}
//			
//			connection.disconnect();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "resource";
//	}
//	
//	@GetMapping("/resource/get/royalrain")
//	public String getRoyalRain(Model model) {
//		Date d = new Date();
//		model.addAttribute("Date", d);
//		model.addAttribute("search", "Royal Rain");
//		
//		try {
//			URL url = new URL("https://opendata.royalrain.go.th/request");
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			
//			connection.setRequestMethod("GET");
//			connection.setRequestProperty("Content-Type", "application/json; utf-8");
//			
//			Map<String, List<String>> m = connection.getHeaderFields();
//			System.out.println(m);
//			
//			model.addAttribute("Map", m);
//			
//			connection.disconnect();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "resource";
//	}
	
	@GetMapping("/budget")
	public String budget(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		return "budget";
	}
	
	@GetMapping("/governBudget/ministry")
	public String getMinistry(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Ministry List");
		
		try {
			URL url = new URL("https://opend.data.go.th/govspending/bbministry?api-key=JCizH1CqrBBt8WnUEb558zNgz9SYy1TP");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			
			Map<String, List<String>> m = connection.getHeaderFields();
			
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("TIS-620")));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}		
				connection.getInputStream().close();			
				JSONObject result = new JSONObject(responseStrBuilder.toString());	
				model.addAttribute("Response", result);
			}
			
			model.addAttribute("Map", m);
			
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "budget";
	}
	
	@GetMapping("/governBudget/procurementproject")
	public String getProcurementProject(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Procurement Project");
		
		try {
			URL url = new URL("https://opend.data.go.th/govspending/cgdcontract?api-key=JCizH1CqrBBt8WnUEb558zNgz9SYy1TP");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			
			Map<String, List<String>> m = connection.getHeaderFields();
			
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("TIS-620")));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}		
				connection.getInputStream().close();			
				JSONObject result = new JSONObject(responseStrBuilder.toString());	
				model.addAttribute("Response", result);
			}
			
			model.addAttribute("Map", m);
			
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "budget";
	}
	
	@GetMapping("/governBudget/disbursement2563")
	public String getBudgetAndDisbursement2563(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Budget & Disbursement 2563");
		
		try {
			URL url = new URL("https://opend.data.go.th/govspending/bbgf_summary?api-key=JCizH1CqrBBt8WnUEb558zNgz9SYy1TP&year=2563");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			
			Map<String, List<String>> m = connection.getHeaderFields();
			
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("TIS-620")));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}		
				connection.getInputStream().close();			
				JSONObject result = new JSONObject(responseStrBuilder.toString());	
				model.addAttribute("Response", result);
			}
			
			model.addAttribute("Map", m);
			
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "budget";
	}
	
	@GetMapping("/governBudget/province")
	public String getProvincesList(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Provinces List");
		
		try {
			URL url = new URL("https://opend.data.go.th/govspending/bbgfmisprovince?api-key=JCizH1CqrBBt8WnUEb558zNgz9SYy1TP");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			
			Map<String, List<String>> m = connection.getHeaderFields();
			
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("TIS-620")));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}		
				connection.getInputStream().close();			
				JSONObject result = new JSONObject(responseStrBuilder.toString());	
				model.addAttribute("Response", result);
			}
			
			model.addAttribute("Map", m);
			
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "budget";
	}
	
	@GetMapping("/governBudget/department")
	public String getDepartment(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Department List");
		
		try {
			URL url = new URL("https://opend.data.go.th/govspending/bbministry?api-key=JCizH1CqrBBt8WnUEb558zNgz9SYy1TP");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			
			Map<String, List<String>> m = connection.getHeaderFields();
			
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("TIS-620")));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}		
				connection.getInputStream().close();			
				JSONObject result = new JSONObject(responseStrBuilder.toString());	
				model.addAttribute("Response", result);
			}
			
			model.addAttribute("Map", m);
			
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "budget";
	}
	
	@GetMapping("/governBudget/juristic")
	public String getJuristicOfSinosiam(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Juristic ID 0105537004444");
		
		try {
			URL url = new URL("https://opend.data.go.th/moc/juristic?api-key=JCizH1CqrBBt8WnUEb558zNgz9SYy1TP&juristic_id=0105537004444");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			
			Map<String, List<String>> m = connection.getHeaderFields();

			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}		
				connection.getInputStream().close();			
				JSONObject result = new JSONObject(responseStrBuilder.toString());	
				model.addAttribute("Response", result);
			}
			
			model.addAttribute("Map", m);
			
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "budget";
	}
	
	@GetMapping("/politics")
	public String politics(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		return "politics";
	}
	
	@GetMapping("/politics/localoffice/location")
	public String getProvincialLocalOfficeLocation(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Location of Provincial Local Office");
		
		try {
			URL url = new URL("https://opend.data.go.th/get-ckan/datastore_search?resource_id=df922923-e009-4dee-92fc-d963a86ce4b8&limit=100");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			connection.setRequestProperty("api-key", "JCizH1CqrBBt8WnUEb558zNgz9SYy1TP");
			
			Map<String, List<String>> m = connection.getHeaderFields();
			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}		
				connection.getInputStream().close();			
				JSONObject result = new JSONObject(responseStrBuilder.toString());	
				model.addAttribute("Response", result);
			}
			
			model.addAttribute("Map", m);
			
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "politics";
	}
	
	@GetMapping("/politics/organizationoffice/location")
	public String getLocalAdministrativeOrganizationOfficeLocation(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Location of Local Administrative Organization Office");
		
		try {
			URL url = new URL("https://opend.data.go.th/get-ckan/datastore_search?resource_id=981ffa6f-2700-407e-9056-0ee05810adc6&limit=8000");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			connection.setRequestProperty("api-key", "JCizH1CqrBBt8WnUEb558zNgz9SYy1TP");
			
			Map<String, List<String>> m = connection.getHeaderFields();

			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}		
				connection.getInputStream().close();			
				JSONObject result = new JSONObject(responseStrBuilder.toString());	
				model.addAttribute("Response", result);
			}
			
			model.addAttribute("Map", m);
			
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "politics";
	}
	
	@GetMapping("/politics/organizationoffice/website")
	public String getLocalAdministrativeOrganizationOfficeWebsite(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Website of Provincial Local Office");
		
		try {
			URL url = new URL("https://opend.data.go.th/get-ckan/datastore_search?resource_id=7782218d-baab-4f7d-8bd7-21f2dddbbe89&limit=10000");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			connection.setRequestProperty("api-key", "JCizH1CqrBBt8WnUEb558zNgz9SYy1TP");
			
			Map<String, List<String>> m = connection.getHeaderFields();

			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}		
				connection.getInputStream().close();			
				JSONObject result = new JSONObject(responseStrBuilder.toString());	
				model.addAttribute("Response", result);
			}
			
			model.addAttribute("Map", m);
			
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "politics";
	}
	
	@GetMapping("/politics/organizationoffice/code")
	public String getLocalAdministrativeOrganizationOfficeCode(Model model) {
		Date d = new Date();
		model.addAttribute("Date", d);
		model.addAttribute("search", "Code of Provincial Local Office");
		
		try {
			URL url = new URL("https://opend.data.go.th/opend-search/vir_9793_1611202992/query?dsname=vir_9793_1611202992&path=vir_9793_1611202992&property=col_4&operator=S_EQUALS&valueLiteral=%E0%B8%81%E0%B8%A3%E0%B8%B0%E0%B8%9A%E0%B8%B5%E0%B9%88&loadAll=1&type=json&limit=1000&offset=0");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("api-key", "JCizH1CqrBBt8WnUEb558zNgz9SYy1TP");
			
			Map<String, List<String>> m = connection.getHeaderFields();

			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
				String line = "";
				StringBuilder responseStrBuilder = new StringBuilder();
				while((line = br.readLine()) != null) {
					responseStrBuilder.append(line);	
				}		
				connection.getInputStream().close();			
				JSONObject result = new JSONObject(responseStrBuilder.toString());	
				model.addAttribute("Response", result);
			}
			
			model.addAttribute("Map", m);
			
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "politics";
	}
	
}
