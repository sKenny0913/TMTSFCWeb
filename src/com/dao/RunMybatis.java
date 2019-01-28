package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RunMybatis {
	public static void main(String[] args) throws JSONException {
		// Village AOI_ = new Village();

		// String strCcd_setting_sid = "34";
//		AOI();
		OPC();
		
	}
	
	public static void AOI() {
		String strLine = "";
		String strStation = "";
		String strSku = "";
		String strCommandType = "";
		String strProjectCode = "";
		String strJobCode = "";
		String strN1 = "";
		String strN2 = "";
		String strN3 = "";
		String strN4 = "";
		String strN5 = "";
		String strN6 = "";
		String strN7 = "";
		String strN8 = "";
		String strN9 = "";
		String strN10 = "";
		String strN11 = "";
		String strN12 = "";
		String strN13 = "";
		String strN14 = "";
		String strN15 = "";
		String strNodeKey = "";
		String strCommand = "";
		
//		strProjectCode="717";
//		strJobCode="717";
		if(strProjectCode != "" && !strProjectCode.isEmpty()  && strJobCode != ""  && !strJobCode.isEmpty()) {
			strCommand = strProjectCode + "%;%" + strJobCode;
		}else if(strProjectCode != "" && !strProjectCode.isEmpty()  && strJobCode == ""  && strJobCode.isEmpty()){
			strCommand = strProjectCode + "%;";
		}else if(strProjectCode == "" && strProjectCode.isEmpty()  && strJobCode != ""  && !strJobCode.isEmpty()){
			strCommand = ";%"+strJobCode;
		}else{
			strCommand = strProjectCode +";"+ strJobCode;
		}
		// response.getWriter().write(strSQLexecute);
		try {

			MyBatisDAO AOI_DAO = new MyBatisDAO();
			// Village AOI_ = new Village();

			Map<String, Object> params = new HashMap<String, Object>();
			// params.put("ccd_setting_sid", strCcd_setting_sid);
			params.put("line", strLine);
			params.put("station", strStation);
			params.put("sku", strSku);
			params.put("command_type", strCommandType);
			params.put("command", strCommand);
//			params.put("command", "02184092"+";"+ strJobCode);
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

//			System.out.println(params.values());
			
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
				jObjNew.put("N2", AOI.getN2());
				jObjNew.put("N3", AOI.getN3());
				jObjNew.put("N4", AOI.getN4());
				jObjNew.put("N5", AOI.getN5());
				jObjNew.put("N6", AOI.getN6());
				jObjNew.put("N7", AOI.getN7());
				jObjNew.put("N8", AOI.getN8());
				jObjNew.put("N9", AOI.getN9());
				jObjNew.put("N10", AOI.getN10());
				jObjNew.put("N11", AOI.getN11());
				jObjNew.put("N12", AOI.getN12());
				jObjNew.put("N13", AOI.getN13());
				jObjNew.put("N14", AOI.getN14());
				jObjNew.put("N15", AOI.getN15());
				jObjNew.put("NODEKEY", AOI.getNodeKey());
				jArray.put(jObjNew);

			}

			// response.setContentType("text/html");
			JSONObject jObjDevice = new JSONObject();
			jObjDevice.put("stations", jArray);
			System.out.println(jObjDevice.toString());
			// response.getWriter().write("{\"isSuccess\": true}");
			// response.setContentType("application/json");
			// response.getWriter().write(jObjDevice.toString());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void OPC() {
		String strNode = "";
		String strData_type = "";
		String strAddress = "";
		String strUserid = "";
		String strUpdatetime = "";
		String strDescr = "";
		// response.getWriter().write(strSQLexecute);
		try {

			MyBatisDAO OPC_DAO = new MyBatisDAO();
			// Village OPC_ = new Village();

			Map<String, Object> params = new HashMap<String, Object>();
			// params.put("ccd_setting_sid", strCcd_setting_sid);
			params.put("node", strNode);
			params.put("data_type", strData_type);
			params.put("address", strAddress);
			params.put("userid", strUserid);
			params.put("updatetime", strUpdatetime);
//			params.put("command", "02184092"+";"+ strJobCode);
			params.put("descr", strDescr);

//			System.out.println(params.values());
			
			List<OPC_POJO> listOPC = OPC_DAO.getOPCSelectList(params);
			JSONArray jArray = new JSONArray();
			for (OPC_POJO OPC : listOPC) {

				JSONObject jObjNew = new JSONObject();
				jObjNew.put("NODE", OPC.getId());
				jObjNew.put("DATA_TYPE", OPC.getData_type());
				jObjNew.put("ADDRESS", OPC.getAddress());
				jObjNew.put("USERID", OPC.getUserid());
				jObjNew.put("UPDATETIME", OPC.getUpdatetime());
				jObjNew.put("DESCR", OPC.getDesc());
				jArray.put(jObjNew);

			}

			// response.setContentType("text/html");
			JSONObject jObjDevice = new JSONObject();
			jObjDevice.put("stations", jArray);
			System.out.println(jObjDevice.toString());
			// response.getWriter().write("{\"isSuccess\": true}");
			// response.setContentType("application/json");
			// response.getWriter().write(jObjDevice.toString());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
