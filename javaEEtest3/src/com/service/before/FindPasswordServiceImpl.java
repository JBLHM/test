package com.service.before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.before.UserDao;
import com.po.before.MyUser;
@Service("FindPasswordService")
@Transactional
public class FindPasswordServiceImpl implements FindPasswordService{

	@Autowired
	private UserDao userDao;
	@Override
	public String findpassword(MyUser userlogin) {
		// TODO Auto-generated method stub
		//�ж����ݿ��Ƿ��и��û�
		//���loginusername����,����Ҫ�û�����ɷ���
		String username=userDao.loginusername(userlogin);
		if(username==null)
		{
			//û�и��û�
			System.out.println("û�и��û�");
			return "û�и��û�";
		}
		else
		{
			System.out.println("�û���:"+username);
			return username;
		}
		
	}

	//���ѷ�������,���÷������˵�delate����ɾ���û�
}
