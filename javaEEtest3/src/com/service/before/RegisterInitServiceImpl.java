package com.service.before;
/*
 * ��ʼ��
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.before.registerinitDao;
import com.po.before.MyUser;
import com.po.before.Registerinit;
@Service("RegisterInitImpl")
@Transactional
public class RegisterInitServiceImpl implements RegisterInitService {
	@Autowired
	private registerinitDao registerInitDao;
	@Override
	public void test(String uname)
	{
		System.out.println("����������.............");
		if(registerInitDao==null)
		{
			System.out.println("��ȡ�����ǿն���");
		}
		registerInitDao.test(uname);
	}
	@Override
	public void init(MyUser userlogin)
	{
	Registerinit ATK=new Registerinit();
	ATK.setAdescription("δ֪");
	ATK.setFilename("δ֪");
	ATK.setOffer(0);
	ATK.setFilepath("δ֪");
	ATK.setUprovidename(userlogin.getUname());
	System.out.println("����:"+ATK.getAdescription()+"�ļ���"+ATK.getFilename()+""+ATK.getUprovidename());
	if(registerInitDao==null)
	{
		System.out.println("��ȡ�����ǿն���");
	}
	else
	{
		System.out.println("��ȡ���Ķ���registerInitDao��Ϊ��");
		registerInitDao.initreallyupload(ATK);
	}
	}
}
