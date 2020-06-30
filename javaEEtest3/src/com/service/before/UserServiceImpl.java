package com.service.before;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dao.before.registerinitDao;
import com.dao.before.UserDao;
import com.po.before.MyUser;
import com.po.before.Registerinit;

@Service("userService")
@Transactional
/**����ע��@Transactional,����ָ���������Ҫ��Spring���������
ע��@Transactionalֻ�����public���Է�Χ�ڵķ�����ӣ�
������������Ҫ��������������ֻ�Ǹ��߶������ʹ������*/
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	
	public String register( MyUser userlogin, Model model, HttpSession session, String code) {
		//model.addAttribute("userlogin", new MyUser());
		////����ע�͵���Щ
	
		if(!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("msg", "��֤�����");
			return "before/register";
		}
		
		//����ע�͵���Щ
		int n = userDao.register(userlogin);
		if(n > 0) {
			//������һ��RegisterImpl
//			RegisterInitServiceImpl registerInitImpl=new RegisterInitServiceImpl();
//			registerInitImpl.init(userlogin);
			return "before/mainBefore";
		}else {
			model.addAttribute("msg", "ע��ʧ�ܣ�");
			return "before/register";
		}
	}
	@Override
	public String login( MyUser userlogin, Model model, HttpSession session, String code) {
		//������д���ᱨ404����model.addAttribute("userlogin", new MyUser());
		//����ע�͵���Щ

		if(!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("msg", "��֤�����");
			return "before/login";
		}
		
		//����ע�͵���Щ
		MyUser ruser = null;
		List<MyUser> list = userDao.login(userlogin);
		if(list.size() > 0) {
			ruser = list.get(0);
		}
		if(ruser != null) {
			session.setAttribute("bruser", ruser);
			return "before/mainBefore";
		}else {
			model.addAttribute("msg", "�û������������");
			return "before/Login";
		}
}
	
}
