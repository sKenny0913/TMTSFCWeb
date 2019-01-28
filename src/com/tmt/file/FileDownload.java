package com.tmt.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class guru_download
 */
@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userAgent = request.getHeader("user-agent");
		// System.out.println(userAgent);
		String charset = "Big5";
		if (userAgent.indexOf("Chrome") != -1) {
			charset = "UTF-8";
		}
		// Website you wish to allow to connect
		response.setHeader("Access-Control-Allow-Origin", "*");
		// Request methods you wish to allow
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		// Request headers you wish to allow
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");

//		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
		// String strFileName = "123";
		// String strFunction = "456";
		System.setProperty("file.encoding", "UTF-8");
		String strFileName = request.getParameter("FileName");
		String strFunction = request.getParameter("Function");
		String strFilePath = null; // get from DB
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(strFileName.getBytes(charset), "iso-8859-1") + "\"");
		
//		new String(strFileName.getBytes("iso-8859-1"), charset)
		// out.println(strFileName + " " + strFunction);

		FileInputStream fis = new FileInputStream("C:/TMT/Config/TMTSFCWeb_Config.properties");
		ResourceBundle config = new PropertyResourceBundle(fis);
		String strDBurl = config.getString("dburl");
		String strDBusername = config.getString("dbusername");
		String strDBpassword = config.getString("dbpassword");
		String strSQL = config.getString("select_SQL5");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String strSQLexecute = strSQL + " where function = '" + strFunction + "' and filename =  '" + strFileName
					+ "'";
			// out.println(strSQLexecute);
			// response.getWriter().write(strDesc);
			// response.getWriter().write(strSQLexecute);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(strDBurl, strDBusername, strDBpassword);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(strSQLexecute);
			rs.next();
			strFilePath = rs.getString(3);
//			 out.println(strFilePath);

		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
//			out.println(e3.getMessage());
			e3.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			out.println(e.getMessage());
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		File file = new File(strFilePath);
		response.setContentLength((int) file.length());
	    
	    FileInputStream fis2 = null;
	    try {
	        fis2 = new FileInputStream(file);
	        byte[] buffer = new byte[128];
	        int count = 0;
	        while ((count = fis2.read(buffer)) > 0) {
	        	response.getOutputStream().write(buffer, 0, count);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    	response.getOutputStream().flush();
	    	response.getOutputStream().close();
	        fis2.close();
	    }
		
		
		
//		FileInputStream fileInputStream = new FileInputStream(strFilePath);
		
//		int i;
//		while ((i = fileInputStream.read()) != -1) {
//			out.write(i);
//		}
//		fileInputStream.close();
//		out.close();
	}

}