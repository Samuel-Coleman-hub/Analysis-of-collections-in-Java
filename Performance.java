import com.opencsv.CSVReader;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Performance {

    public Long[][] arrayRecordTime(){

        ArrayDirectory arrayDirectory = new ArrayDirectory();
        ArrayListDirectory arrayListDirectory = new ArrayListDirectory();
        HashMapDirectory hashMapDirectory = new HashMapDirectory();
        StopWatch stopWatch = new StopWatch();
        ArrayList<Long> arrayTimeRecordings = new ArrayList<>();
        ArrayList<String> staffData = new ArrayList<String>();
        try{
            FileReader fileReader = new FileReader("./test_data.csv");

            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextLine;
            int i = 0;

            while((nextLine = csvReader.readNext()) != null){
                for(String value : nextLine){
                    staffData.add(value);
                }
                Entry entry = new Entry(staffData);
                stopWatch.start();
                arrayDirectory.insertEntry(entry);
                stopWatch.stop();
                arrayTimeRecordings.add(stopWatch.getElapsedTime());
                System.out.println(arrayTimeRecordings.get(i));
                stopWatch.reset();
                staffData.clear();
                i++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        long arrayInsertTimeMax = Collections.max(arrayTimeRecordings);
        long arrayInsertTimeMin = Collections.min(arrayTimeRecordings);

        long arrayInsertTimeAverage = calculateAverage(arrayTimeRecordings);

        Long[] arrayInsertStats = {arrayInsertTimeMax,arrayInsertTimeAverage,arrayInsertTimeMin};

        arrayTimeRecordings.clear();

        //Calculates stats for deleting by surname in the ArrayDirectory
        for(int i = 0; i< 1000; i++){
            stopWatch.start();
            arrayDirectory.deleteEntryUsingName(arrayDirectory.toArrayList().get(i).getSurname());
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long arrayDeleteSMax = Collections.max(arrayTimeRecordings);
        long arrayDeleteSMin = Collections.min(arrayTimeRecordings);
        long arrayDeleteSAverage = calculateAverage(arrayTimeRecordings);

        Long[] arrayDeleteSStats = {arrayDeleteSMax,arrayDeleteSAverage,arrayDeleteSMin};

        arrayTimeRecordings.clear();

        //Adds Entries back
        try{
            FileReader fileReader = new FileReader("./test_data.csv");

            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while((nextLine = csvReader.readNext()) != null){
                for(String value : nextLine){
                    staffData.add(value);
                }
                Entry entry = new Entry(staffData);
                arrayDirectory.insertEntry(entry);
                staffData.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //Calculates stats for lookup in the ArrayDirectory
        for (int i = 0; i<1000; i++){
            stopWatch.start();
            arrayDirectory.lookupExtension(Integer.toString(arrayDirectory.toArrayList().get(i).
                    getTelephoneExtension()));
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long arrayLookUpMax = Collections.max(arrayTimeRecordings);
        long arrayLookUpMin = Collections.min(arrayTimeRecordings);
        long arrayLookUpAverage = calculateAverage(arrayTimeRecordings);

        Long[] arrayLookUpStats = {arrayLookUpMax, arrayLookUpAverage,arrayLookUpMin};

        arrayTimeRecordings.clear();

        //Calculates stats for deleting by extension in the ArrayDirectory
        for (int i = 0; i<1000; i++){
            stopWatch.start();
            arrayDirectory.deleteEntryUsingExtension(Integer.toString(arrayDirectory.toArrayList().get(i).
                    getTelephoneExtension()));
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long arrayDeleteEMax = Collections.max(arrayTimeRecordings);
        long arrayDeleteEMin = Collections.min(arrayTimeRecordings);
        long arrayDeleteEAverage = calculateAverage(arrayTimeRecordings);

        Long[] arrayDeleteEStats = {arrayDeleteEMax, arrayDeleteEAverage,arrayDeleteEMin};

        arrayTimeRecordings.clear();

        //Adds Entries back
        //Calculates stats for insertion in the ArrayList
        try{
            FileReader fileReader = new FileReader("./test_data.csv");

            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while((nextLine = csvReader.readNext()) != null){
                for(String value : nextLine){
                    staffData.add(value);
                }
                Entry entry = new Entry(staffData);
                stopWatch.start();
                arrayListDirectory.insertEntry(entry);
                stopWatch.stop();
                arrayTimeRecordings.add(stopWatch.getElapsedTime());
                stopWatch.reset();
                staffData.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long listInsertMax = Collections.max(arrayTimeRecordings);
        long listInsertMin = Collections.min(arrayTimeRecordings);
        long listInsertAverage = calculateAverage(arrayTimeRecordings);

        Long[] listInsertArray = {listInsertMax, listInsertAverage,listInsertMin};

        arrayTimeRecordings.clear();

        //Add entries back

        try{
            FileReader fileReader = new FileReader("./test_data.csv");

            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while((nextLine = csvReader.readNext()) != null){
                for(String value : nextLine){
                    staffData.add(value);
                }
                Entry entry = new Entry(staffData);
                arrayListDirectory.insertEntry(entry);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //Calculates stats for deleting by surname in arrayListDirectory
        for (int i = 0; i<1000; i++){
            stopWatch.start();
            //System.out.println(arrayTimeRecordings.get(i));
            arrayListDirectory.deleteEntryUsingName(arrayListDirectory.toArrayList().get(0).getSurname());
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long listDeleteSMax = Collections.max(arrayTimeRecordings);
        long listDeleteSMin = Collections.min(arrayTimeRecordings);
        long listDeleteSAverage = calculateAverage(arrayTimeRecordings);

        Long[] listDeleteSArray = {listDeleteSMax, listDeleteSAverage,listDeleteSMin};

        arrayTimeRecordings.clear();

        //Add entries back

        try{
            FileReader fileReader = new FileReader("./test_data.csv");

            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while((nextLine = csvReader.readNext()) != null){
                for(String value : nextLine){
                    staffData.add(value);
                }
                Entry entry = new Entry(staffData);
                arrayListDirectory.insertEntry(entry);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //Calculates stats for deleting by extension in arrayListDirectory
        for (int i = 0; i<1000; i++){
            stopWatch.start();
            //System.out.println(arrayTimeRecordings.get(i));
            arrayListDirectory.deleteEntryUsingExtension(Integer.toString(arrayListDirectory.toArrayList().get(i).
                    getTelephoneExtension()));
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long listDeleteEMax = Collections.max(arrayTimeRecordings);
        long listDeleteEMin = Collections.min(arrayTimeRecordings);
        long listDeleteEAverage = calculateAverage(arrayTimeRecordings);

        Long[] listDeleteEArray = {listDeleteEMax, listDeleteEAverage,listDeleteEMin};

        arrayTimeRecordings.clear();

        //Calculates stats for lookup in arrayListDirectory
        for (int i = 0; i<1000; i++){
            stopWatch.start();
            //System.out.println(arrayTimeRecordings.get(i));
            arrayListDirectory.lookupExtension(Integer.toString(arrayListDirectory.toArrayList().get(i).
                            getTelephoneExtension()));
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long listLookUpMax = Collections.max(arrayTimeRecordings);
        long listLookUpMin = Collections.min(arrayTimeRecordings);
        long listLookUpAverage = calculateAverage(arrayTimeRecordings);

        Long[] listlookuUpArray = {listLookUpMax, listLookUpAverage,listLookUpMin};

        arrayTimeRecordings.clear();

        //Calculates stats for insertion in HashMap
        try{
            FileReader fileReader = new FileReader("./test_data.csv");

            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while((nextLine = csvReader.readNext()) != null){
                for(String value : nextLine){
                    staffData.add(value);
                }
                Entry entry = new Entry(staffData);
                //System.out.println(arrayTimeRecordings.get(i));
                stopWatch.start();
                hashMapDirectory.insertEntry(entry);
                stopWatch.stop();
                arrayTimeRecordings.add(stopWatch.getElapsedTime());
                stopWatch.reset();
                staffData.clear();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        long hashMapInsertMax = Collections.max(arrayTimeRecordings);
        long hashMapInsertMin = Collections.min(arrayTimeRecordings);
        long hashMapInsertAverage = calculateAverage(arrayTimeRecordings);

        Long[] hashMapInsertArray = {hashMapInsertMax, hashMapInsertAverage,hashMapInsertMin};

        arrayTimeRecordings.clear();

        //Adds entries back

        try{
            FileReader fileReader = new FileReader("./test_data.csv");

            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while((nextLine = csvReader.readNext()) != null){
                for(String value : nextLine){
                    staffData.add(value);
                }
                Entry entry = new Entry(staffData);
                hashMapDirectory.insertEntry(entry);
                staffData.clear();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //Calculates stats for deleting by surname in HashMapDirectory
        for (int i = 0; i<hashMapDirectory.toArrayList().size(); i++){
            stopWatch.start();
            //System.out.println(arrayTimeRecordings.get(i));
            hashMapDirectory.deleteEntryUsingName(hashMapDirectory.toArrayList().get(0).getSurname());
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long hashMapDeleteSMax = Collections.max(arrayTimeRecordings);
        long hashMapDeleteSMin = Collections.min(arrayTimeRecordings);
        long hashMapDeleteSAverage = calculateAverage(arrayTimeRecordings);

        Long[] hashMapDeleteSArray = {hashMapDeleteSMax, hashMapDeleteSAverage,hashMapDeleteSMin};

        arrayTimeRecordings.clear();

        //Add entries back
        try{
            FileReader fileReader = new FileReader("./test_data.csv");

            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while((nextLine = csvReader.readNext()) != null){
                for(String value : nextLine){
                    staffData.add(value);
                }
                Entry entry = new Entry(staffData);
                hashMapDirectory.insertEntry(entry);
                staffData.clear();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //Calculates stats for deleting by extension in HashMapDirectory
        for (int i = 0; i<hashMapDirectory.toArrayList().size(); i++){
            stopWatch.start();
            hashMapDirectory.deleteEntryUsingExtension(Integer.toString(hashMapDirectory.toArrayList().get(0).
                    getTelephoneExtension()));
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long hashMapDeleteEMax = Collections.max(arrayTimeRecordings);
        long hashMapDeleteEMin = Collections.min(arrayTimeRecordings);
        long hashMapDeleteEAverage = calculateAverage(arrayTimeRecordings);

        Long[] hashMapDeleteEArray = {hashMapDeleteEMax, hashMapDeleteEAverage,hashMapDeleteEMin};

        arrayTimeRecordings.clear();

        //Add entries
        try{
            FileReader fileReader = new FileReader("./test_data.csv");

            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while((nextLine = csvReader.readNext()) != null){
                for(String value : nextLine){
                    staffData.add(value);
                }
                Entry entry = new Entry(staffData);
                hashMapDirectory.insertEntry(entry);
                staffData.clear();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //Calculates stats for lookup in hashMapDirectory
        for (int i = 0; i<hashMapDirectory.toArrayList().size(); i++){
            stopWatch.start();
            hashMapDirectory.lookupExtension(hashMapDirectory.toArrayList().get(i).getSurname());
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long hashMapLookUpMax = Collections.max(arrayTimeRecordings);
        long hashMapLookUpMin = Collections.min(arrayTimeRecordings);
        long hashMapLookUpAverage = calculateAverage(arrayTimeRecordings);

        Long[] hashMapLookUpArray = {hashMapLookUpMax, hashMapLookUpAverage,hashMapLookUpMin};

        arrayTimeRecordings.clear();

        Long[][] performanceTimes = {arrayInsertStats, arrayDeleteSStats, arrayDeleteEStats, arrayLookUpStats,
                listInsertArray, listDeleteSArray, listDeleteEArray, listlookuUpArray,
                hashMapInsertArray, hashMapDeleteSArray, hashMapDeleteEArray, hashMapLookUpArray};

        return performanceTimes;

    }

    public Long calculateAverage(ArrayList<Long> values){
        //Calculates the average and returns it
        Long totalTimes = 0L;
        for (int i = 0; i<=values.size() - 1;i++){
            totalTimes += values.get(i);
        }
        //Works correctly now as used the wrong operator
        return totalTimes/values.size();
    }



}
