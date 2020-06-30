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


import com.service.before.UserService;
import com.service.before.moneyService;
import com.po.before.MyUser;
@Controller
@RequestMapping("/before�޸İ�")
public class RegisterInitController {
	@Autowired
	private UserService userService;
	@Autowired
	private moneyService moneyService;
	@RequestMapping("/register")
	public String register(@ModelAttribute("userlogin") MyUser userlogin,Model model, HttpSession session, String code)
	{
		//model.addAttribute("userlogin", new MyUser());
		//�˳�һֱ������Ӧ������pasdֵ����������
		//Ӧ��Ҫ����Щ�жϺ����������
		//���session���msg��ֵ
		model.addAttribute("msg", " ");
		return  userService.register(userlogin, model, session, code);
		
		
 } 
	@RequestMapping("/toregister")
	public String register(Model model)
	{
		model.addAttribute("userlogin", new MyUser());

		return "/before/register";
	}
	
	
}
