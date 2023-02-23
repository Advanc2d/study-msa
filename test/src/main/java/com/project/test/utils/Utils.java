package com.project.test.utils;

import javax.servlet.http.HttpServletRequest;

public class Utils {
	public static String getBrowserType(HttpServletRequest request) {
        String browser = "";
        String userAgent = request.getHeader("User-Agent").toLowerCase();
        if (userAgent.indexOf("trident") >= 0 || userAgent.indexOf("msie") >= 0) {
            browser = "IE";
        } else if (userAgent.indexOf("edg") >= 0) {
            browser = "EG";
        } else if (userAgent.indexOf("opr") >= 0 || userAgent.indexOf("opera") >= 0) {
            browser = "OP";
        } else if (userAgent.indexOf("chrome") >= 0) {
            browser = "CR";
        } else if (userAgent.indexOf("safari") >= 0) {
            browser = "SF";
        } else if (userAgent.indexOf("firefox") >= 0) {
            browser = "FF";
        } else {
            browser = "NN";
        }
        return browser;
    }

    public static String getClientIP(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }
    
    public static boolean checkIp(String loginIp, String allowIp) {
        boolean result = true;

        if (loginIp.equals("*.*.*.*") || loginIp.equals("*"))
            return result;

        String loginIpSplit[] = loginIp.split("\\.");
        String allowIpSplit[] = allowIp.split("\\.");

        for (int i = 0; i < allowIpSplit.length; i++) {
            if (allowIpSplit[i].equals(loginIpSplit[i]) || allowIpSplit[i].equals("*")) {
                continue;
            } else {
                result = false;
            }
        }
        return result;
    }
}
