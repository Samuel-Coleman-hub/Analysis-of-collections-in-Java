import java.lang.reflect.Array;
import java.util.ArrayList;

public class Entry {
    private String surname;
    private String initials;
    private int telephoneExtension;

    public String getSurname(){
        return surname;
    }

    public String getInitials(){
        return initials;
    }

    public int getTelephoneExtension(){
        return telephoneExtension;
    }

    public Entry(ArrayList<String> entryData){
        surname = entryData.get(0);
        initials = entryData.get(1);
        telephoneExtension = Integer.parseInt(entryData.get(2));

    }

}
