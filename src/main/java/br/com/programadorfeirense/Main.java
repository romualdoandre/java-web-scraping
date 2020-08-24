package br.com.programadorfeirense;

import java.io.FileWriter;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.io.FileUtils;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import br.com.programadorfeirense.factory.StockFactory;
import br.com.programadorfeirense.model.Stock;

public class Main {

	public static void main(String[] args) {
		
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		try {
			List<String> tickers= FileUtils.readLines(FileUtils.getFile("ibovespa.txt"), "utf-8");
			CSVPrinter printer = new CSVPrinter(new FileWriter("stocks.csv"),
					CSVFormat.DEFAULT.withHeader("ticker", "P/L","DY","P/VPA","EV/EBITDA"));
			for(String ticker:tickers) {
				String searchUrl = "https://www.fundamentus.com.br/detalhes.php?papel=" + ticker;
				HtmlPage page = client.getPage(searchUrl);
				StockFactory factory=new StockFactory(page);
				Stock stock=factory.buildStock(ticker);
				// salvando no CSV
				stock.print(printer);
			}
			
			printer.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.close();
		}

	}

}
