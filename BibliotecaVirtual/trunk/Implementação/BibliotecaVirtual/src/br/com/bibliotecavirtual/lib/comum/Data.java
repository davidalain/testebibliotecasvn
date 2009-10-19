package br.com.bibliotecavirtual.lib.comum;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data extends Date
{
	
	private DateFormat formatter;
	
	public Data() 
	{
		super();
		
	}
	
	public Data(String format) throws ParseException
	{
		super();
		
		this.formatter = new SimpleDateFormat("dd-MM-yyyy");
		
	}
	



	@Override
	public String toString() 
	{
		return this.formatter.format(this);
	}

}
