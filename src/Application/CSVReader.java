package Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class CSVReader {

	public String read(String csvFilePath, String csvFileName, String csvOutputName) {
		GetABN getAbn = new GetABN();
		FileWriter fw = null;
		
	    String line = "";
	    String cvsSplitBy = ",";
	    String FILE_HEADER = "SearchTerm,ABN,Company Name,State,Postcode" + "\n";
	    
	    // create the file writer
		try {
			fw = new FileWriter(csvFilePath + csvOutputName);
			// Write the CSV file header
			fw.append(FILE_HEADER.toString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath + csvFileName))) {

	        while ((line = br.readLine()) != null) {

	            // use comma as separator
	            String[] splitLine = line.split(cvsSplitBy);
	            String searchTerm = splitLine[0];
	            
	            Company company = new Company();
	            String returnString[] = GetABN.getABN(searchTerm);
	            company.setAbn(returnString[1]);
	            company.setName(returnString[5]);
	            company.setState(returnString[11]);
	            company.setPostcode(returnString[12]);
	            
	            
	            fw.append(searchTerm + "," + 
	                    company.getAbn() +","+ 
	            		company.getName() +","+
	            		company.getState()+","+ 
	            		company.getPostcode() +"\n");
	            
	            
	            System.out.println(company.getAbn() + ": " + company.getName());

	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	        
	    } finally {
            try {
                fw.flush();
                fw.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
	    	
	    }
	    return "";	
	}

}
