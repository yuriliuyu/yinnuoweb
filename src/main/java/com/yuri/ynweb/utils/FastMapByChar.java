package com.yuri.ynweb.utils;

import java.util.HashMap;

public class FastMapByChar {
	public static HashMap<String,String> HTML_FILTER_MAP = null;
	static {
                char[] s = "<%&=\">';".toCharArray();
                char[] d = "`  ~~```".toCharArray();
		HTML_FILTER_MAP = compileMap(s, d);
	}


	public static String map(char[] srcChars, char[] desChars, String srcstr) {
		if(srcstr == null) return "";
		HashMap<String,String> cmap = compileMap(srcChars, desChars);
		if(cmap == null) {
			System.err.println("ERROR! FastMapByChar.map param error: srcChars' length != desChars'");
			return srcstr;
		}
		return map(cmap, srcstr);
	}
	public static String map(HashMap<String,String> compiledMap, String srcstr) {
		if(srcstr == null) return "";
		StringBuffer des = new StringBuffer(srcstr.length());
		int i = 0;
		while(i < srcstr.length()) {
			char cur = srcstr.charAt(i);
			String mapedChar = (String)compiledMap.get(String.valueOf(cur));
			if(mapedChar == null) des.append(cur);
			else des.append(mapedChar);
			i++;
		}
		return des.toString();
	}
	public static String escapeHTML(String src) {
		return map(HTML_FILTER_MAP, src);
	}

	public static HashMap<String,String> compileMap(char[] srcChars, char[] desChars) {
		if(srcChars == null || desChars == null || desChars.length != desChars.length) return null;
		HashMap<String,String> ret = new HashMap<String,String>();
		for(int i=0; i<srcChars.length; i++) {
			ret.put(String.valueOf(srcChars[i]), String.valueOf(desChars[i]));
		}
		return ret;
	}


	public static String filterHTML(String src) {
		if(src == null) return "";
		String des = src.replaceAll("<", "`");
		des = des.replaceAll("%", " ");
		des = des.replaceAll("&", " ");
		des = des.replaceAll("=", " ");
		des = des.replaceAll("\"", " ");
		des = des.replaceAll(">", "`");
		des = des.replaceAll("'", "`");
		des = des.replaceAll(";", "`");
		return des;
	}

	public static void main(String[] v) {
		//char[] s = "<%&=\">';".toCharArray();
		//char[] d = "12345678".toCharArray();
		String test = "<httt>ho&ho;</h%20ttt><h'tt<t>ho&ho;</h%20ttt>j&&$$$&ha===sd<br>";
		System.out.println(escapeHTML(test));
		System.out.println(filterHTML(test));

		long ts1 = System.currentTimeMillis();
		int times = 1000;
		for(int x=0; x<times; x++)
			escapeHTML(test);

		long ts2 = System.currentTimeMillis();
		for(int x=0; x<times; x++) {
			filterHTML(test);
		}
		long ts3 = System.currentTimeMillis();

		System.out.println((ts2-ts1) + " : " + (ts3-ts2));
	}
}
