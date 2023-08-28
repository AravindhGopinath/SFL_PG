package org.runner;

import baseclass.BaseClass;

public class Sathish extends BaseClass {

	public static void main(String[] args) {

//		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

		launchBrowser("FIREFOX");

		loadUrl("https://www.google.com");

	}

}
