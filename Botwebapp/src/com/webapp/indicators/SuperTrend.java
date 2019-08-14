package com.webapp.indicators;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class SuperTrend {

	public static void main(String[] args) throws Exception {

		// https://kitecharts-aws.zerodha.com/api/chart/341249/30minute?from=2019-07-05&to=2019-07-06
		// StringBuilder url = new
		// StringBuilder("https://kitecharts-aws.zerodha.com/api/chart/");

		URL url;
		// url = new URL("
		// https://kitecharts-aws.zerodha.com/api/chart/341249/30minute?from=2019-07-05&to=2019-07-06");

		// URLConnection conn = url.openConnection();

		// BufferedReader breader = new BufferedReader(new
		// InputStreamReader(conn.getInputStream()));

		String inputline =

				"{\"status\": \"success\", \"data\": { \"candles\":[[\"2019-08-14T09:15:00+0530\",2235.4,2235.4,2210.45,2211.15,293925],[\"2019-08-14T09:30:00+0530\",2211.75,2213,2203.15,2210.05,120027],[\"2019-08-14T09:45:00+0530\",2210.05,2212.5,2207,2209,84775],[\"2019-08-14T10:00:00+0530\",2208.9,2210.95,2205,2208.55,58706],[\"2019-08-14T10:15:00+0530\",2208.6,2225.95,2207.45,2224.45,156057],[\"2019-08-14T10:30:00+0530\",2224.15,2232.5,2221.1,2227.9,398020],[\"2019-08-14T10:45:00+0530\",2227.3,2232,2223.9,2226,73996],[\"2019-08-14T11:00:00+0530\",2226.55,2227.8,2221,2223,83147],[\"2019-08-14T11:15:00+0530\",2223,2227.05,2214.6,2216.4,131668],[\"2019-08-14T11:30:00+0530\",2216.1,2219.8,2210.05,2210.45,101427],[\"2019-08-14T11:45:00+0530\",2210.45,2218.4,2210.45,2213.05,62350],[\"2019-08-14T12:00:00+0530\",2213.45,2217.75,2210.4,2217.05,171270],[\"2019-08-14T12:15:00+0530\",2217.05,2222.8,2217,2220.15,97290],[\"2019-08-14T12:30:00+0530\",2220.05,2221.5,2218.65,2220,88761],[\"2019-08-14T12:45:00+0530\",2220,2221.5,2217.9,2219.4,70278],[\"2019-08-14T13:00:00+0530\",2219.4,2226.65,2219.15,2223.3,69044],[\"2019-08-14T13:15:00+0530\",2223.25,2227,2220.3,2226.75,66226],[\"2019-08-14T13:30:00+0530\",2226.8,2232,2225.5,2231.9,104696],[\"2019-08-14T13:45:00+0530\",2232.45,2232.45,2223.05,2228.9,119031],[\"2019-08-14T14:00:00+0530\",2228.9,2233.4,2227.05,2229.9,141260],[\"2019-08-14T14:15:00+0530\",2229.9,2230.3,2225.45,2228.8,122832],[\"2019-08-14T14:30:00+0530\",2228.85,2230,2216,2225.95,187884],[\"2019-08-14T14:45:00+0530\",2226.1,2231.6,2223,2226.1,188348],[\"2019-08-14T15:00:00+0530\",2226.2,2231.75,2225.2,2229,301632],[\"2019-08-14T15:15:00+0530\",2229,2232.9,2225,2227,260437]]}}";

		String Filename = "M:\\ICM\\GREAT\\data.txt";

		File file = new File(Filename);
		if (!file.exists()) {
			file.createNewFile();
		}

//		FileWriter fw = new FileWriter(file.getAbsolutePath());
//		
//		BufferedWriter writer = new BufferedWriter(fw);
//		
//		while ((inputline=breader.readLine())!=null) {
//			
//			writer.write(inputline);
//			
//			
//		}
//		
//		breader.close();
//		writer.close();

		calculateSuperTrend(inputline);

	}

	private static void calculateSuperTrend(String inputline) throws Exception {

		JSONObject obj = new JSONObject(inputline);

		JSONArray candlearrays = obj.getJSONObject("data").getJSONArray("candles");

		System.out.println(candlearrays.toString());

		ArrayList<OHLC> list = new ArrayList<OHLC>();

		for (int i = 0; i < candlearrays.length(); i++) {

			JSONArray array = candlearrays.getJSONArray(i);

			System.out.println(array.toString());

			OHLC ohlc = new OHLC();

			ohlc.setOpenprice(Double.parseDouble(array.get(1).toString()));

			ohlc.setHighprice(Double.parseDouble(array.get(2).toString()));

			ohlc.setLowprice(Double.parseDouble(array.get(3).toString()));

			ohlc.setCloseprice(Double.parseDouble(array.get(4).toString()));

			list.add(ohlc);

		}
		System.out.println(list.toString());

		{

			calculateTR(list);
			calculateATR(list, 11);

		}
	}

	private static double calculateTR(ArrayList<OHLC> list) {

		for (int i = 0; i < list.size(); i++) {

			if (i == 0) {

				list.get(i).setTR(list.get(i).getHighprice() - list.get(i).getLowprice());

			}

			if ((list.get(i).getHighprice() - list.get(i).getLowprice()) > list.get(i).getHighprice()
					- list.get(i - 1).getCloseprice()

					&& list.get(i).getHighprice() - list.get(i).getLowprice() > list.get(i).getLowprice()
							- list.get(i - 1).getCloseprice())

				list.get(i).setTR(list.get(i).getHighprice() - list.get(i).getLowprice());

			else if (list.get(i).getHighprice()
					- list.get(i - 1).getCloseprice() > (list.get(i).getHighprice() - list.get(i).getLowprice())

					&& list.get(i).getHighprice() - list.get(i - 1).getCloseprice() > list.get(i).getLowprice()
							- list.get(i - 1).getCloseprice())

				list.get(i).setTR(list.get(i).getHighprice() - list.get(i - 1).getCloseprice());

			else
				list.get(i).setTR(list.get(i).getLowprice() - list.get(i - 1).getCloseprice());

		}
		return 0.0;

	}

	private static void calculateATR(ArrayList<OHLC> list, int period) {

		ArrayList<Double> TR = new ArrayList<Double>();
		
		
		for (int i = 0; i < list.size(); i++) {

			if (i < period) {

				list.get(i).setATR(0.0);

				continue;

			}

			else {
				
				
				
				
			}

		}

	}
}

class OHLC {

	double openprice;

	double highprice;

	double lowprice;

	double closeprice;

	double TR;

	double ATR;

	public double getOpenprice() {
		return openprice;
	}

	public void setOpenprice(double openprice) {
		this.openprice = openprice;
	}

	public double getHighprice() {
		return highprice;
	}

	public void setHighprice(double highprice) {
		this.highprice = highprice;
	}

	public double getLowprice() {
		return lowprice;
	}

	public void setLowprice(double lowprice) {
		this.lowprice = lowprice;
	}

	public double getCloseprice() {
		return closeprice;
	}

	public void setCloseprice(double closeprice) {
		this.closeprice = closeprice;
	}

	public double getTR() {
		return TR;
	}

	public void setTR(double tR) {
		TR = tR;
	}

	public double getATR() {
		return ATR;
	}

	public void setATR(double aTR) {
		ATR = aTR;
	}
}
