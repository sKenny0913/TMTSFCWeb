package com.tmt.sfc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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

/**
 * Servlet implementation class SelectToJSON
 */
@WebServlet("/Select_Station")
public class Station_select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Station_select() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
//		FileInputStream fis = new FileInputStream("C:/TMT/Config/TMTSFCWeb_Config");
//		String currentDir = System.getProperty("user.dir");
        
        FileInputStream fis = new FileInputStream("C:/TMT/Config/TMTSFCWeb_Config.properties");
        ResourceBundle config = new PropertyResourceBundle(fis);
//		ResourceBundle config = ResourceBundle.getBundle("TMTSFCWeb_Config");
		String strDBurl = config.getString("dburl");
		String strDBusername = config.getString("dbusername");
		String strDBpassword = config.getString("dbpassword");
		String strSQL = config.getString("select_SQL3");
//
		String strSQLexecute = strSQL;
		// response.getWriter().write(strSQLexecute);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(strDBurl, strDBusername, strDBpassword);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(strSQLexecute);
			ResultSetMetaData rsmd = rs.getMetaData();
			String[] strAryColumnName = new String[rsmd.getColumnCount()];
			// rsmd.getColumnName(1);
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				strAryColumnName[i] = rsmd.getColumnName(i + 1);
				// response.getWriter().write(strAryColumnName[i]);
			}

			JSONArray jArray = new JSONArray();
			while (rs.next()) {
				JSONObject jObjNew = new JSONObject();
				jObjNew.put(strAryColumnName[1], rs.getString(2));
				jArray.put(jObjNew);
			}

			 response.setContentType("text/html");
			JSONObject jObjDevice = new JSONObject();
			jObjDevice.put("stationList", jArray);
//			response.setContentType("application/json");
			response.getWriter().write(jObjDevice.toString());

			// response.getWriter().write("{\"isSuccess\": true}");
			// response.setContentType("application/json");
			// response.getWriter().write(jObjDevice.toString());

		} catch (ClassNotFoundException e) {
//			 response.getWriter().write("{\"isSuccess\": false}");
			response.getWriter().write(e.getMessage());
		} catch (SQLException e) {
//			 response.getWriter().write("{\"isSuccess\": false}");
			response.getWriter().write(e.getMessage());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
