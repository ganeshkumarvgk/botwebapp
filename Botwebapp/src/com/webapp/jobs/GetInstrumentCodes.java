package com.webapp.jobs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

		/*
		 * FileUtils.copyURLToFile( new URL("https://api.kite.trade/instruments"), new
		 * File("M:\\BOTProjectFiles\\instruments.csv") );
		 */

		FileInputStream inputstream = new FileInputStream("M:\\BOTProjectFiles\\instruments.csv");

		BufferedReader br = new BufferedReader(new InputStreamReader(inputstream));

		String line;

		int count = 0;
		int count1 = 0;

		StringBuilder FUTresult = new StringBuilder();
		StringBuilder EQresult = new StringBuilder();

		FileOutputStream FUTout = new FileOutputStream("M:\\BOTProjectFiles\\FUTDataCDS.csv");
		FileOutputStream Eqout = new FileOutputStream("M:\\BOTProjectFiles\\EQDataNSE.csv");

		while ((line = br.readLine()) != null) {

			if (line.contains("FUT,CDS-FUT,CDS")) {
				count++;

				FUTresult.append(line);
				FUTresult.append("\n");

				System.out.println(line);
			}
			/*
			 * if (line.contains("EQ") && line.contains("NSE") &&
			 * !line.contains("NSE-INDICES") && !line.contains("INDICES") &&
			 * !line.contains("BSE")) { count1++;
			 * 
			 * EQresult.append(line); EQresult.append("\n"); System.out.println(line); }
			 */
			
			if(line.contains("EQ,NSE,NSE")) {
				count1++;
				EQresult.append(line); 
				EQresult.append("\n"); 
				//System.out.println(line);
				
			}
		}

		FUTout.write(FUTresult.toString().getBytes());
		Eqout.write(EQresult.toString().getBytes());

		System.out.println("Byte Array " + FUTresult.toString().getBytes());
		System.out.println("Number of lines printed" + count);
		System.out.println("Number of EQ lines printed" + count1);
		FUTout.close();
		Eqout.close();
		br.close();

	}
}
