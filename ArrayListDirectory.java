import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListDirectory implements Directory {
    private ArrayList<Entry> entriesArrayList = new ArrayList<Entry>();

    @Override
    public void insertEntry(Entry entry) {
        //Inserts entries into the array
        entriesArrayList.add(entry);
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        //Deletes an entry by surname
        for(int i = 0;i<entriesArrayList.size(); i++){
            if (entriesArrayList.get(i) != null){
                if(entriesArrayList.get(i).getSurname().equals(surname)) {
                    entriesArrayList.remove(i);
                    break;
                }
            }
        }
    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        //Deletes an entry by telephone extension number
        for(int i = 0; i<entriesArrayList.size(); i++){
            if (entriesArrayList.get(i).getTelephoneExtension() == Integer.parseInt(number)){
                entriesArrayList.remove(i);
                break;
            }
        }
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        //Updates Extension of an entry by finding it by surname
        for(int i = 0; i<entriesArrayList.size(); i++){
            if (entriesArrayList.get(i).getSurname().equals(surname)){
                entriesArrayList.get(i).setTelephoneExtension(Integer.parseInt(newNumber));
            }
        }
    }

    @Override
    public String lookupExtension(String surname) {
        //Looks up an entry by its extension number
        String extensionResult = "";
        for(int i = 0; i<entriesArrayList.size(); i++){
            if(entriesArrayList.get(i).getSurname() == surname){
                extensionResult = Integer.toString(entriesArrayList.get(i).getTelephoneExtension());
            }
        }
        return extensionResult;
    }

    @Override
    public List<Entry> toArrayList() {
        //Returns entries in an ArrayList
        return entriesArrayList;
    }
}
