/*
*/

import java.io.*;
import java.util.*;

class Sieve{
  public void primeUsingSieve(boolean[] ar){
    for(int i=2;i<ar.length;i++){
      if(isPrime(i)){
        for(int j=i*2;j<ar.length;j+=i){
          ar[j]=false;
        }
    }
  }
  }

  public boolean isPrime(int N){
    if(N<=1) return false;
    if(N==2) return true;
    for(int i=2;i*i<=N;i++){
      if(N%i == 0) return false;
    }
    return true;
  }
}

class Main{
  public static void main(String[] args){
    Sieve sieve = new Sieve();
    boolean[] is_prime = new boolean[10000];
    for(int i=2;i<is_prime.length;i++){
      is_prime[i] = true;
    }
    sieve.primeUsingSieve(is_prime);
    for(int i=0;i<is_prime.length;i++){
      if(is_prime[i]) System.out.println(i);
    }
  }
}
