package com.dao.before;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.before.Registerinit;
import com.po.before.userpay;
@Repository("registerInitDao")
@Mapper
public interface registerinitDao {
	//��ʼ��comment��
//public void initcomment(String uemail);//���������:����,'�㻹û������'
////��ʼ��download��
//public void initdownload(String uname);//���������:����,δ֪,0
//
//
////��ʼ��reallyupload��
//public void initreallyupload(String uname, String ukn, String ukn2, int mn, String ukn3);
////��ʼ��userpay��
//public void inituserpay(String uname,String uemail);//��������:����,����,0,0,0
////����userpay��
//public userpay getuserpay();
////�������ݵ�userpay(��������),ʹ��replace into���
//public void insertuserpay(userpay userpay);
//��ʼ��money��
public void test(String uname);
public void initreallyupload(Registerinit ATK);//��������:?,����,δ֪,δ֪,0,δ֪
}
