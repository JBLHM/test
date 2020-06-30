package com.controller.before;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.before.RegisterInitService;
import com.service.before.RegisterInitServiceImpl;
import com.service.before.UserService;

import com.po.before.MyUser;
@Controller
@RequestMapping("/before")
public class beforeLoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private RegisterInitService RegisterInitImpl;
	@RequestMapping("/login")
	public String userlogin(@ModelAttribute("userlogin") MyUser userlogin,Model model, HttpSession session, String code)
	{
		//�˳�һֱ������Ӧ������pasdֵ����������
		//Ӧ��Ҫ����Щ�жϺ����������
		//���session���msg��ֵ
		model.addAttribute("msg", " ");
		//���û����浽session�У������֧�����������ļ�ʱȡ��sessionֵȻ���ж��Ƿ��ǻ�Ա
		session.setAttribute("unamex", userlogin.getUname());
		session.setAttribute("userlogin",userlogin);
		//return "/before/mainBefore";
		return  userService.login(userlogin, model, session, code);
		
		
 } 
	@RequestMapping("/toLogin")
	public String tologin(Model model) {
		model.addAttribute("msg", " ");
		//���session
		model.addAttribute("userlogin", new MyUser());
		//����ӳ����Сд���������Ҳ����Сд?return "/before/Login";
		return "/before/login";
	}
	
	@RequestMapping("/register")
	public String register(@ModelAttribute("userlogin") MyUser userlogin,Model model, HttpSession session, String code)
	{
		//model.addAttribute("userlogin", new MyUser());
		//�˳�һֱ������Ӧ������pasdֵ����������
		//Ӧ��Ҫ����Щ�жϺ����������
		//���session���msg��ֵ
		model.addAttribute("msg", " ");
		//��ʼ����,���в�ѯ����. select * from reallyupload
		if(RegisterInitImpl==null)
		{
			System.out.println("���������RegisterInitImpl����Ϊ��");
		}
		else
		{
			System.out.println("���������RegisterInitImpl�������");
//			RegisterInitImpl.init(userlogin);
			RegisterInitImpl.test(userlogin.getUname());
		}
		
		return  userService.register(userlogin, model, session, code);
		
		
 } 
	@RequestMapping("/toregister")
	public String register(Model model)
	{
		model.addAttribute("userlogin", new MyUser());

		return "/before/register";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//���session
		session.invalidate();
		//model.addAttribute("admindetail", new admindetail());
		return "redirect:/before/toLogin";
	}
	
}
