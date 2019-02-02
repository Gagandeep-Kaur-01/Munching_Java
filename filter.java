import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List; 

	class File { 
					private int policyID;
					private String statecode; 
					private String line;
	
	public File(int policyID, String statecode, String line) {
		this.policyID = policyID;
		this.statecode = statecode;
		this.line = line; 
		}

		public int getPolicy() {
			return policyID; 
			}
			public void setPolicy(int policyID) {
				this.policyID = policyID; 
				}
				public String getcode() {
					return statecode;
					}
					public void setcode(String statecode) { 
					this.statecode = statecode; 
					}
					public String getLine() 
					{
						return line; 
						}
						public void setLine(String line) { 
						this.line = line; 
						} 
						@Override
						public String toString() {
							//if(metadata[15] == "Commercial" ){
							return "File [Id=" + policyID + ", code=" + statecode + ", value=" + line + "]"; 
						//	}
							}
							} 
	


public class filter
{
	public static void main(String... args) 
	{
		List<File> files = readFilesFromCSV("data.csv"); // let's print all the person read from CSV file 
		for (File f : files) {
			System.out.println(f); 
			} 
			} 
			private static List<File> readFilesFromCSV(String fileName) { 
			List<File> files = new ArrayList<>(); 
			Path pathToFile = Paths.get(fileName); 
			try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) 
			{ 
			// read the first line from the csv file 
			String line = br.readLine(); // loop until all lines are read 
			while (line != null) 
			{
		// use string.split to load a string array with the values from // each line of the file, using a comma as the delimiter 
				String[] attributes = line.split(","); 
				File fil = createFile(attributes); 
				
				files.add(fil);  // adding file into array list
				// if end of file reached, line would be null 
				line = br.readLine(); 
				} 
				}
				catch (IOException ioe) 
				{ 
				ioe.printStackTrace();
				} 
				return files; 
				}
				private static File createFile(String[] metadata) 
				{
					int policyID = Integer.parseInt(metadata[0]); 
					String statecode = metadata[1];
					String line = metadata[15]; 
					return new File(policyID, statecode, line);
					}
					}
					
			