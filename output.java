import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class output {
    public static void createTable(List<Entry> entries){

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
}
