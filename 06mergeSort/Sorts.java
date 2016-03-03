import java.util.*;
import java.io.*;

public class Sorts{
    public static void insertionSort(int[] data){
	int nextIndex = 1;
	int value = 0;
	int shift = 0;
	while (nextIndex < data.length){
	    value = data[nextIndex];
	    if (value < data[nextIndex-1]){
		while (nextIndex > 0 && data[nextIndex-1] > value){
		    nextIndex--;
		    shift++;
		}
		for (int x = nextIndex + shift; x > nextIndex; x--){
		    data[x] = data[x-1];
		}
		data[nextIndex] = value;
		shift = 0;
		//printArray(data);
	    }
	    nextIndex++;
	}
    }

    public static void selectionSort(int[] data){
	int startIndex = 0;
	int switchIndex = 0;
	int value = 0;
	while (startIndex < data.length){
	    value = data[startIndex];
	    for (int x = startIndex; x < data.length;x++){
		if (value > data[x]){
		    value = data[x];
		    switchIndex = x;
		}
	    }
	    //printArray(data);
	    data[switchIndex] = data[startIndex];
	    data[startIndex] = value;
	    startIndex ++;
	    value = 0;
	}
    }

    public static void bubbleSort(int[]data){
	int value = 0;
	int endIndex = data.length;
	boolean change = false;
	boolean stop = false;
	while (endIndex > 0 || stop == false){
	    for (int x = 0; x < endIndex-1; x++){
		value = data[x];
		if (data[x] > data[x+1]){
		    data[x] = data[x+1];
		    data[x+1] = value;
		    change = true;
		}
		value = 0;
	    }
	    //printArray(data);
	    endIndex --;
	    if (change == false){
		stop = true;
	    }
	    change = false;
	}
    }
    
    public static void fillRandom(int[]data){
	for (int x = 0; x < data.length; x++){
	    data[x] = (int)Math.random()*Integer.MAX_VALUE;
	}
    }

    /*
    public static void insertionSort(int[] data){
	int nextIndex = 1;
	int value = 0;
	int shift = 0;
	while (nextIndex < data.length){
	    value = data[nextIndex];
	    if (value < data[nextIndex-1]){
		while (nextIndex > 0 && data[nextIndex-1] > value){
			nextIndex--;
			shift++;
		}
		for (int x = nextIndex + shift; x > nextIndex; x--){
		    data[x] = data[x-1];
		}
		data[nextIndex] = value;
		shift = 0;
	    }
	    nextIndex++;
	}
    }
    */

    public static int[] mergeSort(int[] aryA, int[] aryB){
	int[] sorted = new int[aryA.length + aryB.length];
	int countA = 0;
	int countB = 0;
	for (int x = 0; x < sorted.length; x++){
	    if (countA >= aryA.length){
		sorted[x] = aryB[countB];
		countB++;
	    }else if (countB >= aryB.length){
		sorted[x] = aryA[countA];
		countA++;
	    }else if (aryA[countA] < aryB[countB]){
		sorted[x] = aryA[countA];
		countA++;
	    }else{
		sorted[x] = aryB[countB];
		countB++;
	    }
	}
	return sorted;
    }

    public static void mergeSort(int[] data, int startA, int endA, int startB,int endB){
	int[] tempA = Arrays.copyOf(data,endA-startA+1);
        for (int x = 0; x < tempA.length; x++){
	    for (int i = startA; i < endA+1; i++){
		System.out.println(data[i]);
	        tempA[x] = data[i];
	    }
	}
	printArray(tempA);
	int[] tempB = Arrays.copyOf(data,endB-startB+1);
	for (int x = startB; x < endB+1; x++){
	    for (int i = 0; i < tempB.length; i++){
	        tempB[i] = data[x];
	    }
	}
	printArray(tempB);
	int[] ABcombo = mergeSort(tempA,tempB);
	printArray(ABcombo);
	for (int x = startA; x < endB+1; x++){
	    for (int i = 0; i < ABcombo.length; i++){
		data[x] = ABcombo[i];
	    }
	}
    }

    public static void printArray(int[]data){
        String ans = "";
	for (int x = 0; x < data.length-1; x ++){
	    ans+= " " + data[x] + ",";
	}
	System.out.println("[" + ans + " " + data[data.length-1] + "]");	
    }

    /*
    public static String printArray(int[] ary){
	String ans = "[";
	for (int x = 0; x < ary.length; x++){
	    if (x == ary.length -1){
		ans += Integer.toString(ary[x]);
	    }else{
		ans += Integer.toString(ary[x]) + ",";
	    }
	}
	return ans + "]";
    }
    */

    public static void main(String[]args){
        int[] Atest = {1,5,6,9,17,76,91,164,636,2425};
	int[] Btest = {2,4,8,11,40,172};
	int[] Ctest = {12,26,37,1,6,10,24,88,253,2,7,8,48,67,723,242,146,2};
        //printArray(mergeSort(Atest,Btest));
	mergeSort(Ctest, 3, 8, 9, 14);
	printArray(Ctest);
    }
}
