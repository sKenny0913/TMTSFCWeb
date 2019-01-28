package com.tmt.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
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

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		FileInputStream fis = new FileInputStream("C:/TMT/Config/TMTSFCWeb_Config.properties");
		ResourceBundle config = new PropertyResourceBundle(fis);
		String strDBurl = config.getString("dburl");
		String strDBusername = config.getString("dbusername");
		String strDBpassword = config.getString("dbpassword");
		String strSQL = config.getString("select_SQL4");
		String strSQL2 = config.getString("insert_SQL3");
		Connection conn = null;
		Statement stmt = null;
		String strPath = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		PrintWriter out = response.getWriter();
		SmartUpload mySmartUpload = new SmartUpload();
		// String currentDirectoryPath = null;
		// String savePath = "D:/TMT/File/";
		// mySmartUpload.setDenyPhysicalPath(true);
		mySmartUpload.setForcePhysicalPath(true);
		mySmartUpload.initialize(this.getServletConfig(), request, response); // 上传初始化
		// 設定上傳限制
		// 1.限制每個上傳檔的最大長度。20.
		// mySmartUpload.setMaxFileSize(10000000); // 2.限制總上傳資料的長度。
		// mySmartUpload.setTotalMaxFileSize(20000);
		// mySmartUpload.setAllowedFilesList("doc,txt"); //
		// 3.設定允許上傳的檔（通過副檔名限制）,僅允許doc,txt檔。

		try {
			mySmartUpload.setDeniedFilesList("exe,bat,jsp,htm,html,js,,"); // 4.設定禁止上傳的檔（通過副檔名限制）,禁止上傳帶有exe,bat,
																			// jsp,htm,html副檔名的檔和沒有副檔名的檔。
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			out.println(e2.getMessage());
			e2.printStackTrace();
		}
		// Deny physical path

		try {
			mySmartUpload.upload();
		} catch (SmartUploadException e1) {
			// TODO Auto-generated catch block
			out.println(e1.getMessage());
			e1.printStackTrace();
		}

		// 讀取其它資料

		com.jspsmart.upload.Request req = mySmartUpload.getRequest();
		String strFunction = req.getParameter("Function");
		// String strDescription = new
		// String(req.getParameter("Description").getBytes("iso-8859-1"), "Big5");
		String strDescription = req.getParameter("Description");
		String strUserID = req.getParameter("nameUserid");
		// out.println(strFunction);
		try {
			String strSQLexecute = strSQL + " where function = '" + strFunction + "'";
			// response.getWriter().write(strDesc);
			// response.getWriter().write(strSQLexecute);
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(strDBurl, strDBusername, strDBpassword);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(strSQLexecute);
			// out.println(strSQLexecute);
			rs.next();
			strPath = rs.getString(2);

		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			out.println(e3.getMessage());
			e3.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
			e.printStackTrace();
		}

		try {

			// 保存檔
			for (int i = 0; i < mySmartUpload.getFiles().getCount(); i++) {

				com.jspsmart.upload.File file = mySmartUpload.getFiles().getFile(i);

				String strFileName = file.getFileName();
				String strFilePath = strPath + file.getFileName();
				String strSQLexecute = strSQL2 + " VALUES ('" + strFileName + "','" + strFilePath + "','"
						+ strDescription + "','" + strUserID + "','" + dateFormat.format(date) + "','" + strFunction
						+ "')";
				stmt.executeQuery(strSQLexecute);
//				out.println(strSQLexecute);
				conn.commit();
				if (file.isMissing())
					continue;
				try {
					file.saveAs(strPath + file.getFileName());
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					out.println(e.getMessage());
					e.printStackTrace();
					// logger.info("e:"+e);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
		}
		// request.setAttribute("reqFunction", strFunction);
		// request.getRequestDispatcher("/Document").forward(request,response);

		 session.setAttribute("reqFunction", strFunction);
		 response.sendRedirect(request.getContextPath() + "/Document"); //redirect to
		// same page after form action servlet, this will change url address on browser
		out.close();

	}

}