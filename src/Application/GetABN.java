package Application;

import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class GetABN {
	
	public static String[] getABN(String searchQuery) {
		
		String baseUrl = "https://abr.business.gov.au/Search/ResultsActive?SearchText=";
		
		WebClient client = new WebClient();  
		client.getOptions().setCssEnabled(false);  
		client.getOptions().setJavaScriptEnabled(false);  
		try {
			String searchUrl = baseUrl + URLEncoder.encode(searchQuery, "UTF-8");
			HtmlPage page = client.getPage(searchUrl);
				
			List<HtmlElement> items = (List<HtmlElement>)(Object)page.getByXPath("//input");
			// return only the first search result
			HtmlInput input = (HtmlInput) page.getByXPath("//input[@id='Results_NameItems_0__Compressed']").get(0);
			
			// return the value string as an array
			String parts[] = input.getAttribute("value").split(",");
			return parts;		
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
