import java.util.*;

public class Quick{
    private static int partitionOld(int[]data, int left, int right){
	double randnum = Math.random()*(right-left+1);
	int index = left + (int)randnum;
	int value = data[index];
	//System.out.println(value);
	int rightIndex = right;
	int leftIndex = left+1;
	swap(data,index,left);
	while (leftIndex < rightIndex){
	    if (data[leftIndex] > value){
		swap(data,leftIndex,rightIndex);
		rightIndex--;
	    }else{
		leftIndex++;
	    }
	}
	if (data[rightIndex] > data[left]){
	    swap(data,left,rightIndex-1);
	    index = rightIndex-1;
	}else{
	    swap(data,left,rightIndex);
	    index = rightIndex;
	}
	//method of creating new array is hopeless :( I GIVE UP 
	/*
	int[] sorted = new int[data.length];
	for (int x = left; x < right; x++){
	    //for (int x = 0; x < data.length; x++){
	    if (data[x] < value){
		sorted[leftIndex] = data[x];
		leftIndex++;
	    }else{
		sorted[rightIndex] = data[x];
		rightIndex--;
	    }
	}
        sorted[rightIndex] = value;
	data = new int[sorted.length];
	for (int i = 0; i < sorted.length;i++){
	    if (sorted[i] == value){
		index = i;
	    }
	    data[i] = sorted[i];
	}
	*/
	//printArray(data);
	return index;
    }

    private static int partition(int[]data, int left, int right){
	double randnum = Math.random()*(right-left+1);
	int index = left + (int)randnum;
	int value = data[index];
	//System.out.println(value);
	int rightIndex = right;
	int leftIndex = left;
	int counter = 0;
	int[] sorted = new int[right-left+1];
	for (int x = 0; x < sorted.length; x++){
	    if (data[x+left] == value){
		counter++;
		if (counter == rightIndex-leftIndex){
		}
	    }else if (data[x+left] < value){
		sorted[leftIndex] = data[x+left];
		leftIndex++;
	    }else{
		sorted[rightIndex] = data[x+left];
		rightIndex--;
	    }
	}
        sorted[rightIndex] = value;
	data = new int[sorted.length];
	for (int i = 0; i < sorted.length;i++){
	    if (sorted[i] == value){
		index = i;
	    }
	    data[i] = sorted[i];
	}
	//printArray(data);
	return index;
    }

    private static void swap(int[] data, int spotA, int spotB){
	int value = data[spotA];
	data[spotA] = data[spotB];
	data[spotB] = value;
    }
    
    public static int quickselectOld(int[]data, int k){
	return quickselectOld(data,k,0,data.length-1);
    }
    //return the kth smallest value.
    // when k = 0 return the smallest.
    // 0 <= k < data.length
    
    public static int quickselect(int[]data, int k){
	return quickselect(data,k,0,data.length-1);
    }

    // helper method for quickselect recursive
    private static int quickselectOld(int[]data, int k, int left, int right){
	//printArray(data);
	int index = partition(data, left, right);
	//System.out.println(index);
	if (index == k){
	    return data[index];
	}
	//int[] tempary;
	if (index < k){
	    /*
	      tempary = new int[data.length-index];
	      for (int x = 0; x < tempary.length; x++){
	      tempary[x] = data[x+index];
	      }	    
	      return quickselect(data,k,0,tempary.length-1);
	    */
	    return quickselect(data,k,index,right);
	}else{
	    /*
	      tempary = new int[index];
	      for (int x = 0; x < tempary.length; x++){
	      tempary[x] = data[x];
	      }
	      return quickselect(tempary,k,0,tempary.length-1);
	    */
	    return quickselect(data,k,left,index);
	}
    }

    private static int quickselect(int[]data, int k, int left, int right){
	//printArray(data);
	int index = partition(data, left, right);
	//System.out.println(index);
	if (index == k){
	    return data[index];
	}
	if (index < k){
	    return quickselect(data,k,index,right);
	}else{
	    return quickselect(data,k,left,index);
	}
    }
    
    public static void quickSortOld(int[] data,int left, int right){
	if (right-left > 1){
	    int index = partition(data,left,right);
	    quickSortOld(data,left,index-1);
	    quickSortOld(data,index+1,right);
	}
    }
    //chooses a partition element and then sorts either side recursively
    
    public static void quickSort(int[] data,int left, int right){
	if (right-left > 1){
	    int index = partition(data,left,right);
	    quickSort(data,left,index-1);
	    quickSort(data,index+1,right);
	}
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
    
    public static String name(){
	return "6,Chan,Yvonne";
    }
    
    public static void main(String[]args){
	int[] test = {2,4,11,-6,35,8,24,1,9,3,17,5,7,0,-100};
	int[] test2 = {8,9,10,13,53,10,53,5,0,-100};
	int[] test3 = {2,4,11,-6,5};
	int[] test4 = {9,2,23,23,132,83,23,74,90,53,-3,0,1,6,2};
	int[] test5 = {0,6,3,68,9,7,4,5,1,8,2};
	int[] test6 = {0,0,0,0,0,0,0};
	
	//partition test cases
	System.out.println(partition(test4,0,test4.length-1));
	System.out.println(partition(test4,3,test4.length-1));
	System.out.println(partition(test4,0,3));
	System.out.println(partition(test4,2,3));

	/*
	//quickselect test cases
	System.out.println(quickselectOld(test,5)); //3
	System.out.println(quickselectOld(test,12)); //17
	System.out.println(quickselectOld(test,14)); //35
	System.out.println(quickselectOld(test,0)); //-100
	System.out.println(quickselectOld(test,1)); //-6
	System.out.println(quickselectOld(test,7)); //5	
	
	
	//quicksort test cases
	printArray(test);
        quickSortOld(test,0,test.length-1);
	printArray(test);
	printArray(test2);
        quickSortOld(test2,2,9);
	printArray(test2);
	printArray(test3);
	quickSortOld(test3,1,3);
	printArray(test3);
	printArray(test4);
	quickSortOld(test4,0,9);
	printArray(test4);
	printArray(test5);
	quickSortOld(test5,2,test5.length-1);
	printArray(test5);
	printArray(test6);
	quickSortOld(test6,0,test6.length-1);
	printArray(test6);
	*/
	

	/*
	int[] big = new int[4000000];
	for (int x = 0; x < big.length;x++){
	    big[x] = (int)Math.random()*3 + 1;
	}

	long startTime1 = System.currentTimeMillis();
        Arrays.sort(big);
	long endTime1 = System.currentTimeMillis();
	System.out.println("System: " +(endTime1-startTime1));
	
	long startTime2 = System.currentTimeMillis();
        quickSortOld(big,0,big.length-1);
	long endTime2 = System.currentTimeMillis();
	System.out.println("quickSortOld: " +(endTime2-startTime2));
	
	
	int[] big2 = new int[4000000];
	for (int x = 0; x < big.length;x++){
	    big[x] = (int)Math.random()*Integer.MAX_VALUE;
	}
	
	long startTime2 = System.currentTimeMillis();
        quickSortOld(big2,0,big2.length-1);
	long endTime2 = System.currentTimeMillis();
	System.out.println("Time for quickSortOld on random array: " +(endTime2-startTime2));
	*/
	
    }
}
