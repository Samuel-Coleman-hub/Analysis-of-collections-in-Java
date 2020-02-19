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
        System.out.println(entries[0].getInitials() + " " + entries[0].getSurname() + " " +
                entries[0].getTelephoneExtension());
    }

    @Override
    public void insertEntry(Entry entry) {
        entriesSize = entriesSize + 1;
        entries[entries.length] = entry;
    }

    @Override
    public void deleteEntryUsingName(String surname) {

        for(int i = 0; i<=entries.length; i++){
            if(entries[i].getSurname() == surname){
                entries[i] = null;
            }
        }
    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        for(int i = 0; i<=entries.length; i++){
            if(entries[i].getTelephoneExtension() == Integer.parseInt(number)){
                entries[i] = null;
            }
        }
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        for(int i = 0; i<=entries.length; i++){
            if(entries[i].getSurname() == surname){
                entries[i].setTelephoneExtension(Integer.parseInt(newNumber));
            }
        }

    }

    @Override
    public String lookupExtension(String surname) {
        String extensionResult = "";
        for(int i = 0; i<=entries.length; i++){
            if(entries[i].getSurname() == surname){
                extensionResult = Integer.toString(entries[i].getTelephoneExtension());
            }
        }
        return extensionResult;
    }

    @Override
    public List<Entry> toArrayList() {
        return new ArrayList<>(Arrays.asList(entries));
    }
}
