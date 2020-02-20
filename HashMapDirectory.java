import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapDirectory implements Directory {
    HashMap<String, Entry> entriesBySurname = new HashMap<String, Entry>();
    HashMap<String, Entry> entriesByExtension = new HashMap<String, Entry>();

    public void printArray(){
        try {
            System.out.println(entriesBySurname.get("Coleman").getInitials());
        }catch(Exception e){

        }
    }

    @Override
    public void insertEntry(Entry entry) {
        entriesBySurname.put(entry.getSurname(), entry);
        entriesByExtension.put(Integer.toString(entry.getTelephoneExtension()), entry);
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        entriesBySurname.remove(surname);
    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        entriesByExtension.remove(Integer.parseInt(number));
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        Entry entry = entriesBySurname.get(surname);
        entriesByExtension.remove(entry.getTelephoneExtension());
        entriesBySurname.remove(surname);
        entry.setTelephoneExtension(Integer.parseInt(newNumber));
        entriesBySurname.put(surname, entry);
        entriesByExtension.put(newNumber, entry);
    }

    @Override
    public String lookupExtension(String surname) {
        return Integer.toString(entriesBySurname.get(surname).getTelephoneExtension());
    }

    @Override
    public List<Entry> toArrayList() {
        List<Entry> arrayList = new ArrayList<Entry>(entriesBySurname.values());
        return arrayList;
    }
}
