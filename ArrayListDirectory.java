import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListDirectory implements Directory {
    private ArrayList<Entry> entriesArrayList = new ArrayList<Entry>();

    public void printArray(){
        System.out.println(entriesArrayList.get(entriesArrayList.size() -1).getSurname());
        System.out.println(entriesArrayList.get(3).getSurname());
    }

    @Override
    public void insertEntry(Entry entry) {
        entriesArrayList.add(entry);
    }

    @Override
    public void deleteEntryUsingName(String surname) {
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
        for(int i = 0; i<entriesArrayList.size(); i++){
            if (entriesArrayList.get(i).getTelephoneExtension() == Integer.parseInt(number)){
                entriesArrayList.remove(i);
                break;
            }
        }
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        for(int i = 0; i<entriesArrayList.size(); i++){
            if (entriesArrayList.get(i).getSurname().equals(surname)){
                entriesArrayList.get(i).setTelephoneExtension(Integer.parseInt(newNumber));
            }
        }
    }

    @Override
    public String lookupExtension(String surname) {
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
        return entriesArrayList;
    }
}
