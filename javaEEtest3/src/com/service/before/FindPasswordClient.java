package com.service.before;
/*
 * �ͻ���
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class FindPasswordClient {
	Socket clientSocket=null;
	PrintWriter out=null;
	int port=8081;
	BufferedReader br=null;
	ServerSocket serverSocket=null;
	String info=null;
	public  void initclient(String msg)
	{

		System.out.println("ʹ��socketͨ��");
		try {
			clientSocket=new Socket("localhost",8081);
			out=new PrintWriter(clientSocket.getOutputStream());
			
			//out.write(msg);
			out.print(msg);
			
			//System.out.println("�ͻ��˴�������Ϣ:"+msg);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			if(out!=null)
			{
				try {
					out.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
				
			if(clientSocket!=null)
			{
				try {
					clientSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
				
			
		}
	}
	/*
	 * �������Է���������Ϣ
	 */
public String getback() 
{
	System.out.println("����������Ϣ����");
	try {
		//clientSocket=new Socket("localhost",8081);
		System.out.println("�ڷ���������Ϣ����");
		//3����ȡ������������ȡ�������˵���Ӧ��Ϣ
		InputStreamReader is = new InputStreamReader(clientSocket.getInputStream());
		System.out.println("�۷���������Ϣ����");
		BufferedReader br = new BufferedReader(is);
		System.out.println("�ܷ���������Ϣ����");
		 
		 System.out.println("�������˷�����Ϣ"+info);
		while((info=br.readLine())!=null){
		 System.out.println("���ǿͻ��ˣ�������˵��"+info);
		}
		clientSocket.close();
		br.close();
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally
	{
		if(clientSocket!=null)
		{
			try {
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	return info;
	
	
	

}
}
