package com.tmt.file;

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
 * Servlet implementation class ListFile
 */
@WebServlet("/ListFile")
public class ListFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		FileInputStream fis = new FileInputStream("C:/TMT/Config/TMTSFCWeb_Config.properties");
        ResourceBundle config = new PropertyResourceBundle(fis);
		String strDBurl = config.getString("dburl");
		String strDBusername = config.getString("dbusername");
		String strDBpassword = config.getString("dbpassword");
		String strSQL = config.getString("select_SQL2");

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
				jObjNew.put(strAryColumnName[0], rs.getString(1));
				jObjNew.put(strAryColumnName[1], rs.getString(2));
				jObjNew.put(strAryColumnName[2], rs.getString(3));
				jObjNew.put(strAryColumnName[3], rs.getString(4));
				jObjNew.put(strAryColumnName[4], rs.getString(5));
				jObjNew.put(strAryColumnName[5], rs.getString(6));
				jObjNew.put(strAryColumnName[6], rs.getString(7));
				jObjNew.put(strAryColumnName[7], rs.getString(8) + "");
				jObjNew.put(strAryColumnName[8], rs.getString(9) + "");
				jObjNew.put(strAryColumnName[9], rs.getString(10) + "");
				jObjNew.put(strAryColumnName[10], rs.getString(11) + "");
				jObjNew.put(strAryColumnName[11], rs.getString(12) + "");
				jObjNew.put(strAryColumnName[12], rs.getString(13) + "");
				jObjNew.put(strAryColumnName[13], rs.getString(14) + "");
				jObjNew.put(strAryColumnName[14], rs.getString(15) + "");
				jObjNew.put(strAryColumnName[15], rs.getString(16) + "");
				jObjNew.put(strAryColumnName[16], rs.getString(17) + "");
				jObjNew.put(strAryColumnName[17], rs.getString(18) + "");
				jObjNew.put(strAryColumnName[18], rs.getString(19) + "");
				jObjNew.put(strAryColumnName[19], rs.getString(20) + "");
				jObjNew.put(strAryColumnName[20], rs.getString(21) + "");
				jObjNew.put(strAryColumnName[21], rs.getString(22) + "");
				jObjNew.put(strAryColumnName[22], rs.getString(23) + "");
				jObjNew.put(strAryColumnName[23], rs.getString(24) + "");
				jArray.put(jObjNew);
			}

			// response.setContentType("text/html");
			JSONObject jObjDevice = new JSONObject();
			jObjDevice.put("stations", jArray);
			response.setContentType("application/json");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
