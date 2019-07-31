package com.webapp.jobs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

import org.apache.commons.io.FileUtils;

public class GetInstrumentCodes {

	
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		
		/*
		 * String File_URL = "https://api.kite.trade/instruments";
		 * 
		 * 
		 * 
		 * ReadableByteChannel readablebytechannel =
		 * 
		 * Channels.newChannel(new URL(File_URL).openStream());
		 * 
		 * 
		 * FileOutputStream fileoutputstream =
		 * 
		 * new FileOutputStream("M:\\BOTProjectFiles\\instruments.csv");
		 * 
		 * FileChannel filechannel =
		 * 
		 * fileoutputstream.getChannel();
		 * 
		 * 
		 * 
		 * filechannel.transferFrom(readablebytechannel, 0, Long.MAX_VALUE);
		 */
		
		FileUtils.copyURLToFile(
				  new URL("https://api.kite.trade/instruments"), 
				  new File("M:\\BOTProjectFiles\\instruments.csv")
				);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
