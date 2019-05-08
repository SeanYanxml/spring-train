package com.yanxml.spring.train.user.defined.setter.util;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport{
	private String format;
	
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	/*	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		//super.setAsText(text);
		String format="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		try{
			Date date=sdf.parse(text);
			this.setValue(date);//把转换后的值传过去
		}catch(Exception e){
			e.printStackTrace();			
		}
	}*/
    @Override 
	public void setAsText(String text) throws IllegalArgumentException {
		String format = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			Date date = sdf.parse(text);
			this.setValue(date); // 把转换后的值传过去
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
