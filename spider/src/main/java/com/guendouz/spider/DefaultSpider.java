/**
 * 
 */
package com.guendouz.spider;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * a Default implementation of a Spider functions.
 */
public class DefaultSpider {

	/**
	 * fetch all links from a page and save them to a List object.
	 * 
	 * @param url
	 *            the page url.
	 * 
	 * @return a List object containing all the links in a page.
	 */
	public List<String> fetch(String url) {
		ArrayList<String> result = new ArrayList<>();
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			Elements urls = doc.select("a[href]");

			for (Element link : urls)
				result.add(link.attr("href"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * fetch and download all links from a page and save them to a file use this
	 * method if you have to save the result of fetch method to a local file.
	 * 
	 * @param url
	 *            the page url.
	 * 
	 * @param filename
	 *            the file name
	 */
	public void download(String url, String filename) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(filename));
			ArrayList<String> links = (ArrayList<String>) fetch(url);
			for (String link : links) {
				writer.write(link);
				writer.newLine();
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
