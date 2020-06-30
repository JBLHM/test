package com.dao.admin;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.before.MyUser;
@Repository("adminUsesDao")
@Mapper
public interface AdminUsesDao {
	//�����е��û������
	public List<MyUser> selectuse();
	//��ҳ��ѯ�����û�
	public List<MyUser> selectAllusesByPage(Map<String, Object> map);
	//����û�
	public int adduses(MyUser myuse);
	//�����ֲ�ѯ��Ӧ���û�
	public MyUser selectGoodsById(String uname);
	//������ɾ����Ӧ�û�
	//public int deleteAuser(String unamex);
	//�޸��û�
	public int updateuserById(MyUser myuser);
	//ɾ���û�
	public int deleteAGoods(String uname);
}
