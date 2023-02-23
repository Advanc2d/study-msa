package com.project.test.utils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UtilsTest {
	static HttpServletRequest request;
	static String browser;
	static String ip;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		request = mock(HttpServletRequest.class);
		when(request.getHeader("User-Agent")).thenReturn("edg");
		when(request.getHeader("X-Forwarded-For")).thenReturn("10.10.28.97");
	}

	@Test
	void testGetBrowserType() {
		browser = Utils.getBrowserType(request);
		System.out.println("Browser : " + browser);
	}

	@Test
	void testGetClientIP() {
		ip = Utils.getClientIP(request);
		System.out.println("Ip : " + ip);
	}
	
	@Test
	void testCheckIP() {
		boolean pass = Utils.checkIp(ip, "10.10.27.*");
		
		if (pass) {
			System.out.println("Ip Pass");
		}
		else {
			System.out.println("Ip No Pass");
		}
	}

}
