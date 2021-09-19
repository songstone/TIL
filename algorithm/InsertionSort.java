package basic.sort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        int size = dataList.size();
        for(int i=0; i<size-1; i++){
            for(int j = i+1; j>0; j--){
                if(dataList.get(j) < dataList.get(j-1)){
                    Collections.swap(dataList, j, j-1);
                }
            }
        }
        return dataList;
    }
}
