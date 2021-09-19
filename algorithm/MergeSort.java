package basic.sort;

import java.util.ArrayList;

public class MergeSort {
    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList){
        if(dataList.size() <= 1){
            return dataList;
        }
        int mid = dataList.size()/2;

        ArrayList<Integer> leftList;
        ArrayList<Integer> rightList;

        leftList = mergeSplitFunc(new ArrayList<>(dataList.subList(0, mid)));
        rightList = mergeSplitFunc(new ArrayList<>(dataList.subList(mid, dataList.size())));

        return mergeFunc(leftList, rightList);

//        ArrayList<Integer> leftList = new ArrayList<>(dataList.subList(0, mid));
//        ArrayList<Integer> rightList = new ArrayList<>(dataList.subList(mid,dataList.size()));

    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList){
        int leftPointer = 0;
        int rightPointer = 0;

        ArrayList<Integer> mergedList = new ArrayList<>();

        while(leftList.size() > leftPointer && rightList.size() > rightPointer){
            Integer leftElement = leftList.get(leftPointer);
            Integer rightElement = rightList.get(rightPointer);
            if(leftElement < rightElement){
                mergedList.add(leftElement);
                leftPointer++;
            }else{
                mergedList.add(rightElement);
                rightPointer++;
            }
        }

        while(leftList.size() > leftPointer){
            mergedList.add(leftList.get(leftPointer));
            leftPointer++;
        }

        while(rightList.size() > rightPointer){
            mergedList.add(rightList.get(rightPointer));
            rightPointer++;
        }
        return mergedList;
    }
}
