package basic.sort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        int size = dataList.size();

        for(int i =0; i< size-1; i++){
            int minIndex = i;
            for(int j=i+1; j<size; j++){
                if(dataList.get(j) < dataList.get(minIndex)){
                    minIndex = j;
                }
            }
            Collections.swap(dataList,i,minIndex);
        }
        return dataList;
    }
}
