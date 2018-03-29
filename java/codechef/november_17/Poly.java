import java.util.*;
import java.math.*;
class Poly
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        boolean check=true; //checker for a2 and a3 being 0
        while(t-->0)
        {
            int n=sc.nextInt();
            int[][] arr=new int[n][4];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<4;j++)
                {
                    arr[i][j]=sc.nextInt();
                    if(j==2 || j==3)
                    {
                        if(arr[i][j]!=0)
                            check=false;
                    }
                }
            }

            if(check==true)
            {
                int[] a1=new int[100001];
                boolean[] flag=new boolean[100001];
                ArrayList<Integer> al=new ArrayList<Integer>();
                for(int i=0;i<n;i++)
                {
                    int x=arr[i][1];
                    if(flag[x]==true)
                    {
                        if(arr[i][0]<a1[x])
                            a1[x]=arr[i][0];
                    }
                    else
                    {
                        flag[x]=true;
                        a1[x]=arr[i][0];
                        al.add(x);
                    }
                }
                int size=al.size();
                int q=sc.nextInt();
                while(q-->0)
                {
                    int te=sc.nextInt();
                    int x=al.get(0);
                    int y=a1[x];
                    long sum=x*te+y;
                    for(int i=1;i<size;i++)
                    {
                        x=al.get(i);
                        y=a1[x];
                        long sum1=x*te+y;
                        if(sum1<sum)
                            sum=sum1;
                    }
                    System.out.println(sum);
                }                
            }
            else
            {
               int q=sc.nextInt();
                while(q-->0)
               {
                   long te=sc.nextLong();
                   BigInteger m=BigInteger.valueOf(te);
                   BigInteger b1=BigInteger.valueOf(arr[0][1]).multiply(m);
                   BigInteger b2=BigInteger.valueOf(arr[0][2]).multiply(m).multiply(m);
                   BigInteger b3=BigInteger.valueOf(arr[0][3]).multiply(m).multiply(m).multiply(m);
                   BigInteger min=b1.add(b2).add(b3).add(BigInteger.valueOf(arr[0][0]));
                   //System.out.println(b1+" "+b2+" "+b3+" "+min);
                   for(int i=1;i<n;i++)
                   {
                       b1=BigInteger.valueOf(arr[i][1]).multiply(m);
                       b2=BigInteger.valueOf(arr[i][2]).multiply(m).multiply(m);
                       b3=BigInteger.valueOf(arr[i][3]).multiply(m).multiply(m).multiply(m);
                       BigInteger b4=BigInteger.valueOf(arr[i][0]);
                       BigInteger bi=b1.add(b2).add(b3).add(b4);
                       int res=bi.compareTo(min);
                       if(res==-1) 
                           min=bi;
                   }
                   System.out.println(min);
               }
            }
        }
    }
}