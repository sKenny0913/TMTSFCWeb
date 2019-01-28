package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


public class MyBatisDAO {
	public List<AOI_POJO> getSelectList(Map<String, Object> map) {
		  SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		  List<AOI_POJO> listAOI = session.selectList("com.dao.AOIMapper.dynamicSelect" , map);
		  session.close();
		  return listAOI;
		}
	public List<Part_POJO> getPartSelectList(Map<String, Object> map) {
		  SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		  List<Part_POJO> listPart = session.selectList("com.dao.PartMapper.dynamicSelect" , map);
		  session.close();
		  return listPart;
		}
	public List<User_POJO> getUserSelectList(Map<String, Object> map) {
		  SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		  List<User_POJO> listUser = session.selectList("com.dao.UserMapper.dynamicSelect" , map);
		  session.close();
		  return listUser;
		}
	public void PartUpdate(Map<String, Object> map){
		  SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		  session.update("com.dao.PartMapper.updatePart", map);
		  session.commit();
		  session.close();
		}
	public List<OPC_POJO> getOPCSelectList(Map<String, Object> map) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<OPC_POJO> listOPC = session.selectList("com.dao.OPCMapper.dynamicSelect" , map);
		session.close();
		return listOPC;
	}
	
	public List<Report_01_POJO> getReport_01SelectListMap(Map<String, Object> map ){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Report_01_POJO> listReport = session.selectList("com.dao.Report_01Mapper.dynamicSelect", map);
		session.close();
		return listReport;
	}
	public List<Report_02_POJO> getReport_02SelectListMap(Map<String, Object> map ){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Report_02_POJO> listReport = session.selectList("com.dao.Report_02Mapper.dynamicSelect", map);
		session.close();
		return listReport;
	}
	public List<Report_03_POJO> getReport_03SelectListMap(Map<String, Object> map ){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Report_03_POJO> listReport = session.selectList("com.dao.Report_03Mapper.dynamicSelect", map);
		session.close();
		return listReport;
	}
	public List<Report_04_POJO> getReport_04SelectListMap(Map<String, Object> map ){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Report_04_POJO> listReport = session.selectList("com.dao.Report_04Mapper.dynamicSelect", map);
		session.close();
		return listReport;
	}
	public List<Report_05_POJO> getReport_05SelectListMap(Map<String, Object> map) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Report_05_POJO> listReport = session.selectList("com.dao.Report_05Mapper.dynamicSelect" , map);
		session.close();
		return listReport;
	}	
	public List<Report_07_POJO> getReport_07SelectListMap(Map<String, Object> map) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Report_07_POJO> listReport = session.selectList("com.dao.Report_07Mapper.dynamicSelect" , map);
		session.close();
		return listReport;
	}	
//	public void save(AOI_POJO AOI){
//	  SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
//	  session.insert("com.dao.AOIMapper.insertAOI", AOI);
//	  session.commit();
//	  session.close();
//	}
//	public void update(AOI_POJO AOI){
//	  SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
//	  session.update("com.dao.AOIMapper.updateAOI", AOI);
//	  session.commit();
//	  session.close();
//	}
//	public void delete(Integer id){
//	  SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
//	  session.delete("com.dao.AOIMapper.deleteAOI", id);
//	  session.commit();
//	  session.close();
//	}
//	public AOI_POJO getData(Integer id) {
//	  SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
//	  AOI_POJO AOI = session.selectOne("com.dao.AOIMapper.selectAOI", id);
//	  session.close();
//	  return AOI;
//	}
//	public Map<String, AOI_POJO> getSelectMap(String key) {
//		  SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
//		  Map<String, AOI_POJO> mapAOI = session.selectMap("com.dao.AOIMapper.dynamicSelect" , key);
//		  session.close();
//		  return mapAOI;
//		}
}
