package com.dao.admin;
import com.po.admin.admindetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("admindetail")
@Mapper
public interface adminlogindao {
	//����������û������Ҷ�Ӧ�����룬���α��ϵ�һ������ɹ�
	public String checkadmin(String adminName);

}
