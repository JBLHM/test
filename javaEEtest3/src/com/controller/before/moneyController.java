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

import com.service.before.moneyService;
import com.po.admin.admindetail;
import com.po.before.Umoney;
import com.po.before.reallymoney;
@Controller

public class moneyController {
	@Autowired
	private moneyService moneyService;
	@RequestMapping("/choose")
	public String choose(HttpSession session,@ModelAttribute("choosepay") Umoney choosepay,Model model)
	{
		
	
		reallymoney reallymoney=new reallymoney();
		
		
   	 reallymoney.setUname(choosepay.getUname());
   	 reallymoney.setUemail(choosepay.getUemail());
		//session.setAttribute("taocan",choosepay.getChoose() );
	
		//���ղ��������ж����������ײͣ������ײ�����ֵ
		//ʹ��case����
		//if(	session.getAttribute("taocan")!=null)
		/*
		switch(choosepay.getChoose())
	      {
	         case "�ײ�1" :
	         {
	        	 reallymoney.setUlevel("���� ");
	        	 reallymoney.setUprice(0);
	        	 reallymoney.setUuse("ѧϰ��");
	         }
	            break;
	         case "�ײ�2" :
	         {
	        	 reallymoney.setUlevel("1��");
	        	 reallymoney.setUprice(15);
	        	 reallymoney.setUuse("��׼��");
	         }
	        	 break;
	         case "�ײ�3" :
	         {
	        	 reallymoney.setUlevel("1��");
	        	 reallymoney.setUprice(25);
	        	 reallymoney.setUuse("רҵ��");
	         }
	            break;
	         case "�ײ�4" :
	         {
	        	 reallymoney.setUlevel("1��");
	        	 reallymoney.setUprice(45);
	        	 reallymoney.setUuse("��ҵ��");
	         }
	            break;
	         case "�ײ�5" :
	         {
	        	 reallymoney.setUlevel("1��");
	        	 reallymoney.setUprice(110);
	        	 reallymoney.setUuse("��׼��");
	         }
	            break;
	         case "�ײ�6" :
	         {
	        	 reallymoney.setUlevel("1��");
	        	 reallymoney.setUprice(215);
	        	 reallymoney.setUuse("רҵ��");
	         }
		            break;
	         case "�ײ�7" :
	         {
	        	 reallymoney.setUlevel("1��");
	        	 reallymoney.setUprice(320);
	        	 reallymoney.setUuse("��ҵ��");
	         }
		            break;
	         default :
	            System.out.println("ѡ���ײʹ���");
	      }
	      */
	    String achoose=choosepay.getChoose();  
   	if(achoose.equalsIgnoreCase("uone"))  
       {
      	 reallymoney.setUlevel("���� ");
      	 reallymoney.setUprice(0);
      	 reallymoney.setUuse("ѧϰ��");
       }
         
   	else if(achoose.equalsIgnoreCase("utwo"))
   	{
   	 reallymoney.setUlevel("1��");
  	 reallymoney.setUprice(15);
  	 reallymoney.setUuse("��׼��");
   	}
   	else if (achoose.equalsIgnoreCase("uthree"))
   	{
   	 reallymoney.setUlevel("1��");
  	 reallymoney.setUprice(25);
  	 reallymoney.setUuse("רҵ��");
   	}
   	else if (achoose.equalsIgnoreCase( "ufour"))
   	{
   	 reallymoney.setUlevel("1��");
  	 reallymoney.setUprice(45);
  	 reallymoney.setUuse("��ҵ��");
   	}
   	else if (achoose.equalsIgnoreCase("ufive"))
   	{
   	 reallymoney.setUlevel("1��");
  	 reallymoney.setUprice(110);
  	 reallymoney.setUuse("��׼��");
   	}
   	else if (achoose.equalsIgnoreCase("usix"))
   	{
   		reallymoney.setUlevel("1��");
     	 reallymoney.setUprice(215);
     	 reallymoney.setUuse("רҵ��");
   	}
   	else if (achoose.equalsIgnoreCase("useven"))
   	{
   	 reallymoney.setUlevel("1��");
  	 reallymoney.setUprice(320);
  	 reallymoney.setUuse("��ҵ��");
   	}
   	else 
  
       {
      	 System.out.println("ѡ���ײͳ���");
       }
	      
	      
	      
	      
	      
	      
	      
	      
		model.addAttribute(reallymoney);
		
		//�����Ƿ������������������,�����ǳ�������
		return moneyService.handelmoney(reallymoney, model, session);
		//return "before/tochoosecost";
		//����·����ת
		//return "/before/mainBefore";
		
	}
	@RequestMapping("/tochoosecost")
	public String tochoosecost(Model model)
	{
		model.addAttribute("payreal", "");
		return "before/tochoosecost";
	}
	/*
	//showtan����index.jsp
	@RequestMapping("/taocantoindex")
	public String taocantoindex()
	{
		return "before/choostcost";
	}
	
	*/
	@RequestMapping("/toreallychoosecost")
	public String toreallychoosecost(Model model)
	{
		model.addAttribute("choosepay", new Umoney());
		return "before/choosecost";
	}
	
	
	
}
