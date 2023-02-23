package com.project.test.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.project.test.vo.BookVO;
import com.project.test.vo.StatVO;
import com.project.test.vo.UserVO;

class JsonUtilsTest {

	static Map<String, Object> map = null;	
	static List<Map<String, Object>> list = null;

	String jsonStr = "{\"key01\":\"value01\",\"key02\":\"value02\",\"key03\":\"value03\",\"key04\":\"value04\",\"key05\":\"value05\"}";

	static JSONObject jsonObject = null;
	static JSONObject jsonObject2 = null;
	static JSONArray jsonArray = null;
	static JSONArray jsonArray2 = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		map = new HashMap<String, Object>();
		map.put("key01", "value01");
		map.put("key02", "value02");
		map.put("key03", "value03");
		map.put("key04", "value04");
		map.put("key05", "value05");
		
		list = new ArrayList<Map<String, Object>>(); 
		list.add(map);		
		list.add(map);		
		list.add(map);
		
		jsonObject = new JSONObject();
		UserVO userVO = new UserVO();
		userVO.setId("phm");
		userVO.setName("박현민");
		BookVO bookVO = new BookVO();
		bookVO.setBookNum(1);
		bookVO.setBookName("홍길동전");
		bookVO.setCategory("동화");

		jsonObject.put("key01", "value01");
		jsonObject.put("key02", "value02");
		jsonObject.put("key03", "value03");
		jsonObject.put("user", userVO);
		jsonObject.put("book", bookVO);
		
		jsonArray = new JSONArray();
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);
		
		jsonObject2 = new JSONObject();
		
		for(int i=0;i<4; i++) {
			jsonObject2.put("policyName", "정책이름");
			
			
			
			List<StatVO> statList = new ArrayList<StatVO>();
			for(int j=0;j<4;j++) {
				StatVO statVO = new StatVO();
				statVO.setIssueCnt(0);
				statVO.setPolicyOid("1");
				statVO.setSearchCon("2");
				statVO.setSrcDate("3");
				statVO.setSrcReqName("4");

				statList.add(statVO);
			}			
			jsonObject2.put("statList", statList);

			jsonArray2 = new JSONArray();
			jsonArray2.add(jsonObject2);
		}

	}

	@Test
	public void testGetJsonStringFromMap() {
		
		String jsonStr = JsonUtils.getJsonStringFromMap(map);
			
		System.out.println("JsonStringFromMap : " + jsonStr);
	}

	@Test
	public void testGetJsonStringFromList() {

		String jsonStr = JsonUtils.getJsonStringFromList(list);
		
		System.out.println("JsonStringFromList : " + jsonStr);
	}
	
	
	@Test
	public void testGetJsonObjectFromString() {
		
		JSONObject jsonObject = JsonUtils.getJsonObjectFromString(jsonStr);
		
		System.out.println("JsonObjectFromString : " + jsonObject);
	}
	
	
	@Test
	public void testGetMapFromJsonObject() {
	
		Map<String, Object> map = JsonUtils.getMapFromJsonObject(jsonObject);
		
		System.out.println("MapFromJsonObject : " + map);
	}
	
	@Test
	public void testGetListMapFromJsonArray() {
	
		List<Map<String, Object>> list = JsonUtils.getListMapFromJsonArray(jsonArray);
		
		System.out.println("ListMapFromJsonArray : " + list);
	}
	
	@Test
	public void testGetListMapFromJsonArrayStatVO() {
		List<Map<String, Object>> list = JsonUtils.getListMapFromJsonArrayStatVO(jsonArray2);
		
		System.out.println("ListMapFromJsonArrayStatVO : " + list);
	}

}
