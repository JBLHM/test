package com.dao.before;

import java.awt.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.before.reallyupload;
@Repository("reallyuploaddao")
@Mapper
public interface reallyuploadDao { 
	//���ϴ��ļ�·���浽���ݿ�
	public int Treallyupload(reallyupload reallyupload);
	public int updateupload(reallyupload reallyupload);
	//�����û����ҵ������
	//public int getcointaocan(String uprovidename);
	public String getname(reallyupload reallyupload);
}
