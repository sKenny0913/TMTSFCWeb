package com.tmt.sfc;

import java.io.FileInputStream;
import java.io.IOException;
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

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class SelectToJSON
 */
@WebServlet("/Delete_OPC")
public class OPC_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(AOI_Delete.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OPC_Delete() {
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

		PropertyConfigurator.configure("src/log4j.properties");
		
		FileInputStream fis = new FileInputStream("C:/TMT/Config/TMTSFCWeb_Config.properties");
        ResourceBundle config = new PropertyResourceBundle(fis);
		String strDBurl = config.getString("dburl");
		String strDBusername = config.getString("dbusername");
		String strDBpassword = config.getString("dbpassword");
		String strSQL = config.getString("Delete_SQL2");
		String strOpc_node_sid = request.getParameter("Opc_node_sid");

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// response.getWriter().write(strSQLexecute);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(strDBurl, strDBusername, strDBpassword);
//			response.getWriter().write(strSQL2);
//			response.getWriter().write("intCCD_SETTING_SID "+intCCD_SETTING_SID);
			
			String strSQLexecute = strSQL + " where Opc_node_sid='" + strOpc_node_sid + "'";
			
//			response.getWriter().write(strSQLexecute);
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(strSQLexecute);
			conn.commit();

			response.setContentType("text/html");
			response.getWriter().write("{\"isSuccess\": true}");
			log.info(strSQLexecute);
			log.info("{\"isSuccess\": true}");
			// response.setContentType("application/json");
			// response.getWriter().write(jObjDevice.toString());

		} catch (ClassNotFoundException e) {
			response.getWriter().write("{\"isSuccess\": false}");
			log.info("{\"isSuccess\": false}");
			log.error(e.getMessage());
//			 response.getWriter().write(e.getMessage());
		} catch (SQLException e) {
			response.getWriter().write("{\"isSuccess\": false}");
			log.info("{\"isSuccess\": false}");
			log.error(e.getMessage());
//			 response.getWriter().write(e.getMessage());
		} finally {
			try { if (stmt != null) stmt.close(); } catch (Exception e) {e.printStackTrace();};
			try { if (rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();};
			try { if (conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();};
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
