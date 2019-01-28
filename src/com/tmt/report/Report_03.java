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
import com.dao.Report_03_POJO;

/**
 * Servlet implementation class SelectToJSON
 */
@WebServlet("/Report_03")
public class Report_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Report_03() {
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
		String sSTATION = request.getParameter("Station");
		String sSN = request.getParameter("SN");
		String sHDD_ID = request.getParameter("HDD_ID");
		
		try {

			MyBatisDAO MyBatisDAO = new MyBatisDAO();

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("WO", sWO);
			params.put("STATION", sSTATION);
			params.put("SN", sSN);
			params.put("HDD_ID", sHDD_ID);
			
			List<Report_03_POJO> listReport_03 = MyBatisDAO.getReport_03SelectListMap(params);
			JSONArray jArray = new JSONArray();
			for (Report_03_POJO Report_03 : listReport_03) {

				JSONObject jObjNew = new JSONObject();
				jObjNew.put("WO", Report_03.getWO());
				jObjNew.put("STATION", Report_03.getSTATION());
				jObjNew.put("HDD_ID", Report_03.getHDD_ID());
				jObjNew.put("SN", Report_03.getSN());
				jObjNew.put("Test_Result", Report_03.getTest_Result());
				jObjNew.put("Test_Content", Report_03.getTest_Content());
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
