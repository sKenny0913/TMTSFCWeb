package com.tmt.sfc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class SelectToJSON
 */
@WebServlet("/Update_AOI")
public class AOI_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(AOI_Update.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AOI_Update() {
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
		String strSQL = config.getString("Update_SQL");
		String strCommand_suffix = config.getString("command_suffix");
		String strCcd_setting_sid = request.getParameter("Ccd_setting_sid");
		String strLine = request.getParameter("Line");
		String strStation = request.getParameter("Station");
		String strSku = request.getParameter("Sku");
		String strCommandType = request.getParameter("CommandType");
		String strProjectCode = request.getParameter("ProjectCode");
		String strJobCode = request.getParameter("JobCode");
		String strCommand = strProjectCode + ";" + strJobCode + strCommand_suffix;
		String strN1 = request.getParameter("N1");
		String strN2 = request.getParameter("N2");
		String strN3 = request.getParameter("N3");
		String strN4 = request.getParameter("N4");
		String strN5 = request.getParameter("N5");
		String strN6 = request.getParameter("N6");
		String strN7 = request.getParameter("N7");
		String strN8 = request.getParameter("N8");
		String strN9 = request.getParameter("N9");
		String strN10 = request.getParameter("N10");
		String strN11 = request.getParameter("N11");
		String strN12 = request.getParameter("N12");
		String strN13 = request.getParameter("N13");
		String strN14 = request.getParameter("N14");
		String strN15 = request.getParameter("N15");
		String strNodeKey = request.getParameter("NodeKey");
		String strUserID = request.getParameter("UserID");
		// request.getParameter("Desc");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;


		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(strDBurl, strDBusername, strDBpassword);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// response.getWriter().write(strSQL2);
			// response.getWriter().write("intCCD_SETTING_SID "+intCCD_SETTING_SID);

			String strSQLexecute = strSQL + "Line='" + strLine + "',Station='" + strStation + "',Sku='" + strSku
					+ "',Command_Type='" + strCommandType + "',Command='" + strCommand + "',N1='" + strN1.toUpperCase() + "',N2='"
					+ strN2 + "',N3='" + strN3 + "',N4='" + strN4 + "',N5='" + strN5 + "',N6='" + strN6 + "',N7='"
					+ strN7 + "',N8='" + strN8 + "',N9='" + strN9 + "',N10='" + strN10 + "',N11='" + strN11 + "',N12='"
					+ strN12 + "',N13='" + strN13 + "',N14='" + strN14 + "',N15='" + strN15 + "',NodeKey='" + strNodeKey
					+ "',USERID='" + strUserID + "',UPDATETIME='" + dateFormat.format(date)
					+ "' where ccd_setting_sid='" + strCcd_setting_sid + "'";

//			 response.getWriter().write(strSQLexecute);

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
			// response.getWriter().write(e.getMessage());
		} catch (SQLException e) {
			response.getWriter().write("{\"isSuccess\": false}");
			log.info("{\"isSuccess\": false}");
			log.error(e.getMessage());
			// response.getWriter().write(e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			;
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			;
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			;
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
