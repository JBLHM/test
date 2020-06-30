package com.service.admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.dao.admin.AdminFindPasswordDao;

/*
 * ��������:�ȴ��ͻ��˴���������
 */

@Transactional
public class FindPasswordWait{

		
	int port=8081;
	
	 ServerSocket serverSocket=null;
	private String temp22=null;
	
	
	 
	 public String getTemp22() {
		return temp22;
	}

	public void setTemp22(String temp22) {
		this.temp22 = temp22;
	}
	Socket clientSocket=null;
	 //���տͻ�����Ϣ
	 BufferedReader br=null;
	//��ȡ��Ӧ������
	 PrintWriter out=null;
	 //�������Կͻ��˵���Ϣ
	 String temp=null;
	public String init()
	{
		System.out.println("������������.....");
		 
		 try {
			 //���������׽���
			serverSocket=new ServerSocket(port);
			clientSocket=serverSocket.accept();
			if(clientSocket==null)
			{
				System.out.println("��������ʧ��");
			}
			else
			{
				System.out.println("�������ӳɹ�");
				br=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				//System.out.println("br="+br.toString());
				 temp=br.readLine();
				
				System.out.println("��ȡ���Կͻ�����Ϣ="+temp);
				//���ݴ��������ݽ���ɾ���û�����
				
				
				
//				while((temp = br.readLine()) != null)
//				{
//					System.out.println("temp="+temp);
//					
//				}
//				

			}
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return temp;
	}
	
public void serversend(String temp2)
{
	System.out.println("�û�"+temp2+"ɾ���ɹ�,���ظ�ҳ��");
	Socket s = null;
	try {
		s = new Socket("localhost",8081);
		 out=new PrintWriter(s.getOutputStream());
		 out.print("�û�"+temp2+"ɾ���ɹ�,���ظ�ҳ��");
		 System.out.println("������������������");
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally
	{
		 try {
			s.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
//	public static void main(String[] args)
//	{
//		FindPasswordWait a=new FindPasswordWait();
//		a.init();
//	}
public void settemp2(String temp2)

{
	this.temp22=temp2;
	System.out.println("temp22="+temp22);
	
}
public String gettemp2()
{
	return this.temp22;
}

}