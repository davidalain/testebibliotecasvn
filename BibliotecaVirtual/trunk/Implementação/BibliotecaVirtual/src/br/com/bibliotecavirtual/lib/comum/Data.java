package br.com.bibliotecavirtual.lib.comum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data extends Date{
	
	public Data(){
		
	}
	
	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		// TODO Auto-generated method stub
		return df.format(this);
	}

}
