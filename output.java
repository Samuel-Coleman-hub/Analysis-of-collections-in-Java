import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class output {
    public static void createTable(List<Entry> entries){
        //Creates the ASCII table using the data that it is passed

        String leftAlignFormat = "| %-15s | %-8s | %-15s     |%n";
        System.out.format("+-----------------+----------+---------------------+%n");
        System.out.format("| Surname         | Initials | Telephone Extension |%n");
        System.out.format("+-----------------+----------+---------------------+%n");
        for (int i = 0; i <= entries.size() -1; i++) {
            System.out.format(leftAlignFormat, entries.get(i).getSurname(),entries.get(i).getInitials(), entries.get(i)
            .getTelephoneExtension());
        }
        System.out.format("+-----------------+----------+---------------------+%n");
    }

    public static void writeToCSV(List<Entry> entries){
        FileWriter fileWriter = null;
        //Exports data as a CSV file

        try{
            fileWriter = new FileWriter("Staff.csv");
            Iterator i = entries.iterator();
            while(i.hasNext()){
                Entry e = (Entry)i.next();
                fileWriter.append(e.getSurname());
                fileWriter.append(",");
                fileWriter.append(e.getInitials());
                fileWriter.append(",");
                fileWriter.append(Integer.toString(e.getTelephoneExtension()));
                fileWriter.append("\n");
            }
            System.out.println("Written to the CSV");

        }catch(Exception e){
            System.out.println("Could not print to the CSV");
        }
        finally {
            try{
                fileWriter.close();
            }catch(IOException e){
                System.out.println("Was not able to close the fileWriter");
            }
        }

    }

    public static void WriteToTxt(Long[][] performanceStats, String fileLocation){
        FileWriter fileWriter = null;
        //Writes the performance stats to a txt file

        List<String> headingName = new ArrayList<>();
        headingName.add("array Directory InsertEntry() Stats: ");
        headingName.add("array Directory deleteEntryUsingName() Stats: ");
        headingName.add("array Directory deleteEntryUsingExtension() Stats: ");
        headingName.add("array Directory lookUpExtension() Stats: ");
        headingName.add("array List Directory InsertEntry() Stats: ");
        headingName.add("array List Directory deleteEntryUsingName() Stats: ");
        headingName.add("array List Directory deleteEntryUsingExtension() Stats: ");
        headingName.add("array List Directory lookUpExtension() Stats: ");
        headingName.add("HashMap Directory InsertEntry() Stats: ");
        headingName.add("HashMap Directory deleteEntryUsingName() Stats: ");
        headingName.add("HashMap Directory deleteEntryUsingExtension() Stats: ");
        headingName.add("HashMap Directory lookUpExtension() Stats: ");

        try{
            fileWriter = new FileWriter(fileLocation);
            for (int i = 0; i<12; i++){
                fileWriter.append(headingName.get(i));
                fileWriter.append(String.format("%n"));
                fileWriter.append("Worst Case: " + performanceStats[i][0] + "ns");
                fileWriter.append(String.format("%n"));
                fileWriter.append("Average Case: " + performanceStats[i][1] + "ns");
                fileWriter.append(String.format("%n"));
                fileWriter.append("Best case: " + performanceStats[i][2] + "ns");
                fileWriter.append(String.format("%n"));
                fileWriter.append(String.format("%n"));
            }
            System.out.println("Printed to TextFile");
        }catch(Exception e){
            System.out.println("Could not print to TextFile");
            e.printStackTrace();
        }
        finally {
            try{
                fileWriter.close();
            }catch(IOException e){
                System.out.println("Was not able to close the fileWriter");
            }
        }
    }

}
