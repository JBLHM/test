package com.service.admin;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.po.before.MyUser;
public interface AdminUsesService {
	//����û�
	//public String addAuse(MyUser myuser);
	public String deleteAGoods(String uname, Model model);
	//��ѯ�û�
	public String selectuser(Model model, Integer pageCur, String act);
	//����û�
	public String insertuser(MyUser myuser,Model model);
	//��ѯĳ���û�
	public String selectAGoods(Model model, String uname);
	
	public String updateuse(MyUser myUser,Model model);
}
