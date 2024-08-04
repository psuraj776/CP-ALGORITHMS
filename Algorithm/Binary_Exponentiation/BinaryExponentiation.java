/*
a^n
naive way is a*a*a*a....... n times
binary exponentiation is
a^(n/2) * a^(n/2)
and so on we can divide the power by 2 if even power. If power is odd then simply multiply a to answer and reduce power by 1
*/
import java.util.*;

class RecursiveSolution{
  public int getPowerOfA_Recursive(int a, int n){
    if(n==0) return 1;
    return n%2==0?getPowerOfA_Recursive(a, n/2)*getPowerOfA_Recursive(a, n/2):a*getPowerOfA_Recursive(a, n-1);
  }
}

class Solution{
  public int getPowerOfA(int a, int n){
    int res = 1;
    while(n>0){
      if((n&1) != 0){
        res = res * a;
      }
      a = a*a;
      n = n>>1;
    }
    return res;
  }
}

class Main{
  public static void main(String[] args){
    Solution solution = new Solution();
    RecursiveSolution recur_solution = new RecursiveSolution();
    int a = 2;
    int n = 11;
    //get a^n using binary exponentiation
    System.out.print("Answer with recursion "+recur_solution.getPowerOfA_Recursive(a, n)+"/n");
    System.out.print("Answer without recursion "+solution.getPowerOfA(a, n));
  }
}
