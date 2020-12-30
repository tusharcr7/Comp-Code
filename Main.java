import java.util.*;

class Main {
  public static void main(String[] args) {
   Scanner sc=new Scanner(System.in);
    int x=sc.nextInt();
    int arr[]=new int[x];
    for(int i=0;i<x;i++)
    {
      arr[i]=sc.nextInt();
    }

    System.out.println(maxSubsetSum(arr));

  }
  static int maxSubsetSum(int[] arr) {

      int l=arr.length;
      if(l==2)
      {
        return Math.max(arr[l-1], arr[l-2]);
      }
      else if(l==1)
      {
        return arr[l-1];
      }
     
      
      int sum[] =new int[l];
      arr[0]=Math.max(0, arr[0]);
      arr[1]=Math.max(arr[1],arr[0]);
      
      for(int i=2;i<l;i++)
      {
          arr[i]=Math.max(arr[i-1], arr[i]+arr[i-2]);
           
      }
      return arr[l-1];

    }
    // Complete the maxSubsetSum function below.
    static int wmaxSubsetSum(int[] arr) {

      int l=arr.length;
      if(l==2)
      {
        return Math.max(arr[l-1], arr[l-2]);
      }
      else if(l==1)
      {
        return arr[l-1];
      }
     
      
      int sum[] =new int[l];
      sum[l-1]=arr[l-1];
      sum[l-2]=arr[l-2];
       sum[l-3]=Math.max(arr[l-3],arr[l-3]+sum[l-1] );
      int max=0;
      for(int i=l-4;i>=0;i--)
      {
          int sum1=arr[i]+sum[i+2];
          int sum2=arr[i]+sum[i+3];
          sum[i]=sum1>sum2?sum1:sum2;
          sum[i]=arr[i]>sum[i]?arr[i]:sum[i];
          max=sum[i]<max?max:sum[i];
      }
      return max;

    }
}