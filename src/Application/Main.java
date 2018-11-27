package Application;


import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Main {

	public static void main(String[] args) {
		GetABN getABN = new GetABN();
		CSVReader csvReader = new CSVReader();
		
		// pass the reader the csv directory and filename
		String csvFilePath = "C:\\Users\\tomevo\\Desktop\\";
		String csvFileName = "companyList.csv";
		String csvOutputName = "output.csv";
		
		csvReader.read(csvFilePath, csvFileName, csvOutputName);

		  
	}
}

