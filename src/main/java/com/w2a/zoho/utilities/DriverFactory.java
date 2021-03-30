package com.w2a.zoho.utilities;

public class DriverFactory {
	
	
	private static String chomeDriverExePath;
	private static String geckoDriverExePath;
	private static String ieDriverExePath;
	private static String configPropertyFile;
	private static String grid;
	private static boolean isRemote;
	
	
	public static String getGrid() {
		return grid;
	}
	public static void setGrid(String grid) {
		DriverFactory.grid = grid;
	}
	
	
	public static boolean isRemote() {
		return isRemote;
	}
	public static void setRemote(boolean isRemote) {
		DriverFactory.isRemote = isRemote;
	}
	public static String getChomeDriverExePath() {
		return chomeDriverExePath;
	}
	public static void setChomeDriverExePath(String chomeDriverExePath) {
		DriverFactory.chomeDriverExePath = chomeDriverExePath;
	}
	public static String getGeckoDriverExePath() {
		return geckoDriverExePath;
	}
	public static void setGeckoDriverExePath(String geckoDriverExePath) {
		DriverFactory.geckoDriverExePath = geckoDriverExePath;
	}
	public static String getIeDriverExePath() {
		return ieDriverExePath;
	}
	public static void setIeDriverExePath(String ieDriverExePath) {
		DriverFactory.ieDriverExePath = ieDriverExePath;
	}
	public static String getConfigPropertyFile() {
		return configPropertyFile;
	}
	public static void setConfigPropertyFile(String configPropertyFile) {
		DriverFactory.configPropertyFile = configPropertyFile;
	}


}
