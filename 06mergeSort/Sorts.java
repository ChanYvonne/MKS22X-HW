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

    private static void merge(int[] sorted, int[] aryA, int[] aryB){
	//int[] sorted = new int[aryA.length + aryB.length];
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
    }

    private static void mergesorthelper(int[] data, int startA, int endA, int startB,int endB){
	if (!(data.length <= 1)){
	    int[] tempA = new int[endA-startA];
	    for (int i = 0; i < tempA.length; i++){
		tempA[i] = data[i];
	    }
	    //printArray(tempA);
	    int[] tempB = new int[data.length-tempA.length];
	    for (int x = 0; x < tempB.length; x++){
		tempB[x] = data[x+tempA.length];
	    }
	    //printArray(tempB);

	    mergesorthelper(tempA,0,tempA.length/2,tempA.length/2,tempA.length-1);
	    mergesorthelper(tempB,0,tempB.length/2,tempB.length/2,tempB.length-1);

	    /*
	      int[] ABcombo = merge(tempA,tempB);
	      //printArray(ABcombo);
	      for (int x = startA; x < endB+1; x++){
	      data[x] = ABcombo[x-startA];
	      }
	    */
	    
	    merge(data,tempA,tempB);
	}
    }


    public static void mergesort(int[] data){
	mergesorthelper(data,0,data.length/2,data.length/2,data.length-1);
    }

    public static void printArray(int[]data){
        String ans = "";
	for (int x = 0; x < data.length; x ++){
	    if (x == data.length-1){
		ans+= " " + data[x];
	    }else{
		ans+= " " + data[x] + ",";
	    }
	}
	System.out.println("[" + ans + "]");	
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

    public static String name(){
	return "6,Chan,Yvonne";
    }

    public static void main(String[]args){
        int[] Atest = {1};
	int[] Btest = {2,4,8,11,40,172,13,46,-13,4,0};
	int[] sorted = {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6};
	int[] Ctest = {12,26,37,1,6,10,24,88,253,2,7,8,48,67,723,242,146,2};
	int[] Dtest = {1,73,84,35,32,76,-3};
	int[] Etest = {76,-3};
	int[] Ftest = {};
	//merge(sorted,Atest,Btest);
	//printArray(sorted);
	mergesort(Atest);
	printArray(Atest);
	mergesort(Btest);
	printArray(Btest);
	mergesort(Ctest);
	printArray(Ctest);
	mergesort(Dtest);
	printArray(Dtest);
	mergesort(Etest);
	printArray(Etest);
	mergesort(Ftest);
	printArray(Ftest);
    }
}
