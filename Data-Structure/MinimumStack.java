/*
*/
import java.io.*;
import java.util.*;

class MinStack{
  Stack<int[]> min_stack;
  MinStack(){
    min_stack = new Stack();
  }
  public void add(int N){
      if(min_stack.isEmpty()){
        min_stack.push(new int[]{N, N});
      }
      else{
        int[] temp_top = min_stack.peek();
        int min = N<temp_top[1]?N:temp_top[1];
        min_stack.push(new int[]{N, min});
      }
  }
  public int getMin(){
    if(min_stack.isEmpty()) return -1;
    return min_stack.peek()[1];
  }
  public void remove(){
    if(!min_stack.isEmpty()) min_stack.pop();
  }
}

class Main{
  public static void main(String[] args){
    MinStack min_stack = new MinStack();
    int[] ar = {5,6,3,4,7,1,2,4};
    for(int i=0;i<ar.length;i++){
      min_stack.add(ar[i]);
    }
    System.out.println(min_stack.getMin());
    min_stack.remove();
    min_stack.remove();
    min_stack.remove();
    min_stack.remove();
    System.out.println(min_stack.getMin());
    min_stack.remove();
    min_stack.remove();
    min_stack.remove();
    System.out.println(min_stack.getMin());
  }
}
