package com.dao.before;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("findPasswordDao")
@Mapper
public interface FindPasswordDao {

	//�ж��û����Ƿ����
	public int checkname(String name);
	
}
