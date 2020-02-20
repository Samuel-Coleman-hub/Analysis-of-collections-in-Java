import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Performance {

    public Long[][] arrayRecordTime(StopWatch stopwatch){
        StopWatch stopWatch = new StopWatch();
        ArrayDirectory arrayDirectory = new ArrayDirectory();
        ArrayListDirectory arrayListDirectory = new ArrayListDirectory();
        HashMapDirectory hashMapDirectory = new HashMapDirectory();
        ArrayList<Long> arrayTimeRecordings = new ArrayList<>();
        //Calculates Stats for the Array Directory Insertion
        for (int i = 0; i <=1000; i++) {
            stopWatch.start();
            arrayDirectory.insertEntry(arrayDirectory.toArrayList().get(i));
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long arrayInsertTimeMax = Collections.max(arrayTimeRecordings);
        long arrayInsertTimeMin = Collections.min(arrayTimeRecordings);

        long arrayInsertTimeAverage = calculateAverage(arrayTimeRecordings);

        Long[] arrayInsertStats = {arrayInsertTimeMax,arrayInsertTimeAverage,arrayInsertTimeMin};

        arrayTimeRecordings.clear();

        //Calculates stats for deleting by surname in the ArrayDirectory
        for(int i = 0; i<= 1000; i++){
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

        //Calculates stats for deleting by extension in the ArrayDirectory
        for (int i = 0; i<=1000; i++){
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

        //Calculates stats for lookup in the ArrayDirectory
        for (int i = 0; i<=1000; i++){
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

        //Calculates stats for insertion in the arrayList
        for (int i = 0; i<=1000; i++){
            stopWatch.start();
            arrayListDirectory.insertEntry(arrayListDirectory.toArrayList().get(i));
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long listInsertMax = Collections.max(arrayTimeRecordings);
        long listInsertMin = Collections.min(arrayTimeRecordings);
        long listInsertAverage = calculateAverage(arrayTimeRecordings);

        Long[] listInsertArray = {listInsertMax, listInsertAverage,listInsertMin};

        arrayTimeRecordings.clear();

        //Calculates stats for deleting by surname in arrayListDirectory
        for (int i = 0; i<=1000; i++){
            stopWatch.start();
            arrayListDirectory.deleteEntryUsingName(arrayListDirectory.toArrayList().get(i).getSurname());
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long listDeleteSMax = Collections.max(arrayTimeRecordings);
        long listDeleteSMin = Collections.min(arrayTimeRecordings);
        long listDeleteSAverage = calculateAverage(arrayTimeRecordings);

        Long[] listDeleteSArray = {listDeleteSMax, listDeleteSAverage,listDeleteSMin};

        arrayTimeRecordings.clear();

        //Calculates stats for deleting by extension in arrayListDirectory
        for (int i = 0; i<=1000; i++){
            stopWatch.start();
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
        for (int i = 0; i<=1000; i++){
            stopWatch.start();
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

        //Calculates stats for insertion in HashMapDirectory
        for (int i = 0; i<=1000; i++){
            stopWatch.start();
            hashMapDirectory.insertEntry(hashMapDirectory.toArrayList().get(i));
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long hashMapInsertMax = Collections.max(arrayTimeRecordings);
        long hashMapInsertMin = Collections.min(arrayTimeRecordings);
        long hashMapInsertAverage = calculateAverage(arrayTimeRecordings);

        Long[] hashMapInsertArray = {hashMapInsertMax, hashMapInsertAverage,hashMapInsertMin};

        arrayTimeRecordings.clear();

        //Calculates stats for deleting by surname in HashMapDirectory
        for (int i = 0; i<=1000; i++){
            stopWatch.start();
            hashMapDirectory.deleteEntryUsingName(hashMapDirectory.toArrayList().get(i).getSurname());
            stopWatch.stop();
            arrayTimeRecordings.add(stopWatch.getElapsedTime());
            stopWatch.reset();
        }
        long hashMapDeleteSMax = Collections.max(arrayTimeRecordings);
        long hashMapDeleteSMin = Collections.min(arrayTimeRecordings);
        long hashMapDeleteSAverage = calculateAverage(arrayTimeRecordings);

        Long[] hashMapDeleteSArray = {hashMapDeleteSMax, hashMapDeleteSAverage,hashMapDeleteSMin};

        arrayTimeRecordings.clear();

        //Calculates stats for deleting by extension in HashMapDirectory
        for (int i = 0; i<=1000; i++){
            stopWatch.start();
            hashMapDirectory.deleteEntryUsingExtension(Integer.toString(hashMapDirectory.toArrayList().get(i).
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

        //Calculates stats for lookup in hashMapDirectory
        for (int i = 0; i<=1000; i++){
            stopWatch.start();
            hashMapDirectory.lookupExtension(Integer.toString(hashMapDirectory.toArrayList().get(i).
                    getTelephoneExtension()));
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
        Long totalTimes = 0L;
        for (int i = 0; i<=values.size();i++){
            totalTimes =+ values.get(i);
        }
        return totalTimes/values.size();
    }



}
