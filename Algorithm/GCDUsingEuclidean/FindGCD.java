/*
if a number A divides both B and C. Then A for sure divides B-C, considering B>C or else C-B.
So we'll keep substracting small number from large one until small one becomes zero. remianing one will be answer.
*/

import java.util.*;
import java.io.*;

class GCD{
  public int findGCDRecursion(int A, int B){
    if(B==0) return A;
    if(A==0) return B;
    return A>=B?findGCDRecursion(B, A-B):findGCDRecursion(A, B-A);
  }
  
  public int findGCD(int A, int B){
      int ans=1;
      while(A>0 && B>0){
          if(A>=B){
              A = A-B;
          }
          else{
              B = B-A;
          }
      }
      
      return A==0?B:A;
  }
}

class Main{
  public static void main(String[] args){
    GCD gcd = new GCD();
    int A = 66;
    int B = 44;
    System.out.println("GCD of "+A +" and "+B+" using recursion is "+gcd.findGCDRecursion(A,B));
    System.out.println("GCD of "+A +" and "+B+" without recursion is "+gcd.findGCD(A,B));
  }
}
