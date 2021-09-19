package basic.sort;

import java.util.ArrayList;

public class QuickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        if(dataList.size() <= 1){
            return dataList;
        }

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        int pivot = dataList.get(0);
        for(int i = 1; i < dataList.size(); i++){
            if(pivot > dataList.get(i)){
                leftList.add(dataList.get(i));
            }else
                rightList.add(dataList.get(i));
        }

        ArrayList<Integer> mergeList = new ArrayList<>();
        mergeList.addAll(sort(leftList));
        mergeList.add(pivot);
        mergeList.addAll(sort(rightList));

        return mergeList;


    }
}
