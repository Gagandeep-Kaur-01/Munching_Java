import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.regex.PatternSyntaxException;

class File {
    private String policyID;
    private String statecode;
    private String county;
	private String values;
	private String construction;
    private String point_granularity;
	



public File(String policyID, String statecode, String county,String values, String construction, String point_granularity) { 
        this.policyID = policyID;
        this.statecode = statecode;
        this.county = county;
		this.values = values;
		this.construction = construction;
		this. point_granularity =  point_granularity;
      
    }

public String getid() {
	return policyID;
}
public void setid(String statecode) {
	this.policyID = policyID;
}

    public String getcode() {
        return statecode;
    }

    public void setcode(String statecode) {
        this.statecode = statecode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getValues() {
     
        return values;
        
    }

    public void setValues(String values) {
                
            this.values =values;
             
    }

    public String getConst() {
		return construction;
	}
	
	public void setConst(String construction) {
		this.construction = construction;
	}
	 
	  public String getpoint() {
		return point_granularity;
	}
	
	public void setpoint(String point_granularity) {
		this.point_granularity = point_granularity;
	}
	 
   public String toString() {
   
  return "{id: "+ policyID +", statecode:" + statecode + ", county:" + county + ", line:" + values + ", construction: "+ construction +", granularity: " + point_granularity +" }";
	
    }
    }
	
	
public class conversion {

    public static void main(String[] args) {
		 
        List<File> files = readFilesFromCSV("data.csv");
        for (File f : files) {                                               //for(type var : array) { Statement using var; }
               if(f.getValues().equals("Commercial")) {                //  filter as per requirement
               
				System.out.println(f);
				
		
				}
        }
	}

    private static List<File> readFilesFromCSV(String fileName) {
        List<File> files = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
		
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            // read the first line from the csv file
            String line = br.readLine(); //  loop until all lines are read
       
            while (line != null) {
                // use string.split to load a string array with the values from 
				// each line of the file, using a comma as the delimiter
 
              
			// String[] attributes = line.split(","); 
		 String[] att = attributes[].replaceAll("Cyz@abc.Imnop%jkr/nop", "cyz_abc_Imnip@jkr.nop");    //.split(",");
			String att = Arrays.toString(att);
		
			// att = att.substring(1, att.length()-1).replace("=",":" );
			 
//char[] ch = attributes.toCharArray();
                File fil = createFile(att);

                files.add(fil);  // adding file into array list
                // if end of file reached, line would be null
                line = br.readLine();

            }
        }
		
		
        catch(NumberFormatException ex){ // handle exception
           System.out.println("Number Format Exception");
        }
		
        catch (IOException ioe) {
            //ioe.printStackTrace();
            System.out.println("Please give the right path of the file");
        }
        return files;
    }

    private static File createFile(String[] metadata) {
      
	    String policyID = metadata[0];
        String statecode = metadata[1];
        String county = metadata[2];
        String values = metadata[15];
		String construction = metadata[16];
		String point_granularity = metadata[17];

        
       return new File(policyID,statecode, county, values, construction, point_granularity);
     
    }
}

