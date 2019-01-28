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

import com.dao.MyBatisDAO;
import com.dao.OPC_POJO;


/**
 * Servlet implementation class SelectToJSON
 */
@WebServlet("/DynamicSelect_OPC")
public class OPC_DynamicSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OPC_DynamicSelect() {
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
		String strNode = request.getParameter("NodeName");;
		String strData_type = request.getParameter("DataType");;
		String strAddress = request.getParameter("Address");;
		String strDescr = request.getParameter("Desc");;
		// response.getWriter().write(strSQLexecute);
		try {

			MyBatisDAO OPC_DAO = new MyBatisDAO();
			// Village OPC_ = new Village();

			Map<String, Object> params = new HashMap<String, Object>();
			// params.put("ccd_setting_sid", strCcd_setting_sid);
			params.put("node", strNode);
			params.put("data_type", strData_type);
			params.put("address", strAddress);
//			params.put("command", "02184092"+";"+ strJobCode);
			params.put("descr", strDescr);

//			System.out.println(params.values());
			
			List<OPC_POJO> listOPC = OPC_DAO.getOPCSelectList(params);
			JSONArray jArray = new JSONArray();
			for (OPC_POJO OPC : listOPC) {

				JSONObject jObjNew = new JSONObject();
				jObjNew.put("OPC_NODE_SID", OPC.getId());
				jObjNew.put("NODE", OPC.getNode());
				jObjNew.put("DATA_TYPE", OPC.getData_type());
				jObjNew.put("ADDRESS", OPC.getAddress());
				if(OPC.getUserid() == null) {
					jObjNew.put("USERID", "");
				}else {
					jObjNew.put("USERID", OPC.getUserid());
				}
				if(OPC.getUpdatetime() == null) {
					jObjNew.put("UPDATETIME", "");
				}else {
					jObjNew.put("UPDATETIME", OPC.getUpdatetime());
				}
				jObjNew.put("DESCR", OPC.getDesc());
				jArray.put(jObjNew);

			}

			// response.setContentType("text/html");
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
