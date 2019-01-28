package com.tmt.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@WebServlet("/FilePageRefresh")
public class FilePageRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FilePageRefresh() {
		super();
		// TODO Auto-generated constructor stub
	}

protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	// Website you wish to allow to connect
	response.setHeader("Access-Control-Allow-Origin", "*");
	// Request methods you wish to allow
	response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
	// Request headers you wish to allow
	response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");

	
	FileInputStream fis = new FileInputStream("C:/TMT/Config/TMTSFCWeb_Config.properties");
    ResourceBundle config = new PropertyResourceBundle(fis);
	String strDBurl = config.getString("dburl");
	String strDBusername = config.getString("dbusername");
	String strDBpassword = config.getString("dbpassword");
	String strSQL = config.getString("select_SQL5");
	String strFunction = request.getParameter("Function");
	String strSQLexecute = strSQL + " where function = '" + strFunction + "'";
//	response.getWriter().write(strSQLexecute);
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection conn = DriverManager.getConnection(strDBurl, strDBusername, strDBpassword);
	Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet rs = stmt.executeQuery(strSQLexecute);
	ResultSetMetaData rsmd = rs.getMetaData();
	String[] strAryColumnName = new String[rsmd.getColumnCount()];
//			rsmd.getColumnName(1);
	for(int i = 0; i < rsmd.getColumnCount() ; i++){
		strAryColumnName[i] = rsmd.getColumnName(i+1);
//		response.getWriter().write(strAryColumnName[i]);
	}
	
	JSONArray jArray = new JSONArray();
	while (rs.next()) {
		JSONObject jObjNew = new JSONObject();
		jObjNew.put(strAryColumnName[0], rs.getString(1));
		jObjNew.put(strAryColumnName[1], rs.getString(2));
		jObjNew.put(strAryColumnName[2], rs.getString(3));
		jObjNew.put(strAryColumnName[3], rs.getString(4));
		jObjNew.put(strAryColumnName[4], rs.getString(5));
		jObjNew.put(strAryColumnName[5], rs.getString(6));
			jArray.put(jObjNew);
	}

	
//	response.setContentType("text/html");
	JSONObject jObjDevice = new JSONObject();
	jObjDevice.put("stations", jArray);
	response.setContentType("application/json");
	response.getWriter().write(jObjDevice.toString());
	
	
	
//	response.getWriter().write("{\"isSuccess\": true}");
//	response.setContentType("application/json");
//	response.getWriter().write(jObjDevice.toString());
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
//		response.getWriter().write("{\"isSuccess\": false}");
		response.getWriter().write(e.getMessage());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
//		response.getWriter().write("{\"isSuccess\": false}");
		response.getWriter().write(e.getMessage());
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}