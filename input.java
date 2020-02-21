import java.io.FileReader;
import com.opencsv.CSVReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class input {



    public static void main(String[] args) {
        try {
            String CSV_FILE_PATH = "./test_data.csv";
            readData(CSV_FILE_PATH);
            consoleInterface();


        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
    //Reads data from the CSV file and passes it to the different directories
    private static void readData(String file){
        //Creates Objects of the different classes
        ArrayList<String> staffData = new ArrayList<String>();
        ArrayDirectory arrayDirectory = new ArrayDirectory();
        ArrayListDirectory arrayListDirectory = new ArrayListDirectory();
        HashMapDirectory hashMapDirectory = new HashMapDirectory();
        output output = new output();

        try{
            FileReader fileReader = new FileReader(file);

            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextLine;

            //Loops through data in the CSV file
            while((nextLine = csvReader.readNext()) != null){
                for(String value : nextLine){
                    //Stores attributes from the CSV file
                    staffData.add(value);
                }
                //Passes Data to the Directories
                Entry entry = new Entry(staffData);
                arrayDirectory.insertEntry(entry);
                arrayListDirectory.insertEntry(entry);
                hashMapDirectory.insertEntry(entry);
                staffData.clear();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //Calls the ASCII table method and the method to export the entries in a CSV
        output.createTable(arrayListDirectory.toArrayList());
        output.writeToCSV(arrayListDirectory.toArrayList());

    }

    //Method to print the interface to the console
    public static void consoleInterface() {
        String surname = "";
        String initial = "";
        int telephoneExtension = 0;

        ArrayDirectory arrayDirectory = new ArrayDirectory();
        ArrayListDirectory arrayListDirectory = new ArrayListDirectory();
        HashMapDirectory hashMapDirectory = new HashMapDirectory();
        Performance performance = new Performance();


        System.out.println("If you would like to input an entry please press y or n to create performance stats" +
                " textfile.");
        //Reads Users input from the console
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        System.out.println(response);
        //Checks users choice of method and runs accordingly
        if (response.equals("y")) {
            System.out.println("Enter the staffs surname: ");
            try {
                surname = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Please ensure a string is entered for surname. Try again");
                consoleInterface();
            }
            System.out.println("Enter the staffs Initials: ");
            try {
                initial = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Please ensure a string is entered for initials. Try again");
                consoleInterface();
            }
            System.out.println("Enter the staffs telephone extension number");
            try {
                telephoneExtension = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please ensure that you have entered the telephone extension as a number in " +
                        "digits. Try again");
                consoleInterface();
            }
            ArrayList<String> staffData = new ArrayList<>(Arrays.asList(surname, initial, Integer.toString
                    (telephoneExtension)));

            Entry entry = new Entry(staffData);
            arrayDirectory.insertEntry(entry);
            arrayListDirectory.insertEntry(entry);
            hashMapDirectory.insertEntry(entry);

            System.out.println("The entry has been completed");
        } else if (response.equals("n")) {
            System.out.println("Would you like to customise the file location, if yes press y, else press n");
            scanner = new Scanner(System.in);
            response = scanner.nextLine();
            System.out.println(response);
            if (response.equals("y")){
                System.out.println("Write the file location below");
                scanner = new Scanner(System.in);
                String fileLocation = scanner.nextLine();
                System.out.println(response);
                output.WriteToTxt(performance.arrayRecordTime(), fileLocation);
            }
            else if (response.equals("n")){
                String fileLocation = "stats.txt";
                output.WriteToTxt(performance.arrayRecordTime(),fileLocation);
            }

        }else {
            System.out.println("You have selected not to input an entry or create the textfile");
            consoleInterface();
        }
    }


}



