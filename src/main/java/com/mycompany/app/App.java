package com.mycompany.app;

import java.util.ArrayList;

public class App 
{
    //Returns the minimum number of swaps needed to sort an array of integers from 1 to the size of the array.
    public static int minAmountOfSwapsToSort(ArrayList<Integer> array){
        int amount = 0;
        int i = 0;
        if(array!=null && array.size()!=0){
            while(i<array.size()-1){
                if(array.get(i)==i+1)i++;
                else{
                    int tmp = array.get(i);
                    array.set(i,array.get(array.get(i)-1));
                    array.set(tmp-1,tmp);
                    amount++;
                }
            }
        }
        return amount;
    }
}
