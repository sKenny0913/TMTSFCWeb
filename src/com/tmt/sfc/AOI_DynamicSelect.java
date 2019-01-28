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


/**
 * Servlet implementation class SelectToJSON
 */
@WebServlet("/DynamicSelect_AOI")
public class AOI_DynamicSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AOI_DynamicSelect() {
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
		String strLine = request.getParameter("Line");
		String strStation = request.getParameter("Station");
		String strSku = request.getParameter("Sku");
		String strCommandType = request.getParameter("CommandType");
		String strProjectCode = request.getParameter("ProjectCode");
		String strJobCode = request.getParameter("JobCode");
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
		String strCommand = null;
		// response.getWriter().write(strSQLexecute);

		try {
//			strProjectCode="160";
//			strJobCode="717";
			if(strProjectCode != null && strJobCode != null) {
			if(strProjectCode != "" && !strProjectCode.isEmpty()  && strJobCode != ""  && !strJobCode.isEmpty()) {
				strCommand = strProjectCode + "%;%" + strJobCode;
			}else if(strProjectCode != "" && !strProjectCode.isEmpty()  && strJobCode == ""  && strJobCode.isEmpty()){
				strCommand = strProjectCode + "%;";
			}else if(strProjectCode == "" && strProjectCode.isEmpty()  && strJobCode != ""  && !strJobCode.isEmpty()){
				strCommand = ";%"+strJobCode;
			}else{
				strCommand = strProjectCode + strJobCode;
			}
			}
//			 response.getWriter().write(strCommand);
//			response.getWriter().write("111");

				MyBatisDAO AOI_DAO = new MyBatisDAO();
				// Village AOI_ = new Village();

				Map<String, Object> params = new HashMap<String, Object>();
				// params.put("ccd_setting_sid", strCcd_setting_sid);
				params.put("line", strLine);
				params.put("station", strStation);
				params.put("sku", strSku);
				params.put("command_type", strCommandType);
				params.put("command", strCommand);
//				params.put("command", "02184092"+";"+ strJobCode);
				params.put("n1", strN1);
				params.put("n2", strN2);
				params.put("n3", strN3);
				params.put("n4", strN4);
				params.put("n5", strN5);
				params.put("n6", strN6);
				params.put("n7", strN7);
				params.put("n8", strN8);
				params.put("n9", strN9);
				params.put("n10", strN10);
				params.put("n11", strN11);
				params.put("n12", strN12);
				params.put("n13", strN13);
				params.put("n14", strN14);
				params.put("n15", strN15);
				params.put("nodekey", strNodeKey);

//				System.out.println(params.values());
//				 response.getWriter().write(params.values().toString());
				
				List<AOI_POJO> listAOI = AOI_DAO.getSelectList(params);
				JSONArray jArray = new JSONArray();
				for (AOI_POJO AOI : listAOI) {

					JSONObject jObjNew = new JSONObject();
					jObjNew.put("CCD_SETTING_SID", AOI.getId());
					jObjNew.put("LINE", AOI.getLine());
					jObjNew.put("STATION", AOI.getStation());
					jObjNew.put("SKU", AOI.getSku());
					jObjNew.put("COMMAND_TYPE", AOI.getCommandType());
					jObjNew.put("COMMAND", AOI.getCommand());
					jObjNew.put("N1", AOI.getN1());
					if(AOI.getN2() == null) {
						jObjNew.put("N2", "");
					}else {
						jObjNew.put("N2", AOI.getN2());
					}
					if(AOI.getN3() == null) {
						jObjNew.put("N3", "");
					}else {
						jObjNew.put("N3", AOI.getN3());
					}
					if(AOI.getN4() == null) {
						jObjNew.put("N4", "");
					}else {
						jObjNew.put("N4", AOI.getN4());
					}
					if(AOI.getN5() == null) {
						jObjNew.put("N5", "");
					}else {
						jObjNew.put("N5", AOI.getN5());
					}
					if(AOI.getN6() == null) {
						jObjNew.put("N6", "");
					}else {
						jObjNew.put("N6", AOI.getN6());
					}
					if(AOI.getN7() == null) {
						jObjNew.put("N7", "");
					}else {
						jObjNew.put("N7", AOI.getN7());
					}
					if(AOI.getN8() == null) {
						jObjNew.put("N8", "");
					}else {
						jObjNew.put("N8", AOI.getN8());
					}
					if(AOI.getN9() == null) {
						jObjNew.put("N9", "");
					}else {
						jObjNew.put("N9", AOI.getN9());
					}
					if(AOI.getN10() == null) {
						jObjNew.put("N10", "");
					}else {
						jObjNew.put("N10", AOI.getN10());
					}
					if(AOI.getN11() == null) {
						jObjNew.put("N11", "");
					}else {
						jObjNew.put("N11", AOI.getN11());
					}
					if(AOI.getN12() == null) {
						jObjNew.put("N12", "");
					}else {
						jObjNew.put("N12", AOI.getN12());
					}
					if(AOI.getN13() == null) {
						jObjNew.put("N13", "");
					}else {
						jObjNew.put("N13", AOI.getN13());
					}
					if(AOI.getN14() == null) {
						jObjNew.put("N14", "");
					}else {
						jObjNew.put("N14", AOI.getN14());
					}
					if(AOI.getN15() == null) {
						jObjNew.put("N15", "");
					}else {
						jObjNew.put("N15", AOI.getN15());
					}
					if(AOI.getUserid() == null) {
						jObjNew.put("USERID", "");
					}else {
						jObjNew.put("USERID", AOI.getUserid());
					}
					if(AOI.getUpdatetime() == null) {
						jObjNew.put("UPDATETIME", "");
					}else {
						jObjNew.put("UPDATETIME", AOI.getUpdatetime());
					}
					jObjNew.put("NODEKEY", AOI.getNodeKey());
					jArray.put(jObjNew);

				}

				 response.setContentType("text/html");
				JSONObject jObjDevice = new JSONObject();
				jObjDevice.put("stations", jArray);
//				System.out.println(jObjDevice.toString());
				// response.getWriter().write("{\"isSuccess\": true}");
//				 response.setContentType("application/json");
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
