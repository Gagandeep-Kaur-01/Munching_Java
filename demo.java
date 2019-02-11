import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class demo {


    public static void main(String[] args) {

        String csvFile = "data.csv";
        String line = "";
        String csvSplitBy = ",";
        HashMap<String, String> list = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(csvSplitBy);
                list.put(data[0], data[15]);

            }

        } 
		catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(list);
		
    }
 

}