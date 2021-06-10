package com.fourshark.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, //2MB maxFileSize =
 * 1024 * 1024 *10, //10MB maxRequestSize = 1024 * 1024 * 50) public class
 * FileUtil { public static void uploadFile(HttpServletRequest request,
 * HttpServletResponse response) {
 * response.setContentType("text/html;charset=UTF-8"); try { PrintWriter out =
 * response.getWriter(); int id = Integer.parseInt(request.getParameter("id"));
 * String
 * 
 * Part part = request.getPart("file"); } catch (IOException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); }
 * 
 * 
 * 
 * 
 * } }
 */
	