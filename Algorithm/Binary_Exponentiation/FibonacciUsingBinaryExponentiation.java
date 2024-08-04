/*
magic matrix
|0 1|
|1 1|

here matrix(1,0) is fibonacci Nth and matrix(1,1) is fibonacci (N+1)th
Wait a minute, let me tell you how!!!
multiply given matrix to itself
|0 1| * |0 1| = |1 1|
|1 1|   |1 1|   |1 2|
let do it again with teh resultant matrix
|1 1| * |0 1| = |1 2|
|1 2|   |1 1|   |2 3|
lets do it again
|1 2| * |0 1| = |2 3|
|2 3|   |1 1|   |3 5|
lets do it again
|2 3| * |0 1| = |3 5|
|3 5|   |1 1|   |5 8|

see (1,0) and (1,1) of resultant matrix 1 2 3 5 8
*/

import java.io.*;
import java.util.*;

class MultiplyMatrix{
  public int[][] multiplyMatrix(int[][] mat, int N){
    int[][] res = {{0,1},{1,1}};
    //int[][] ans = {{0,1},{1,1}};
    while(N>1){
      int mat_0_0 = res[0][0]*mat[0][0] + res[0][1]*mat[1][0];
      int mat_0_1 = res[0][0]*mat[0][1] + res[0][1]*mat[1][1];
      int mat_1_0 = res[1][0]*mat[0][0] + res[1][1]*mat[1][0];
      int mat_1_1 = res[1][0]*mat[0][1] + res[1][1]*mat[1][1];
      res[0][0] = mat_0_0;
      res[0][1] = mat_0_1;
      res[1][0] = mat_1_0;
      res[1][1] = mat_1_1;
      N--;
    }
    for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
            System.out.print(res[i][j]+" ");
        }
        System.out.print("\n");
    }
    return res;
  }
}

class GetNthFibonacci{
  MultiplyMatrix multi_matrix;
  GetNthFibonacci(){
    multi_matrix = new MultiplyMatrix();
  }
  public int getNthFib(int N){
    if(N==1) return 0;
    int[][] ans = multi_matrix.multiplyMatrix(new int[][]{{0,1},{1,1}}, N-1);
    return ans[1][1];
  }
}

class Main{
  public static void main(String[] args){
    GetNthFibonacci get_fib = new GetNthFibonacci();
    int[] ar = {1,2,3,4,5,6,7,8,9};
    for(int i: ar){
      int res = get_fib.getNthFib(i);
      System.out.println(i+"th fibonacci number is "+res);
    }
  }
}
