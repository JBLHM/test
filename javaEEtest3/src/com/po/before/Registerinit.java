package com.po.before;

import org.springframework.web.multipart.MultipartFile;

public class Registerinit {
	//���۱� comment-> commentDao->comment.xml
//	public String uemail;
//
//	public String uword;
//	//���ر� download->downloadDao->download.xml
//	
//	int uploaduid;
//	String uprovidename;
//	String filename;
//	String filepath;
//	//offer:�������
//	int offer;
//	String adescription;
//	String uname;
//	//String uemail;
//	double uprice;
//	String ulevel;
//	String uuse;
	//�û��� MyUser->UserDao->beforelogin.xml
	//private String uname;
//	private String upassword;
//	private String utelephone;
	//�ײͱ� reallymoney ->reallymoneyDao->reallymoney.xml-> money��
	//private String uemail;
//	String uname;
//	String uemail;
//	double uprice;
//	String ulevel;
//	String uuse;
	//�ϴ��� reallyupload->reallyuploadDao->reallyupload.xml->reallyupload��
//	int uploaduid;
	String uprovidename;
	String filename;
	String filepath;
	//offer:�������
	int offer;
	String adescription;
	

	public String getUprovidename() {
		return uprovidename;
	}
	public void setUprovidename(String uprovidename) {
		this.uprovidename = uprovidename;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getOffer() {
		return offer;
	}
	public void setOffer(int offer) {
		this.offer = offer;
	}
	public String getAdescription() {
		return adescription;
	}
	public void setAdescription(String adescription) {
		this.adescription = adescription;
	}
	

}
