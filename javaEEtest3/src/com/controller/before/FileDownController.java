package com.controller.before;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.before.downloadDao;
import com.po.before.download;


@Controller
public class FileDownController {
	// �õ�һ��������¼��־�Ķ���������ӡ��Ϣ��ʱ���ܹ���Ǵ�ӡ�����Ǹ������Ϣ
	private static final Log logger = LogFactory.getLog(FileDownController.class);
	/**
	 * ��ʾҪ���ص��ļ�
	 */
	@Autowired
	private downloadDao downloaddao;
	private download downloaddao2;
	Boolean ntn=false;
	@RequestMapping("/showDownFiles")
	public String show(HttpServletRequest request, Model model){
		//��workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\ch7\����
		String realpath = "D:\\eclipse-javaweb\\eclipse-woekspace\\ch17";
		//String realpath = request.getServletContext().getRealPath("uploadfiles");
		//ȡ���û���
		
			
		String unamex=(String) request.getSession().getAttribute("unamex");
		if((downloaddao.getupload(unamex)!=null&&downloaddao.gettaocanname(unamex)!=null))
		{
			downloaddao2=downloaddao.selecttaocancoin(unamex);
			 ntn=downloaddao2.getUuse().equals("ѧϰ��");
			
		}
		else
		{
			
			downloaddao2.setOffer(0);
			ntn=true;
		}
		//ȡ���ײ���
		
		
		//
		
		
		System.out.println(downloaddao2.getUuse());
		if (downloaddao2.getOffer()>5||(ntn==false))
		{
			File dir = new File(realpath);
			File files[] = dir.listFiles();
			//��ȡ��Ŀ¼�µ������ļ���
			ArrayList<String> fileName = new ArrayList<String>();
			for (int i = 0; i < files.length; i++) {
				fileName.add(files[i].getName());
			}
			model.addAttribute("files", fileName);
			return "/before/showDownFiles";
		}
		else
		{
			model.addAttribute("payreal", "�������������û���ײͣ���ǰ�����ײ�");
			return "before/tochoosecost";
		}
	}
	/**
	 * ִ������
	 */
	@RequestMapping("down")
	public String down(@RequestParam String filename, HttpServletRequest request, HttpServletResponse response){
		String aFilePath = null; //Ҫ���ص��ļ�·��
		FileInputStream in = null; //������
		ServletOutputStream out = null; //�����
		try {
			//��workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps����
			aFilePath = request.getServletContext().getRealPath("uploadfiles");
			//���������ļ�ʹ�õı�ͷ
			response.setHeader("Content-Type", "application/x-msdownload" );
			response.setHeader("Content-Disposition", "attachment; filename="
					+ toUTF8String(filename));
			// �����ļ�
			in = new FileInputStream(aFilePath + "\\"+ filename); 
			//�õ���Ӧ������������������ͻ����������������
			out = response.getOutputStream();
			out.flush();
			int aRead = 0;
			byte b[] = new byte[1024];
			while ((aRead = in.read(b)) != -1 & in != null) {
				out.write(b,0,aRead);
			}
			out.flush();
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		logger.info("���سɹ�");
		return null;
	}
	/**
	 * ���ر���ʱ�����ļ����ַ�����ת������
	 */
	public  String toUTF8String(String str){
		StringBuffer sb = new StringBuffer();
		int len = str.length();
		for(int i = 0; i < len; i++){
			//ȡ���ַ��е�ÿ���ַ�
			char c = str.charAt(i);
			//Unicode��ֵ��0-255֮�䣬��������
			if(c >= 0 && c <= 255){
				sb.append(c);
			}else{//ת��UTF-8����
				byte b[];
				try {
					b = Character.toString(c).getBytes("UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					b = null;
				}
				//ת��Ϊ%HH���ַ�����ʽ
				for(int j = 0; j < b.length; j ++){
					int k = b[j];
					if(k < 0){
						k &= 255;
					}
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
}
