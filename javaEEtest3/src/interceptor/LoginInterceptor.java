package interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
public class LoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)throws Exception
	{
		String url=request.getRequestURI();
		if(url.indexOf("/before")>=0||url.indexOf("/admindetail")>=0||url.indexOf("/images")>=0||url.indexOf("/css")>=0)
		{
			return true;
		}
		
		HttpSession session=request.getSession();
		//��ȡǰ̨�˺�
		Object unamex=session.getAttribute("unamex");
		//��ȡ��̨�˺�
		Object admindetail=session.getAttribute("admindetail");
		if(unamex!=null||admindetail!=null)
		
			return true;
		
		
		
		request.setAttribute("msg", "��û��½,���ȵ�½");
		//��֤��ˢ������?request.getRequestDispatcher("/WEB-INF/jsp/before/toLogin.jsp").forward(request, response);
		request.getRequestDispatcher("/tologin.jsp").forward(request, response);
		//���Բ���return false,
		return false;
		
		
		
		
		
		
		
	}

}
