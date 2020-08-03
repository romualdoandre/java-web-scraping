package br.com.programadorfeirense;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Main {

	public static void main(String[] args) {
		String searchQuery = "timp3" ;
		WebClient client = new WebClient();  
		client.getOptions().setCssEnabled(false);  
		client.getOptions().setJavaScriptEnabled(false);  
		try {  
		  String searchUrl = "https://www.fundamentus.com.br/detalhes.php?papel="+searchQuery;
		  HtmlPage page = client.getPage(searchUrl);
		  //File file= FileUtils.getFile("timp3.html");
		  DomNode label= page.querySelector("body > div.center > div.conteudo.clearfix > table:nth-child(4) > tbody > tr:nth-child(2) > td:nth-child(3) > span.txt");
		  DomNode value= page.querySelector("body > div.center > div.conteudo.clearfix > table:nth-child(4) > tbody > tr:nth-child(2) > td:nth-child(4) > span.txt");
		  
		  System.out.println(label.getTextContent());
		  System.out.println(value.getTextContent());
		  
		  
		}catch(Exception e){
		  e.printStackTrace();
		}
		finally {
			client.close();
		}

	}

}
