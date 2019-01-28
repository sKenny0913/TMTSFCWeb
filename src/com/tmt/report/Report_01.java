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
import com.dao.Report_01_POJO;

/**
 * Servlet implementation class SelectToJSON
 */
@WebServlet("/Report_01")
public class Report_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Report_01() {
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
		String sBILL_NO = request.getParameter("WO");
		String sSTATION = request.getParameter("Station");
		String sID_TIER = request.getParameter("SN_Type");
		String sSN = request.getParameter("SN");
		
		try {

			MyBatisDAO MyBatisDAO = new MyBatisDAO();

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("BILL_NO", sBILL_NO);
			params.put("STATION", sSTATION);
			params.put("ID_TIER", sID_TIER);
			params.put("SN", sSN);
			
			List<Report_01_POJO> listReport_01 = MyBatisDAO.getReport_01SelectListMap(params);
			JSONArray jArray = new JSONArray();
			for (Report_01_POJO Report_01 : listReport_01) {

				JSONObject jObjNew = new JSONObject();
				jObjNew.put("WO", Report_01.getBILL_NO());
				jObjNew.put("STATION", Report_01.getSTATION());
				jObjNew.put("SN_TYPE", Report_01.getID_TIER());
				jObjNew.put("SN", Report_01.getSN());
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
