package br.com.programadorfeirense.factory;

import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import br.com.programadorfeirense.model.Stock;

/** Classe para extrair stock de um documento*/
public class StockFactory {
	private HtmlPage page;
	public StockFactory(HtmlPage page) {
		this.page=page;
	}
	
	public Stock buildStock(String ticker) {
		Stock stock=new Stock(ticker);
		DomNode label = page.querySelector(
				"body > div.center > div.conteudo.clearfix > table:nth-child(5) > tbody > tr:nth-child(2) > td:nth-child(3) > span.txt");
		DomNode value = page.querySelector(
				"body > div.center > div.conteudo.clearfix > table:nth-child(5) > tbody > tr:nth-child(2) > td:nth-child(4) > span");
		
		System.out.println(label.getTextContent());
		System.out.println(value.getTextContent());
		stock.setPl(Float.valueOf( value.getTextContent().replace(',', '.')));
		System.out.println(stock);
		return stock;
	}

}
