package br.com.programadorfeirense.factory;

import org.htmlunit.html.DomNode;
import org.htmlunit.html.HtmlPage;

import br.com.programadorfeirense.model.Stock;

/** Classe para extrair stock de um documento */
public class StockFactory {
	private HtmlPage page;

	public StockFactory(HtmlPage page) {
		this.page = page;
	}

	public Stock buildStock(String ticker) {
		Stock stock = new Stock(ticker);
		DomNode label = page.querySelector(
				"body > div.center > div.conteudo.clearfix > table:nth-child(4) > tbody > tr:nth-child(2) > td:nth-child(3) > span.txt");
		DomNode value = page.querySelector(
				"body > div.center > div.conteudo.clearfix > table:nth-child(4) > tbody > tr:nth-child(2) > td:nth-child(4) > span.txt");

		// P/L
		System.out.println(label.getTextContent());
		System.out.println(value.getTextContent());
		try {
			stock.setPl(Float.valueOf(value.getTextContent().replace(',', '.').trim()));
		} catch (NumberFormatException e) {
			stock.setPl(0);
		}
		// DY
		label = page.querySelector(
				"body > div.center > div.conteudo.clearfix > table:nth-child(4) > tbody > tr:nth-child(9) > td:nth-child(3) > span.txt");
		value = page.querySelector(
				"body > div.center > div.conteudo.clearfix > table:nth-child(4) > tbody > tr:nth-child(9) > td:nth-child(4) > span.txt");
		System.out.println(label.getTextContent());
		System.out.println(value.getTextContent());
		try {
			stock.setDy(Float.valueOf(value.getTextContent().replace(',', '.').replace('%', ' ').trim()));
		} catch (NumberFormatException e) {
			stock.setDy(0);
		}
		// P/VPA
		label = page.querySelector(
				"body > div.center > div.conteudo.clearfix > table:nth-child(4) > tbody > tr:nth-child(3) > td:nth-child(3) > span.txt");
		value = page.querySelector(
				"body > div.center > div.conteudo.clearfix > table:nth-child(4) > tbody > tr:nth-child(3) > td:nth-child(4) > span.txt");
		System.out.println(label.getTextContent());
		System.out.println(value.getTextContent());
		try {
			stock.setPvpa(Float.valueOf(value.getTextContent().replace(',', '.').trim()));
		} catch (NumberFormatException e) {
			stock.setPvpa(0);
		}
		// EV/EBITDA
		label = page.querySelector(
				"body > div.center > div.conteudo.clearfix > table:nth-child(4) > tbody > tr:nth-child(10) > td:nth-child(3) > span.txt");
		value = page.querySelector(
				"body > div.center > div.conteudo.clearfix > table:nth-child(4) > tbody > tr:nth-child(10) > td:nth-child(4) > span.txt");
		System.out.println(label.getTextContent());
		System.out.println(value.getTextContent());
		try {
			stock.setEvebitda(Float.valueOf(value.getTextContent().replace(',', '.').trim()));
		} catch (NumberFormatException e) {
			stock.setEvebitda(0);
		}
		System.out.println(stock);
		return stock;
	}

}
