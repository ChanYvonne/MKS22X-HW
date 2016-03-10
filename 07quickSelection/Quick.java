public class Quick{
    private static int partition(int[]data, int left, int right){
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
	//method of creating new array is hopeless :(
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
    //choose a random partition element at a location from left to right inclusive.
    //partition the array such that the randomly chosen element divides all values smaller and larger than it. 
    //smaller elements on the left side of the partition, larger on the right side
    //return the index of the partition element. 
    // this allows your quickselect method to decide where to go next.

    //	Quick Select will now give the kth smallest value, so the k corresponds to the index of the array! Save you one subtraction!

    private static void swap(int[] data, int spotA, int spotB){
	int value = data[spotA];
	data[spotA] = data[spotB];
	data[spotB] = value;
    }
    
    public static int quickselect(int[]data, int k){
	return quickselect(data,k,0,data.length-1);
    }
    //return the kth smallest value.
    // when k = 0 return the smallest.
    // 0 <= k < data.length


    // helper method for quickselect recursive
    private static int quickselect(int[]data, int k, int left, int right){
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
    //return the kth smallest value in the given left/right range 
    // left <= k <= right
    //start by calling the helper as follows:
    // quickselect(data,k,0,data.length-1)

    public static void quicksort(int[] data,int left, int right){
	if (right-left > 1){
	    int index = partition(data,left,right);
	    quicksort(data,left,index-1);
	    quicksort(data,index+1,right);
	}
    }
    //chooses a partition element and then sorts either side recursively
    
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
	int[] test4 = {9,2,23,6356,132,53,-3,0,1,6,2};
	int[] test5 = {0,6,3,68,9,7,4,5,1,8,2};
	/*
	//partition test cases
	System.out.println(partition(test5,0,test5.length-1));
	System.out.println(partition(test5,3,test5.length-1));
	System.out.println(partition(test5,0,3));
	System.out.println(partition(test5,2,3));

	
	//quickselect test cases
	System.out.println(quickselect(test,5)); //3
	System.out.println(quickselect(test,12)); //17
	System.out.println(quickselect(test,14)); //35
	System.out.println(quickselect(test,0)); //-100
	System.out.println(quickselect(test,1)); //-6
	System.out.println(quickselect(test,7)); //5	
	
	*/
	//quicksort test cases
	printArray(test);
        quicksort(test,0,test.length-1);
	printArray(test);
	printArray(test2);
        quicksort(test2,2,9);
	printArray(test2);
	printArray(test3);
	quicksort(test3,1,3);
	printArray(test3);
	printArray(test4);
	quicksort(test4,0,9);
	printArray(test4);
	printArray(test5);
	quicksort(test5,2,test5.length-1);
	printArray(test5);

    }
}
