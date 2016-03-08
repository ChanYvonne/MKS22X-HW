public class Quick{
    private static int partition(int[]data, int left, int right){
	double randnum = Math.random()*data.length;
	int index = (int)randnum;
	int value = data[index];
	System.out.println(value);
	/*
	data[index] = data[right/2];
	data[right/2] = value;
	*/
	int rightIndex = right;
	int leftIndex = left;
	for (int x = left; x < index; x++){
	    if (data[x] > value){
		int temp = data[x];
		data[x] = data[rightIndex];
		data[rightIndex] = temp;
		rightIndex--;
	    }
	}
	/*
	value = data[right/2];
	data[right/2] = data[index];
	data[index] = value;
	*/
	printArray(data);
	return index;
    }
    //choose a random partition element at a location from left to right inclusive.
    //partition the array such that the randomly chosen element divides all values smaller and larger than it. 
    //smaller elements on the left side of the partition, larger on the right side
    //return the index of the partition element. 
    // this allows your quickselect method to decide where to go next.

    //	Quick Select will now give the kth smallest value, so the k corresponds to the index of the array! Save you one subtraction!

    
    public static int quickselect(int[]data, int k){
	return 0;
    }
    //return the kth smallest value.
    // when k = 0 return the smallest.
    // 0 <= k < data.length





    // helper method for quickselect recursive
    private static int quickselect(int[]data, int k, int left, int right){
	return 0;
    }
    //return the kth smallest value in the given left/right range 
    // left <= k <= right
    //start by calling the helper as follows:
    // quickselect(data,k,0,data.length-1)

    public static void printArray(int[]data){
        String ans = "";
	for (int x = 0; x < data.length-1; x ++){
	    ans+= " " + data[x] + ",";
	}
	System.out.println("[" + ans + " " + data[data.length-1] + "]");	
    }

    public static void main(String[]args){
	int[] test = {2,4,24,73,35,87,246,90,83,47,45,71};
	System.out.println(partition(test,0,test.length-1));
    }
}
