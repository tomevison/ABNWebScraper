package Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class CSVReader {

	public int read(String csvFilePath, String csvFileName, String csvOutputName) {
		GetABN getAbn = new GetABN();
		FileWriter fw = null;
		int csvTotalLines = 0;
		String line = "";
		String cvsSplitBy = ",";
		String FILE_HEADER = "SearchTerm,ABN,Company Name,State,Postcode" + "\n";

		// create the file writer
		try {
			fw = new FileWriter(csvFilePath + csvOutputName);
			// Write the CSV file header
			fw.append(FILE_HEADER.toString());
		} catch (IOException e) {
			System.out.println("Could not write to file " + e);
		}

		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath + csvFileName))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String searchTerm = null;
				String[] splitLine = line.split(cvsSplitBy);
				try {
					// grab the customer name to search
					// Customer state was also included, however this was returning less results
					searchTerm = splitLine[1];
				} catch (ArrayIndexOutOfBoundsException e1) {
					// check that search value is not null
					System.out.println("Please check Customer Name: " + splitLine[1]);
					e1.printStackTrace();
				}

				Company company = new Company();
				try {
					String returnString[] = GetABN.getABN(searchTerm);
					
					if (customerIsAustralian(splitLine[10])) {
						company.setAbn(returnString[1]);
						company.setName(returnString[5]);
						company.setState(returnString[11]);
						company.setPostcode(returnString[12]);
					} else {
						company.setAbn("");
						company.setName(searchTerm);
						company.setState("");
						company.setPostcode("");
					}


				} catch (Exception e) {

					company.setAbn("Null");
					company.setName("No results returned while searching for '" + searchTerm + "'");
					company.setState("failed");
					company.setPostcode("failed");
				}

				fw.append(searchTerm + "," + company.getAbn() + "," + company.getName() + "," + company.getState() + ","
						+ company.getPostcode() + "\n");

				System.out.println(company.getAbn() + ": " + company.getName());
				csvTotalLines++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.print("Cannot read line: ");
			System.out.println(e);
		} finally {
			try {
				fw.flush();
				fw.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}
		return csvTotalLines;
	}

	// checks if the company country is Australian
	private boolean customerIsAustralian(String country) {
		if(!country.isEmpty()) {
			if(country.contains("Australia")){
				return true;
			}
			System.out.print("Foreigner!!");
			return false;
		}
		System.out.print("No Country!!");
		return false;
	}

}
