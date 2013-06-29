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
 * DmozSpider fetch links from an Dmoz.org directory.
 */
public class DmozSpider extends DefaultSpider {

	@Override
	public List<String> fetch(String url) {
		ArrayList<String> result = new ArrayList<>();
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			Elements urls = doc.select("ul.directory-url li a");

			for (Element link : urls)
				result.add(link.attr("href"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
