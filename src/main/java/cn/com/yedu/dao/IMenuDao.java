package cn.com.yedu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IMenuDao {

	public List<Map<String,String>> generateMenu(@Param("appId") String appId,@Param("parentId") String parentId);
	
}
