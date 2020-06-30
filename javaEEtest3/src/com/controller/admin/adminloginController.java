package com.controller.admin;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dao.admin.adminlogindao;
import com.po.admin.admindetail;
@Controller
@RequestMapping("/admindetail")
public class adminloginController {
	@Autowired
	private adminlogindao adminlogindao;
	
	@RequestMapping("/adminlogin")
	public String adminlogin(@ModelAttribute("admindetail") admindetail admindetail,BindingResult result,Model model,HttpSession session)
	{
		//�˳�һֱ������Ӧ������pasdֵ����������
		//Ӧ��Ҫ����Щ�жϺ����������
		//���session���msg��ֵ
		model.addAttribute("msg", " ");
		
		String pasd=adminlogindao.checkadmin(admindetail.getAdminName());
		//String pasd="666666";
		//ʹ���βν��ղ���ʱ����Ҫ����������浽model��
					if(pasd.equals(admindetail.getAdminPassword()))
			{
				session.setAttribute("admindetail", admindetail);
						model.addAttribute("msg", "������ȷ�����ڽ�����������...");
				return "/admin/admin-main";
			}
				
					else
					{
				model.addAttribute("msg", "�û�����������������µ�½");
				return "/admin/login" ;
					}
				
			
		
		
			
		
		
	}
	@RequestMapping("/tologin")
	public String tologin(Model model) {
		//���session
		model.addAttribute("admindetail", new admindetail());
		return "/admin/login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//���session
		session.invalidate();
		//model.addAttribute("admindetail", new admindetail());
		return "redirect:/admindetail/tologin";
	}
	//�����Ƿ��½
	
	
}
