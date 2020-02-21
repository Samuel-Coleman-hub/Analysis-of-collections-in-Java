import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapDirectory implements Directory {
    HashMap<String, Entry> entriesBySurname = new HashMap<String, Entry>();
    HashMap<String, Entry> entriesByExtension = new HashMap<String, Entry>();

    @Override
    public void insertEntry(Entry entry) {
        //Inserts entries into the array
        entriesBySurname.put(entry.getSurname(), entry);
        entriesByExtension.put(Integer.toString(entry.getTelephoneExtension()), entry);
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        //Deletes an entry by surname
        entriesBySurname.remove(surname);
    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        //Deletes an entry by telephone extension number
        entriesByExtension.remove(Integer.parseInt(number));
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        //Updates Extension of an entry by finding it by surname
        Entry entry = entriesBySurname.get(surname);
        entriesByExtension.remove(entry.getTelephoneExtension());
        entriesBySurname.remove(surname);
        entry.setTelephoneExtension(Integer.parseInt(newNumber));
        entriesBySurname.put(surname, entry);
        entriesByExtension.put(newNumber, entry);
    }

    @Override
    public String lookupExtension(String surname) {
        //Looks up an entry by its extension number
        return Integer.toString(entriesBySurname.get(surname).getTelephoneExtension());
    }

    @Override
    public List<Entry> toArrayList() {
        //Returns entries in an ArrayList
        List<Entry> arrayList = new ArrayList<Entry>(entriesBySurname.values());
        return arrayList;
    }
}
