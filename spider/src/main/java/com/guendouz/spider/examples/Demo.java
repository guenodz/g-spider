/**
 * 
 */
package com.guendouz.spider.examples;

import com.guendouz.spider.YahooSpider;

/**
 * @author Guendouz
 * 
 */
public class Demo {

	private static final String DMOZ_LINK = "http://www.dmoz.org/Computers/Programming/Languages/Python/Books/";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		YahooSpider spider = new YahooSpider();
		System.out.println(spider.fetch(DMOZ_LINK).size());
		spider.download(DMOZ_LINK, "dmoz_links.txt");

	}

}
