package Application;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class GetABN {

	public static String[] getABN(String searchQuery) throws IndexOutOfBoundsException, NullPointerException {

		String baseUrl = "https://abr.business.gov.au/Search/ResultsActive?SearchText=";
		String searchUrl = null;
		String parts[];
		HtmlInput input = null;
		HtmlPage page = null;
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		// add the search term to the base URL
		try {
			searchUrl = baseUrl + URLEncoder.encode(searchQuery, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		// load the page
		try {
			page = client.getPage(searchUrl);
		} catch (FailingHttpStatusCodeException | IOException e1) {
			e1.printStackTrace();
		}

		// get the first item from the returned search results
		try {
			input = (HtmlInput) page.getByXPath("//input[@id='Results_NameItems_0__Compressed']").get(0);
		} catch (IndexOutOfBoundsException e) {
			client.close();
			throw e;
		} catch (NullPointerException e) {
			client.close();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		client.close();

		// return the value string as an array
		parts = input.getAttribute("value").split(",");
		return parts;
	}
}
