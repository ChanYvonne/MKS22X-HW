public class Quick{
    private static int partition(int[]data, int left, int right){
	double randnum = left + Math.random()*(right-left+1);
	int index = (int)randnum;
	int value = data[index];
	//System.out.println(value);
	int rightIndex = right;
	int leftIndex = left+1;
	int[] sorted = new int[data.length];
	for (int x = 0; x < leftIndex && rightIndex > 0; x++){
	    //for (int x = 0; x < data.length; x++){
	    if (data[x] < value){
		sorted[leftIndex] = data[x];
		leftIndex++;
	    }
	    if (data[x] > value){
		sorted[rightIndex] = data[x];
		rightIndex--;
	    }
	}
	for (int i = 0; i < sorted.length;i++){
	    if (sorted[i] == 0){
		sorted[i] = value;
		index = i;
	    }	    
	}
	/*
	  data[index] = data[right/2];
	  data[right/2] = value;
	
	  for (int x = left; x < index; x++){
	  if (data[x] > value){
	  int temp = data[x];
	  data[x] = data[rightIndex];
	  data[rightIndex] = temp;
	  rightIndex--;
	  }
	  }
	  value = data[right/2];
	  data[right/2] = data[index];
	  data[index] = value;
	*/
	//printArray(sorted);
	return index;
    }
    //choose a random partition element at a location from left to right inclusive.
    //partition the array such that the randomly chosen element divides all values smaller and larger than it. 
    //smaller elements on the left side of the partition, larger on the right side
    //return the index of the partition element. 
    // this allows your quickselect method to decide where to go next.

    //	Quick Select will now give the kth smallest value, so the k corresponds to the index of the array! Save you one subtraction!

    
    public static int quickselect(int[]data, int k){
	return quickselect(data,k,0,data.length-1);
    }
    //return the kth smallest value.
    // when k = 0 return the smallest.
    // 0 <= k < data.length

    /*
    private static int partitionSorted(int index,int[] data){
	int value = data[index];
	//System.out.println(value);
	int rightIndex = data.length-1;
	int leftIndex = 0;
	int[] sorted = new int[data.length];
	for (int x = 0; x < data.length && leftIndex < data.length && rightIndex > 0; x++){
	    //for (int x = 0; x < data.length; x++){
	    if (data[x] < value){
		sorted[leftIndex] = data[x];
		leftIndex++;
	    }
	    if (data[x] > value){
		sorted[rightIndex] = data[x];
		rightIndex--;
	    }
	}
	for (int i = 0; i < sorted.length;i++){
	    if (sorted[i] == 0){
		sorted[i] = value;
	    }	    
	}
	printArray(sorted);
	return sorted[index];
    }   
    */


    // helper method for quickselect recursive
    private static int quickselect(int[]data, int k, int left, int right){
	printArray(data);
	int index = partition(data, left, right);
	System.out.println(index);
	if (index == k){
	    return data[index];
	    //return partitionSorted(index,data);
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
	    return quickselect(data,k,index+1,right);
	}else{
	    /*
	      tempary = new int[index];
	      for (int x = 0; x < tempary.length; x++){
	      tempary[x] = data[x];
	      }
	      return quickselect(tempary,k,0,tempary.length-1);
	    */
	    return quickselect(data,k,left,index-1);
	}
	
    }
    //return the kth smallest value in the given left/right range 
    // left <= k <= right
    //start by calling the helper as follows:
    // quickselect(data,k,0,data.length-1)

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
	int[] test = {2,4,24,73,35,87,246,90,83,47,45,71};
	//System.out.println(partition(test,0,test.length-1));
	System.out.println(quickselect(test,5)); //47
	
    }
}
