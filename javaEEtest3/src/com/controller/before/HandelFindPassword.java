/*
 * ���������һ�
 */
package com.controller.before;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.before.MyUser;
import com.service.admin.FindPasswordWait;
import com.service.before.FindPasswordClient;
import com.service.before.FindPasswordService;

@Controller
@RequestMapping("/before")
public class HandelFindPassword {
	@Autowired
	private FindPasswordService FindPasswordService;
	@RequestMapping("/findpassword")
	 
	public String findpassword(@ModelAttribute("userlogin") MyUser userlogin,Model model, HttpSession session,HttpServletResponse response) throws InterruptedException
	{
		//��login.jspǰ̨�ϼ��ϻ�ȡÿһ�ε��û�������浽model��,���ڴ���Ŀͻ��˴��͹�ȥ�û���
		//������������
		//�ٷ�������:�һ�����
		//ʹ��socketͨ��
				//���ж��Ƿ��û�������
		MyUser userlogin2= (MyUser) session.getAttribute("userlogin");
		String msg=FindPasswordService.findpassword(userlogin2);
		PrintWriter out;
		if(msg.equals("û�и��û�"))
		{
			//System.out.println(msg);
			//session.invalidate();
			//model.addAttribute("admindetail", new admindetail());
			
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				out = response.getWriter();
				
				out.append("<script language='javascript'>alert('û�и��û�,��ʼ��ת����ʼҳ��!');parent.location.href='http://localhost:8080/javaEEtest3/tologin.jsp'</script>");
				out.flush();
				//out.print("<script>alert('û�и��û�!');window.location.href='tologin.jsp'</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			FindPasswordClient a=new FindPasswordClient();
			//��ʼ����������
			//FindPasswordWait b=new FindPasswordWait();
			//b.init();
			//�ͻ��˴����û�����ȥ
			a.initclient(msg);
			//��ȡ���Է������˻���
			//���ÿͻ��˵ȴ�3s
			//TimeUnit.SECONDS.sleep(3);
			//�ȴӷ������˴�����Ϣ���ͻ���
			
			FindPasswordWait b=new FindPasswordWait();
//unamex:������û���			<br><c:out value="${unamex}" default="�ο�" />11<br>

//			b.serversend(b.getTemp22());
//			System.out.println("abb="+b.getTemp22()+"Controller���������˷�����Ϣ");
//			//�ͻ����յ���Ϣ
//		String serverreturn=a.getback();
//		System.out.println("�������˷�����Ϣ"+serverreturn);
//			if (serverreturn!=null)
//			{
//			
//			}
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			try {
				out = response.getWriter();
				out.append("<script language='javascript'>alert('�޸ĳɹ�,��ʼ��ת��ע��ҳ��!');parent.location.href='http://localhost:8080/javaEEtest3/before/toregister'</script>");
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
				//�û�������,������û����ļ�¼���
		
		//model.addAttribute("admindetail", new admindetail());
		return "redirect:/before/toLogin";
		
		
				
				//������ת����½ҳ��

		
		
		
		
	}
}
