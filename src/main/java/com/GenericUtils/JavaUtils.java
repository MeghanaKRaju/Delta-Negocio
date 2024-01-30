package com.GenericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	/**
	 * This method is used to get the random number
	 * @return
	 */
	public int getRandom(int digit)
	{
		Random ran= new Random();
		int random = ran.nextInt(digit);
		return random;
	}

	/**
	 * This method is used to get System date
	 * @return
	 */

	public String getSystemDate()
	{
		Date dt = new Date();
		String date = dt.toString();
		return date;
	}

	/**
	 * This method is used to get system date in format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date dt = new Date();
		//String date = dt.toString();
		String SystemDateInFormat = dateFormat.format(dt);
		return SystemDateInFormat;
	}

}
