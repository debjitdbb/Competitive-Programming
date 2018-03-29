import java.util.*;
class BTAR
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int count=0;
			int n=sc.nextInt();
			int[] arr = new int[n];
			int[] freq = new int[4];
			long sum=0;
			//boolean[] flag = new boolean[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=sc.nextInt();
				freq[arr[i]%4]++;
				sum+=arr[i];
			}
			if(sum%4!=0)
			{
				count=-1;
			}
			else
			{
				count+=freq[2]/2;
				freq[2]%=2;
				int c=Math.min(freq[1],freq[3]);
				count+=c;
				freq[1]-=c;
				freq[3]-=c;
				if(freq[1]>0)
				{
					if(freq[2]==1)
					{
						if(freq[1]>=2)
						{
							freq[1]-=2;
							freq[2]=0;
							count+=2;
						}
						else count=-1;
					}
					if(freq[1]%4==0 && count!=-1)
					{
						c=freq[1]/4;
						c*=3;
						count+=c;
					}
				}
				else if(freq[3]>0)
				{
					if(freq[2]==1)
					{
						if(freq[3]>=2)
						{
							freq[3]-=2;
							freq[2]=0;
							count+=2;
						}
						else count=-1;
					}
					if(freq[3]%4==0 && count!=-1)
					{
						c=freq[3]/4;
						c*=3;
						count+=c;
					}
				}
			}
			
			
			System.out.println(count);
		}
	}
} 
