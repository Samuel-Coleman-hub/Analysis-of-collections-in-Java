import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArrayDirectory implements Directory {
    private int entriesSize = 1001;
    private Entry entries[] = new Entry[entriesSize];


    public void storeInArray(ArrayList<String> staffData){
        Entry entry = new Entry(staffData);

        for(int i = 0; i<= 1000;i++){
            if(entries[i] == null){
                entries[i] = entry;
            }else{

            }
        }
    }

    //Delete after
    public void printArray(){
        System.out.println(Arrays.toString(entries));
        System.out.println(entries[0].getInitials() + " " + entries[0].getSurname() + " " +
                entries[0].getTelephoneExtension());
    }

    @Override
    public void insertEntry(Entry entry) {

    }

    @Override
    public void deleteEntryUsingName(String surname) {

    }

    @Override
    public void deleteEntryUsingExtension(String number) {

    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {

    }

    @Override
    public String lookupExtension(String surname) {
        return null;
    }

    @Override
    public List<Entry> toArrayList() {
        return null;
    }
}
