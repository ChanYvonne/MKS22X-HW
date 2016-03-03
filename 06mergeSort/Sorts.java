public class Sorts{
    public static int[] merge(int[] aryA, int[] aryB){
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

    public static String printArray(int[] ary){
	String ans = "{";
	for (int x = 0; x < ary.length; x++){
	    if (x == ary.length -1){
		ans += Integer.toString(ary[x]);
	    }else{
		ans += Integer.toString(ary[x]) + ",";
	    }
	}
	return ans + "}";
    }

    public static void main(String[]args){
        int[] Atest = {1,5,6,9,17,76,91,164,636,2425};
	int[] Btest = {2,4,8,11,40,172};
	System.out.println(printArray(merge(Atest,Btest)));
    }
}
