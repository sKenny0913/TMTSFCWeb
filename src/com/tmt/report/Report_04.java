package com.tmt.report;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.dao.MyBatisDAO;
import com.dao.Report_04_POJO;

/**
 * Servlet implementation class SelectToJSON
 */
@WebServlet("/Report_04")
public class Report_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Report_04() {
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
		String sWO = request.getParameter("WO");
		String sHDD_ID = request.getParameter("HDD_ID");
		String sHDD_PN = request.getParameter("sHDD_PN");
		
		try {

			MyBatisDAO MyBatisDAO = new MyBatisDAO();

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("WO", sWO);
			params.put("HDD_ID", sHDD_ID);
			params.put("HDD_PN", sHDD_PN);
			
			List<Report_04_POJO> listReport_04 = MyBatisDAO.getReport_04SelectListMap(params);
			JSONArray jArray = new JSONArray();
			for (Report_04_POJO Report_04 : listReport_04) {

				JSONObject jObjNew = new JSONObject();
				jObjNew.put("WO", Report_04.getWO());
				jObjNew.put("HDD_ID", Report_04.getHDD_ID());
				jObjNew.put("HDD_PN", Report_04.getHDD_PN());
				jArray.put(jObjNew);

			}

//			 response.setContentType("text/html");
			JSONObject jObjDevice = new JSONObject();
			jObjDevice.put("stations", jArray);
//			System.out.println(jObjDevice.toString());
			// response.getWriter().write("{\"isSuccess\": true}");
			 response.setContentType("application/json");
			 response.getWriter().write(jObjDevice.toString());

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
