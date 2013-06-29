/**
 * 
 */
package com.guendouz.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * YahooSpider fetch links from an Yahoo Directory.
 */
public class YahooSpider extends DefaultSpider {

	@Override
	public List<String> fetch(String url) {
		ArrayList<String> result = new ArrayList<>();
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			Elements urls = doc.select("div.st ul li a:not(a:has(b))");

			for (Element link : urls)
				result.add(link.attr("href"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
