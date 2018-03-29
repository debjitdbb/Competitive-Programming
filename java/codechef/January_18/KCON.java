import java.io.*;
import java.util.*;
 
class KCON {
	static int end=0;
 
	public static long maxSubArraySum(long a[], int size) throws Exception
	{
		long max_so_far = Integer.MIN_VALUE;
		long curr_max = 0;
		for (int i = 0; i < size; i++)
		{
			curr_max += a[i];
			if(curr_max>max_so_far)
			{
				max_so_far=curr_max;
				end=i;
			}
			if(curr_max<0)
			curr_max=0;
		}
		
		return max_so_far;
	}
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int k=sc.nextInt();
			//subtask 1
			if((long)n*(long)k<=100000)
			{
				long[] arr=new long[k*n];
				for(int i=0;i<n;i++)
				{
					arr[i]=sc.nextInt();
					for(int j=1;j<k;j++)
					{
						arr[j*n+i]=arr[i];
					}
				}
				long ans = maxSubArraySum(arr,arr.length);
				System.out.println(ans);
			}
			//subtask 2
			else
			{
				long[] arr=new long[2*n];
				long sum=0;
				for(int i=0;i<n;i++)
				{
					arr[i]=sc.nextLong();
					arr[n+i]=arr[i];
					sum+=arr[i];
				}
				long ans = maxSubArraySum(arr,arr.length);
				if(k>2)
				{
					long pr=0;
					long[] prefixSum = new long[n];
					long max=Integer.MIN_VALUE;
					int index=-1;
					for(int i=0;i<n;i++)
					{
						pr+=arr[i];
						prefixSum[i]=pr;
						if(prefixSum[i]>max)
						{
							max=prefixSum[i];
							index=i;
						}
					}
					long result=0;
					if(end>n-1)
						result=ans+(pr - prefixSum[end-n])+(pr*(k-3)) + prefixSum[end-n];
					else 
						result = ans+(pr - prefixSum[end])+(pr*(k-3)) + prefixSum[index];
					System.out.println(Math.max(result,ans));
				}
				//long ans2 = maxSubArraySum(arr,arr.length/2);
				else
					System.out.println(ans);
			}
		}
	}
} 