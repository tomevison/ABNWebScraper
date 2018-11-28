package Application;

public class Main {

	public static void main(String[] args) {
		CSVReader csvReader = new CSVReader();
		long startTime = System.nanoTime();
		
		// pass the reader the csv directory and filename
		String csvFilePath = "C:\\Users\\tomevo\\Desktop\\";
		String csvFileName = "CustomersT.csv";
		String csvOutputName = "outputCustomersT.csv";
		int totalLinesParsed = 0;
		
		System.out.println("Reading: " + csvFilePath + csvFileName);
		
		// read the in the CSV
		totalLinesParsed = csvReader.read(csvFilePath, csvFileName, csvOutputName);
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/10000000;  //divide by 1000000 to get milliseconds.
		
		// complete
		System.out.println("Finished parsing: " + totalLinesParsed + " lines in " + duration + "s");
		System.exit(0);
		  
	}
}

