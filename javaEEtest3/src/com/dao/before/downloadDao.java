package com.dao.before;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.before.download;
@Repository("downloaddao")
@Mapper
public interface downloadDao {

	public download selecttaocancoin(String uname);
	//��ȡ�ϴ�������
	public String getupload(String uname);
	//��ȡ�����ײ��˵�����
	public String gettaocanname(String uname);
}
