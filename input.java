import java.io.FileReader;
import com.opencsv.CSVReader;
import java.util.ArrayList;
import java.util.Arrays;


public class input {



    public static void main(String[] args) {
        try {
            String CSV_FILE_PATH = "./test_data.csv";
            readData(CSV_FILE_PATH);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void readData(String file){
        ArrayList<String> staffData = new ArrayList<String>();
        ArrayDirectory arrayDirectory = new ArrayDirectory();
        ArrayListDirectory arrayListDirectory = new ArrayListDirectory();

        try{
            FileReader fileReader = new FileReader(file);

            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while((nextLine = csvReader.readNext()) != null){
                for(String value : nextLine){
                    staffData.add(value);
                }
                arrayDirectory.storeInArray(staffData);
                arrayListDirectory.storeInArray(staffData);
                staffData.clear();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        arrayDirectory.printArray();
        arrayListDirectory.printArray();
    }

}
