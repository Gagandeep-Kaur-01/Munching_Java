import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

	class File {
			
					private String statecode;
						private String county;
					private String values;

	public File(String statecode, String county, String values) {
		
		this.statecode = statecode;
		this.county = county;
		this.values = values;
		}

		
				public String getcode() {
					return statecode;
					}
					public void setcode(String statecode) {
					this.statecode = statecode;
					}

public String getCounty () {
return county;
}
public void setCounty(String county) {
this.county = county;
}					

					public String getValues()
					{
						return values;
						}
						public void setLine(String values) {
						this.values = values;
						}
						@Override
						public String toString() {
						//	if(values == "Commercial" ){
							return "File [statecode=" + statecode + ", county=" + county + ", line=" + values + "]";
						//}
						//else {
					//	System.out.println("Error");
						//}
							}
							}



public class final_filter
{
	public static void main(String[] args)
	{
		List<File> files = readFilesFromCSV("data.csv"); 
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
			String line = br.readLine() ; //  loop until all lines are read
			// int i = Integer.parseInt(line);
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
				//catch(NumberFormatException ex){ // handle exception
                //   System.out.println("Number Format Exception");
                       //   }
				catch (IOException ioe)
				{
				//ioe.printStackTrace();
				System.out.println("Please give the right path of the file");
				}
				return files;
				}
				private static File createFile(String[] metadata)
				{
					//int policyID = Integer.parseInt(metadata[0]);
					String statecode = metadata[1];
						String county = metadata[2];
					String values = metadata[15];
					//if(values == "Commercial" ){
						
					return new File(statecode, county, values);
					//}
					}
					}
