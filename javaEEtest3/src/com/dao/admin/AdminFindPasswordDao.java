package com.dao.admin;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("adminFindPasswordDao")
@Mapper
public interface AdminFindPasswordDao {
//ɾ���û�
	void deleteAuse(String uname);
	
}
