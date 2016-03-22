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
	printArray(data);
	return index;
    }

    private static int partition(int[]data, int left, int right){
	double randnum = Math.random()*(right-left+1);
	int index = left + (int)randnum;
	int value = data[index];
	//System.out.println(value);
	//int[] limits = new int[2];
	/*
	if (left == right){
	    limits[0] = left;
	    limits[1] = right;
	    return limits;
	}
	*/
	//tried so many different mehtods before getting it right!!

	//int counter = 0;
	
	//printArray(data);
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
	    rightIndex--;
	    swap(data,left,rightIndex);
	    index = rightIndex;
	}else{
	    swap(data,left,rightIndex);
	    index = rightIndex;
	}

	for (int x = left; x < index; x++){
	    if (data[x] == value){
		leftIndex--;
		swap(data,x,leftIndex);		
	    }
	}
	index = (leftIndex+rightIndex)/2;
	
	//printArray(data);
	/* 
	//method of returning an int ary
	  swap(data,index,right);
	while (leftIndex < rightIndex){
	    if (data[leftIndex] > value){
		swap(data,leftIndex,rightIndex);
		rightIndex--;
	    }else{
		leftIndex++;
	    }
	}
	if (data[leftIndex] > data[right]){
	    swap(data,right,leftIndex+1);
	    rightIndex++;
	    leftIndex++;
	    //index = leftIndex+1;
	    limits[0] = leftIndex+1;
	    limits[1] = leftIndex+1;
	}else{
	    swap(data,right,leftIndex);
	    //index = leftIndex;
	    limits[0] = leftIndex;
	    limits[1] = leftIndex;
	}

	
	for (int i = leftIndex-1; i >= 0; i--){
	    if (data[i] == value){
		leftIndex--;
		swap(data,i,leftIndex);
	    }
	}

	limits[0] = leftIndex;
	
        
	  int[] sorted = new int[right-left+1];
	  for (int x = left; x <= right; x++){
	  if (data[x] < value){
	  sorted[leftIndex] = data[x];
	  leftIndex++;
	  }else{
	  sorted[rightIndex] = data[x];
	  rightIndex--;
	  }
	  }
	  for (int i = leftIndex; i <= rightIndex; i++){
	  sorted[i] = value;
	  }

	  limits[1] = leftIndex;
	  limits[0] = rightIndex;
	      
	  for (int i = left; i < sorted.length;i++){
	  data[i] = sorted[i];
	  }
	*/
	
	printArray(data);
	//printArray(limits);
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
	int index = partitionOld(data, left, right);
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
	    return quickselectOld(data,k,index,right);
	}else{
	    /*
	      tempary = new int[index];
	      for (int x = 0; x < tempary.length; x++){
	      tempary[x] = data[x];
	      }
	      return quickselect(tempary,k,0,tempary.length-1);
	    */
	    return quickselectOld(data,k,left,index);
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
	    return quickselect(data,k,index+1,right);
	}else{
	    return quickselect(data,k,left,index-1);
	}
    }
    
    public static void quickSortOld(int[] data,int left, int right){
	if (right-left > 1){
	    int index = partitionOld(data,left,right);
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

    public static void quickSort(int[] data){
	quickSort(data,0,data.length-1);
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
	int[] test = {1,1,1,1,2,4,56,3,6,0,-2,-9,-8};
	int[] test2 = {8,9,10,13,53,10,53,5,0,-10};
	int[] test3 = {2,4,11,-6,5};
	int[] test4 = {9,2,23,23,132,83,23,74,90,53,-3,0,1,6,2};
	int[] test5 = {0,6,3,68,9,7,4,5,1,8,2};
	int[] test6 = {0,0,0,0,0,0,0};

	/*
	//partition test cases
	printArray(partition(test,0,test.length-1));
	printArray(partition(test2,0,test2.length-1));
	printArray(partition(test4,0,test4.length-1));
	printArray(partition(test3,1,test3.length-1));
	printArray(partition(test5,0,test5.length-1));
	printArray(partition(test6,0,test6.length-1));
	
        printArray(partition(test,0,7));
	printArray(partition(test2,3,8));
	printArray(partition(test4,0,6));
	printArray(partition(test3,1,test3.length-1));
	printArray(partition(test5,0,3));
	printArray(partition(test6,0,test6.length-1));

	
	//quickselect test cases
	System.out.println(quickselectOld(test,5)); //3
	System.out.println(quickselectOld(test,12)); //17
	System.out.println(quickselectOld(test,14)); //35
	System.out.println(quickselectOld(test,0)); //-100
	System.out.println(quickselectOld(test,1)); //-6
	System.out.println(quickselectOld(test,7)); //5	
	
	*/
	//quicksort test cases
      
	printArray(test);
        quickSort(test,0,test.length-1);
	printArray(test);
	printArray(test2);
        quickSort(test2,0,test2.length-1);
	printArray(test2);
	printArray(test3);
	quickSort(test3,0,test3.length-1);
	printArray(test3);
	printArray(test4);
	quickSort(test4,0,test4.length-1);
	printArray(test4);
	printArray(test5);
	quickSort(test5,0,test5.length-1);
	printArray(test5);
	printArray(test6);
	quickSort(test6,0,test6.length-1);
	printArray(test6);
	
	
	
	/*
	int[]d = new int [4000000];
	int[] c = new int [d.length];

	for(int i = 0; i < d.length; i++){
	    d[i]= (int)(Math.random()*Integer.MAX_VALUE);
	    c[i]= d[i];
	}
	quickSort(d,0,d.length-1); //or even your old quicksort!!!
	Arrays.sort(c);
	System.out.println("Done: Sorted="+Arrays.equals(d,c));
	*/

	
	
	/*
	int[]a = new int [4000000];
	for (int x = 0; x < a.length;x++){
	    a[x] = (int)Math.random()*4;
	}
	//fill with random values from 0 to 3 inclusive

	double startTime1 = System.currentTimeMillis();
        Arrays.sort(a);
	double endTime1 = System.currentTimeMillis();
	System.out.println("System: " +(endTime1-startTime1)/1000.0);
	
	double startTime2 = System.currentTimeMillis();
        quickSortOld(a,0,a.length-1);
	double endTime2 = System.currentTimeMillis();
	System.out.println("quickSortOld: " +(endTime2-startTime2)/1000.0);

	double startTime3 = System.currentTimeMillis();
        quickSort(a,0,a.length-1);
	double endTime3 = System.currentTimeMillis();
	System.out.println("quickSort: " +(endTime3-startTime3)/1000.0);
	
	
	if (args[0].equals("a") && args[1].equals("array")){
	    Arrays.sort(a);
	    printArray(a);
	}
	if (args[0].equals("a") && args[1].equals("old")){
	    quickSortOld(a,0,a.length-1);
	    printArray(a);
	}
	if (args[0].equals("a") && args[1].equals("new")){
	    quickSort(a,0,a.length-1);
	    printArray(a);
	}	
	
	*/

	/*
	int[]b = new int [4000000];
	for (int x = 0; x < b.length;x++){
	    b[x] = (int)Math.random()*Integer.MIN_VALUE + (int)Math.random()*Integer.MAX_VALUE;
	}
	//fill with random values from Integer.MIN_VALUE to Integer.MAX_VALUE

	double startTime5 = System.currentTimeMillis();
        Arrays.sort(b);
	double endTime5 = System.currentTimeMillis();
	System.out.println("System: " +(endTime5-startTime5)/1000.0);
	
	double startTime4 = System.currentTimeMillis();
        quickSortOld(b,0,b.length-1);
	double endTime4 = System.currentTimeMillis();
	System.out.println("quickSortOld: " +(endTime4-startTime4)/1000.0);

	double startTime6 = System.currentTimeMillis();
        quickSort(b,0,b.length-1);
	double endTime6 = System.currentTimeMillis();
	System.out.println("quickSort: " +(endTime6-startTime6)/1000.0);
	
	
	if (args[0].equals("b") && args[1].equals("array")){
	    Arrays.sort(b);
	    printArray(b);
	}
	if (args[0].equals("b") && args[1].equals("old")){
	    quickSortOld(b,0,b.length-1);
	    printArray(b);
	}
	if (args[0].equals("b") && args[1].equals("new")){
	    quickSort(b,0,b.length-1);
	    printArray(b);
	}	
	*/
	
    } 
}
