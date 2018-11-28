package Application;

public class Main {

	public static void main(String[] args) {
		CSVReader csvReader = new CSVReader();
		
		// pass the reader the csv directory and filename
		String csvFilePath = "C:\\Users\\evison\\Desktop\\";
		String csvFileName = "CustomersT.csv";
		String csvOutputName = "outputCustomersT.csv";
		int totalLinesParsed = 0;
		
		System.out.println("Reading: " + csvFilePath + csvFileName);
		
		// read the in the CSV
		totalLinesParsed = csvReader.read(csvFilePath, csvFileName, csvOutputName);
		
		// complete
		System.out.println("Finished parsing: " + totalLinesParsed + " lines.");
		System.exit(0);
		  
	}
}

