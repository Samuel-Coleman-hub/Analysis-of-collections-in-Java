import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArrayDirectory implements Directory {
    private int entriesSize = 1001;
    private Entry entries[] = new Entry[entriesSize];

    @Override
    public void insertEntry(Entry entry) {
        //Inserts entries into the array
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) {
                entries[i] = entry;
                break;
            }
            //Issue from testing was due to not checking for null
        }


    }


    @Override
    public void deleteEntryUsingName(String surname) {
        //Deletes an entry by surname
        for(int i = 0; i<entries.length; i++){
            if (entries[i] != null){
                if(entries[i].getSurname().equals(surname)){
                    entries[i] = null;
                    break;
                }
                //Issue from testing was due to not checking for null
            }

        }
    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        //Deletes an entry by telephone extension number
        for(int i = 0; i<entries.length; i++){
            //Issue from testing was due to not checking for null
            if(entries[i] != null){
                if(entries[i].getTelephoneExtension() == Integer.parseInt(number)) {
                    entries[i] = null;
                    break;
            }
            }
        }
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        //Updates Extension of an entry by finding it by surname
        for(int i = 0; i<entries.length; i++){
            if(entries[i].getSurname() == surname){
                entries[i].setTelephoneExtension(Integer.parseInt(newNumber));
            }
        }

    }

    @Override
    public String lookupExtension(String surname) {
        //Looks up an entry by its extension number
        String extensionResult = "";
        for(int i = 0; i<entries.length; i++){
            //Issue from testing was due to not checking for null
            if (entries[i] != null) {
                if (entries[i].getSurname() == surname) {
                    extensionResult = Integer.toString(entries[i].getTelephoneExtension());
                }
            }

        }
        return extensionResult;
    }

    @Override
    public List<Entry> toArrayList() {
        //Returns entries in an ArrayList
        return new ArrayList<>(Arrays.asList(entries));
    }
}
