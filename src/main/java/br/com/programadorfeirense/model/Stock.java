package br.com.programadorfeirense.model;

import org.apache.commons.csv.CSVFormat;

/** Representa uma ação na bolsa. Usa indicadores fundamentalistas indicados por Tiago Reis. https://www.sunoresearch.com.br/artigos/os-indicadores-mais-importantes-em-uma-analise/*/
public class Stock {
	/** P/L: preço/lucro*/
	private float pl;
	/** DY dividend yeld*/
	private float dy;
	/** P/VPA (Preço/Valor Patrimonial por Ação);*/
	private float pvpa;
	/** EV/EBITDA (Enteprise Value/Earnings Before Taxes Interest Depreciation and Amortization).*/
	private float evebitda;
	/** ticker código da ação na bolsa*/
	private String ticker;
	/** Inicia apenas com o ticker*/
	public Stock(String ticker) {
		this.ticker=ticker;
		pl=0;
		dy=0;
		pvpa=0;
		evebitda=0;
	}
	/** Cria a classe usando o ticker os indicadores*/
	public Stock(String ticker, float pl, float dy, float pvpa, float evebitda) {
		super();
		this.ticker = ticker;
		this.pl = pl;
		this.dy = dy;
		this.pvpa = pvpa;
		this.evebitda = evebitda;
	}
	public float getPl() {
		return pl;
	}
	public void setPl(float pl) {
		this.pl = pl;
	}
	public float getDy() {
		return dy;
	}
	public void setDy(float dy) {
		this.dy = dy;
	}
	public float getPvpa() {
		return pvpa;
	}
	public void setPvpa(float pvpa) {
		this.pvpa = pvpa;
	}
	public float getEvebitda() {
		return evebitda;
	}
	public void setEvebitda(float evebitda) {
		this.evebitda = evebitda;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	public String toString() {
		StringBuilder line=new StringBuilder();
		line.append(ticker);
		line.append(CSVFormat.DEFAULT.getDelimiter());
		line.append(pl);
		line.append(CSVFormat.DEFAULT.getDelimiter());
		line.append(dy);
		line.append(CSVFormat.DEFAULT.getDelimiter());
		line.append(pvpa);
		line.append(CSVFormat.DEFAULT.getDelimiter());
		line.append(evebitda);
		return line.toString();
	}

}
