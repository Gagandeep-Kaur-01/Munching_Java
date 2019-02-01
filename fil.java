import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class data {
int id;
String code;
String division;
float site1;
double site2;
float site3;
float site4;
float tiv1;
float tiv2;
int site01;
int site02;
int site03;
int site04;
float point1;
float point2;
String value;
String type;
int point3;


//constructor

private data (int policyID, String statecode, String county,float eq_site_limit, double hu_site_limit, float fl_site_limit, float fr_site_limit,
float tiv_2011, float tiv_2012, int eq_site_deductible, int hu_site_deductible, int fl_site_deductible, int fr_site_deductible, float point_latitude,
float point_longitude, String line, String construction,int point_granularity) {

this.id = Integer.valueOf(policyID);
this.code = statecode;
this.value = line;
this.type = construction;
}

}


public class fil {


public static void main(String[] args) {
String fileName = "data.csv";
File file = new File(fileName);  // to read about file
try {
Scanner inputStream = new Scanner(file);
//List<data> list = new ArrayList<>();
while(inputStream.hasNext()){
String data = inputStream.next();  // gets a whole line
String[] values = data.split(",");

/*
for (int i= 0; i<values.length;i++) {
System.out.println(values [1]); }
*/

System.out.println(data );
//System.out.println(values[15]);
//System.out.println(values[15] == "Commercial" + values[2]);
//System.out.println(values[2]== "ORANGE COUNTY" + "***");
}
inputStream.close();
}
catch(FileNotFoundException e) {
System.out.println("Please give the right path of the file");
// e.printStackTrace();

}
}
}
