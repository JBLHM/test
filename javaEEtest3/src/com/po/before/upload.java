package com.po.before;

import org.springframework.web.multipart.MultipartFile;

//���ձ�ܲ���
public class upload {
MultipartFile filename;
String description;
public MultipartFile getFilename() {
	return filename;
}
public void setFilename(MultipartFile filename) {
	this.filename = filename;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
