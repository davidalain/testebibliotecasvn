package br.com.bibliotecavirtual.lib.comum;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data extends Date
{
	private Date date;
	
	public Data(String format) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		
		this.date = df.parse(format);
	}
	
	
	
	public Date getData() 
	{
		return date;
	}



	public void setData(Date date) {
		this.date = date;
	}



	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		// TODO Auto-generated method stub
		return df.format(this);
	}

}
