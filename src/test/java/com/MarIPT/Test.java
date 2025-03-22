package com.MarIPT;


import com.MarIPT.base.BaseClass;

public class Test extends BaseClass{
	
	public void nvn() {
		System.out.println();
	}
	
	public void navin() {
		System.out.println();
	}

	
	public static void main(String[] args) {
		browserLaunch("chrome");
		launchUrl("https://www.google.com/");
		System.out.println("BROWSER id:" + Thread.currentThread().getId());
		exitBrowser(driver);
	}
	
}
