package br.com.programadorfeirense;

import java.io.FileWriter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Main {

	public static void main(String[] args) {
		String ticker = "petr4";
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		try {
			String searchUrl = "https://www.fundamentus.com.br/detalhes.php?papel=" + ticker;
			HtmlPage page = client.getPage(searchUrl);
			DomNode label = page.querySelector(
					"body > div.center > div.conteudo.clearfix > table:nth-child(4) > tbody > tr:nth-child(2) > td:nth-child(3) > span.txt");
			DomNode value = page.querySelector(
					"body > div.center > div.conteudo.clearfix > table:nth-child(4) > tbody > tr:nth-child(2) > td:nth-child(4) > span");

			System.out.println(label.getTextContent());
			System.out.println(value.getTextContent());

			// salvando no CSV
			CSVPrinter printer = new CSVPrinter(new FileWriter("stocks.csv"),
					CSVFormat.DEFAULT.withHeader("ticker", "P/L"));
			printer.printRecord(ticker, value.getTextContent().replace(',', '.'));
			printer.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.close();
		}

	}

}
