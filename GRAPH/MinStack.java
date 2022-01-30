/*
STACK
STACK
STACK
*/

import java.util.*;
import java.text.*;

class GFG {
	public static void main (String[] args) {
		Stack<int[]> minStack = new Stack<>();
    	int[] ar = {3,2,5,4,6,7,1,8};
    	for(int i : ar){
        	add(minStack, i);
        	System.out.println(getMin(minStack));
    	}
    	
	}
	public static int getMin(Stack<int[]> minStack){
	    return minStack.peek()[1];
	}
	public static void add(Stack<int[]> minStack, int numToAdd){
	    if(minStack.isEmpty()){
        	    minStack.push(new int[]{numToAdd,numToAdd});
        }
        	else{
            	int curr_min = minStack.peek()[1]>numToAdd?numToAdd:minStack.peek()[1];
            	minStack.push(new int[]{numToAdd,curr_min});
        }
	}
	public static void remove(Stack<int[]> minStack){
	    minStack.pop();
	}
}
