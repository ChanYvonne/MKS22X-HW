import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private T[] data;

   public MyHeap(){
       data = new T[size];
   }
   
   public MyHeap(T[] array, boolean type){
       
   }
   
   public MyHeap(T[] array){
       data = new T[array.length+1];
       for (int x = 0; x < array.length;x++){
	   data[x+1] = array[x];
       }
       heapify();
   }

   private void pushDown(int index){
       
   }

   private void pushUp(int index){
   
   }

   private void heapify(){
       
   }

   public T delete(){
   
   }
   
   public void add(T x){
       if (size == data.length-1){
	   doubleSize();
       }
       
   }
   
   private void doubleSize(){
       size *= 2;
       T[] temp = new T[size];
       for (int x = 0; x < data.length; x++){
	   temp[x] = data[x];
       }
       data = temp;
   }
   
   public String toString(){
       return ArrayList.toString(data);
   }

   //do this last
   public MyHeap(boolean isMax){
   
   }
   public MyHeap(T[] array, boolean isMax){
       this(array);
   }

}
