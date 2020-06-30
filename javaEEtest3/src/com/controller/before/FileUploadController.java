package com.controller.before;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.po.before.reallyupload;
import com.po.before.upload;
import com.dao.before.reallyuploadDao;
@Controller
//������upload,��Ϊupload upload
@RequestMapping("/upload")
public class FileUploadController {
	// �õ�һ��������¼��־�Ķ���������ӡ��Ϣ��ʱ���ܹ���Ǵ�ӡ�����Ǹ������Ϣ
	private static final Log logger = LogFactory.getLog(FileUploadController.class);
	/**
	 * ���ļ��ϴ�
	 */
	@Autowired
	private reallyuploadDao reallyuploaddao;
	
	@RequestMapping("/onefile")
	public String oneFileUpload( upload upload,HttpServletRequest request, HttpSession session,Model model) {
		/*�ϴ��ļ��ı���λ��"/uploadfiles"����λ����ָ
		workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps��
		������ʹ��*/
		String realpath = "D:\\eclipse-javaweb\\eclipse-woekspace\\ch17";
		//String realpath = request.getServletContext().getRealPath("uploadfiles");
		String fileName = upload.getFilename().getOriginalFilename(); 
		File targetFile = new File(realpath, fileName);
		reallyupload areallyupload=new reallyupload();
		//����uname�Ƿ���ֵ
		String uname=(String) session.getAttribute("unamex");
		int Uploaduid=1;
		int n=0;
		String aname="";
		//String uname="��";
		model.addAttribute("uploadmessage", " ");
		
		if(!targetFile.exists()){  
            targetFile.mkdirs();  
        } 
		else
		{
			
		}
		//�ϴ�
		if(uname.length()>0)
		{
        try { 
        	
        	areallyupload.setUprovidename(uname);
        		//���һ�����ݿ���������Ȱѽ����ȡ����
        	
        	//�ڴ����
        		areallyupload.setUploaduid(Uploaduid);
            	areallyupload.setAdescription(upload.getDescription());
            	areallyupload.setFilename(fileName);
            	areallyupload.setFilepath(realpath);
            	areallyupload.setOffer(30);
            	
            	
            	model.addAttribute("areallyupload", areallyupload);
            	aname=reallyuploaddao.getname(areallyupload);
            	if(aname!=null)
            	{
            		n=reallyuploaddao.updateupload(areallyupload);
            		 
            	}
            	else
            	{
            		n=reallyuploaddao.Treallyupload(areallyupload);
            	}
            	
        	
        	
        		try {
					upload.getFilename().transferTo(targetFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		//�������
            	logger.info("�ɹ�");
            	model.addAttribute("uploadmessage", "�ϴ�ʧ��");
        		 return "/before/showOne";
        	} 
         catch (NullPointerException e)
            {
			// TODO Auto-generated catch block
			model.addAttribute("uploadmessage", "�ϴ�ʧ��");
			e.printStackTrace();
		    } 
		
		
        /*
      		@ModelAttribute FileDomain fileDomain��ͻ�������һ�����ܣ�
      		model.addAttribute("fileDomain",fileDomain)���Դ˴�����Ҫ
         */
		}
		
		return null;
		
	}
	/**
	 * ���ļ��ϴ�
	 */
	
}
