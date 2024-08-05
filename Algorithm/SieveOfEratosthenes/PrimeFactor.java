/*
we can do it using sieve array as well in that way we have to only check for prime number.
for now lets do it in for from i to N
*/

import java.io.*;
import java.util.*;

class PrimeFactor{
  public void primeFactor(List<Integer> factor, int N){
    while(N%2 == 0){
      factor.add(2);
      N/=2;
    }
    for(int i=3;i*i<=N;i+=2){
      while(N%i==0){
        factor.add(i);
        N/=i;
      }
    }
    if(N>1) factor.add(N);
  }
  public boolean isPrime(int N){
    if(N<=1) return false;
    if(N==2) return true;
    for(int i=2;i*i<=N;i++){
      if(N%2 == 0) return false;
    }
    return true;
  }
}

class Main{
  public static void main(String[] args){
    PrimeFactor prime_factor = new PrimeFactor();
    List<Integer> factor = new ArrayList<>();
    int N = 80;
    prime_factor.primeFactor(factor, N);
    System.out.print("Prime factor of "+N+" is ");
    for(int i=0;i<factor.size();i++){
      System.out.print(factor.get(i)+" ");
    }
  }
}
