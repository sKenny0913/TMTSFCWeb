package com.tmt.sfc;

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

import com.dao.AOI_POJO;
import com.dao.MyBatisDAO;
import com.dao.Part_POJO;


/**
 * Servlet implementation class SelectToJSON
 */
@WebServlet("/DynamicSelect_Part")
public class Part_DynamicSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Part_DynamicSelect() {
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
//		String strCcd_setting_sid = request.getParameter("Ccd_setting_sid");
		String strPartNo = request.getParameter("PartNo");
		String strCapacity = request.getParameter("Capacity");
		String strYear = request.getParameter("Year");
		// response.getWriter().write(strSQLexecute);

		try {

				MyBatisDAO Part_DAO = new MyBatisDAO();
				// Village Part_ = new Village();

				Map<String, Object> params = new HashMap<String, Object>();
				// params.put("ccd_setting_sid", strCcd_setting_sid);
				params.put("PART_NO", strPartNo);
				params.put("HDD_VALUE", strCapacity);
				params.put("YEAR_LIMITATION", strYear);
//				System.out.println(params.values());
//				 response.getWriter().write(params.values().toString());
				
				List<Part_POJO> listPart = Part_DAO.getPartSelectList(params);
				JSONArray jArray = new JSONArray();
				for (Part_POJO Part : listPart) {
					JSONObject jObjNew = new JSONObject();
//					response.getWriter().write(Part.getPartNo());
					jObjNew.put("PART_NO", Part.getPartNo());
					jObjNew.put("HDD_VALUE", Part.getCapacity());
					jObjNew.put("YEAR_LIMITATION", Part.getYear());
					jArray.put(jObjNew);
				}

//				 response.setContentType("text/html");
				JSONObject jObjDevice = new JSONObject();
				jObjDevice.put("stations", jArray);
//				System.out.println(jObjDevice.toString());
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
