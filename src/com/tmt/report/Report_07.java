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
import com.dao.Report_07_POJO;

/**
 * Servlet implementation class SelectToJSON
 */
@WebServlet("/Report_07")
public class Report_07 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Report_07() {
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
		String sBILL_NO = request.getParameter("WO");
		String sSTATION_CODE = request.getParameter("STATION");
		String sSKU = request.getParameter("SKU");
		String sSN = request.getParameter("SN");
		
		try {

			MyBatisDAO MyBatisDAO = new MyBatisDAO();

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("BILL_NO", sBILL_NO);
			params.put("STATION_CODE", sSTATION_CODE);
			params.put("SKU", sSKU);
			params.put("SN", sSN);

			List<Report_07_POJO> listReport_07 = MyBatisDAO.getReport_07SelectListMap(params);
			JSONArray jArray = new JSONArray();
			for (Report_07_POJO Report_07 : listReport_07) {

				JSONObject jObjNew = new JSONObject();
				jObjNew.put("BILL_NO", Report_07.getBILL_NO());
				jObjNew.put("STATION_CODE", Report_07.getSTATION_CODE());
				jObjNew.put("SKU", Report_07.getSKU());
				jObjNew.put("SN", Report_07.getSN());
				jObjNew.put("PRODUCT_LEVEL", Report_07.getPRODUCT_LEVEL());
				jObjNew.put("PARAMETER", Report_07.getPARAMETER());
				jObjNew.put("VALUE", Report_07.getVALUE());
				jObjNew.put("UPDATETIME", Report_07.getUPDATETIME());
				jArray.put(jObjNew);

			}

//			 response.setContentType("text/html");
			JSONObject jObjDevice = new JSONObject();
			jObjDevice.put("stations", jArray);
			System.out.println(jObjDevice.toString());
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
