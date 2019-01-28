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
import com.dao.Report_05_POJO;

/**
 * Servlet implementation class SelectToJSON
 */
@WebServlet("/Report_05")
public class Report_05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Report_05() {
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
		String sOuterId = request.getParameter("OuterId");
		String sInnerId = request.getParameter("InnerId");
		String sInnerSeq = request.getParameter("InnerSeq");

		try {

				MyBatisDAO MyBatisDAO = new MyBatisDAO();
				// Village Part_ = new Village();

				Map<String, Object> params = new HashMap<String, Object>();
				// params.put("ccd_setting_sid", strCcd_setting_sid);
				params.put("OUTER_ID", sOuterId);
				params.put("INNER_ID", sInnerId);
				params.put("INNER_SEQ", sInnerSeq);
//				System.out.println(params.values());
//				 response.getWriter().write(params.values().toString());
				
				List<Report_05_POJO> listReport_05 = MyBatisDAO.getReport_05SelectListMap(params);
				JSONArray jArray = new JSONArray();
				for (Report_05_POJO Report_05 : listReport_05) {
					JSONObject jObjNew = new JSONObject();
//					response.getWriter().write(Part.getPartNo());
					jObjNew.put("OUTER_ID", Report_05.getOuter_id());
					jObjNew.put("INNER_ID", Report_05.getInner_id());
					jObjNew.put("INNER_SEQ", Report_05.getInner_seq());
					jArray.put(jObjNew);
				}

//				 response.setContentType("text/html");
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
