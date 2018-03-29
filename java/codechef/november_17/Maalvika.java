import java.util.*;
class Maalvika
{
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int arr[]=new int[n];
            arr[0]=m;//initialises first element of the array as arr[0]=m
            int hours=0;
            while(arr[n-1]!=m)//condition when last person has learnt all the m topics
            {
                hours++;
                int j;
                if(hours%2==0)
                j=1;
                else
                j=0;
                for(int i=j;i<n-1;i+=2)
                {
                    if((arr[i]!=0)&&(arr[i+1]!=m))
                    arr[i+1]+=1;
                    if(arr[i]==0)
                    break;
                }
            }
            System.out.println(hours);
        }
    }
}