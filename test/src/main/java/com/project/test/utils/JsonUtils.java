package com.project.test.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.test.vo.BookVO;
import com.project.test.vo.StatVO;
import com.project.test.vo.UserVO;

/**
 * JSON 관련된 유틸리티 클래스
 */
public class JsonUtils { 

	/**
	 * Map을 JSONString으로 변환
	 * 
	 * @param map
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public static String getJsonStringFromMap(Map<String, Object> map) {

		JSONObject json = new JSONObject();

		for (Map.Entry<String, Object> entry : map.entrySet()) {
			json.put(entry.getKey(), entry.getValue());
		}

		return json.toJSONString();
	}

	/**
	 * List<Map>을 JSONString으로 변환
	 * 
	 * @param list
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public static String getJsonStringFromList(List<Map<String, Object>> list) {

		JSONArray jsonArray = new JSONArray();

		for (Map<String, Object> map : list) {
			jsonArray.add(getJsonStringFromMap(map));
		}

		return jsonArray.toJSONString();
	}
	
	/**
	 * String을 JSONObject를 변환
	 * 
	 * @param jsonStr
	 * @return jsonObject
	 */
	public static JSONObject getJsonObjectFromString(String jsonStr) { 
	
		JSONObject jsonObject = new JSONObject();
		
		JSONParser jsonParser = new JSONParser();
		
		try {
			
			jsonObject = (JSONObject) jsonParser.parse(jsonStr);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return jsonObject;
	}
	
	/**
	 * JSONObject를 Map<String, String>으로 변환
	 * 
	 * @param jsonObject
	 * @return map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMapFromJsonObject(JSONObject jsonObject) { 

		Map<String, Object> map = null;
		
		try {
			UserVO user = (UserVO) jsonObject.get("user");
			System.out.println(user.getName());
			
			BookVO book = (BookVO) jsonObject.get("book");
			System.out.println(book.getCategory());

			map.put("u", user);
			map.put("b", book);
			map = new ObjectMapper().readValue(jsonObject.toJSONString(), Map.class);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	/**
	 * JSONArray를 List<Map<String, String>>으로 변환
	 * 
	 * @param jsonArray
	 * @return list
	 */
	public static List<Map<String, Object>> getListMapFromJsonArray(JSONArray jsonArray) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		if (jsonArray != null) {

			int jsonSize = jsonArray.size();

			for (int i = 0; i < jsonSize; i++) {

				Map<String, Object> map = getMapFromJsonObject((JSONObject)jsonArray.get(i));
				list.add(map);
			}
		}

		return list;
	}
	
	public static List<Map<String, Object>> getListMapFromJsonArrayStatVO(JSONArray jsonArray) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		if (jsonArray != null) {

			int jsonSize = jsonArray.size();

			for (int i = 0; i < jsonSize; i++) {

				Map<String, Object> map = getMapFromJsonObjectStatVO((JSONObject)jsonArray.get(i));
				list.add(map);
			}
		}

		return list;
	}
	
	@SuppressWarnings({ "unchecked", "null" })
	public static Map<String, Object> getMapFromJsonObjectStatVO(JSONObject jsonObject) { 

		Map<String, Object> map = new HashMap<String, Object>();

		String policyName = (String) jsonObject.get("policyName");

		List<StatVO> statList = (ArrayList<StatVO>) jsonObject.get("statList");

		map.put("statList", statList);
		map.put("policyName", policyName);
		

		return map;
	}
}
