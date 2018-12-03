package com.me.forkjoin;
/**
 * 归并排序
 * @author 郭清明
 *
 */
public class MargeSort {
    
    public static void margeSort(int[] list){
        if(list.length>1){
            int a = list.length/2;
            int[] firstList = new int[a];
            System.arraycopy(list, 0, firstList, 0, a);
            margeSort(firstList);
            int[] secondtList = new int[list.length-a];
            System.arraycopy(list, a, secondtList, 0, list.length-a);
            margeSort(secondtList);
            marge(list, firstList, secondtList);
        }
    }
    
    /**
     * 将两个数组合并
     * @param list
     * @param firstList
     * @param secondList
     */
    public static void marge(int[] list,int[] firstList,int[] secondList){
        int i,j,k;
        
        for(i=0,j=0,k=0;i<list.length&&j<firstList.length&&k<secondList.length;i++){
            if(firstList[j]<=secondList[k]){
                list[i] = firstList[j];
                j++;
            }else{
                list[i] = secondList[k];
                k++;
            }
        }
        for(;j<firstList.length;j++,i++){
            list[i] = firstList[j];
        }
        
        for(;k<secondList.length;k++,i++){
            list[i] = secondList[k];
        }
            
    }
}
