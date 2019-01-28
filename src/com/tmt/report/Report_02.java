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
import com.dao.Report_02_POJO;

/**
 * Servlet implementation class SelectToJSON
 */
@WebServlet("/Report_02")
public class Report_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Report_02() {
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
		String sHDD_REG = request.getParameter("HDD_REG");
		String sPID = request.getParameter("PID");
		
		try {

			MyBatisDAO MyBatisDAO = new MyBatisDAO();

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("BILL_NO", sBILL_NO);
			params.put("STATION", sSTATION);
			params.put("HDD_REG", sHDD_REG);
			params.put("PID", sPID);
			
			List<Report_02_POJO> listReport_02 = MyBatisDAO.getReport_02SelectListMap(params);
			JSONArray jArray = new JSONArray();
			for (Report_02_POJO Report_02 : listReport_02) {

				JSONObject jObjNew = new JSONObject();
				jObjNew.put("WO", Report_02.getBILL_NO());
				jObjNew.put("STATION", Report_02.getSTATION());
				jObjNew.put("HDD_REG", Report_02.getHDD_REG());
				jObjNew.put("PID", Report_02.getPID());
				jObjNew.put("WO_TYPE", Report_02.getWO_TYPE());
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
