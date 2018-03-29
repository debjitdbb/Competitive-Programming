import java.util.*;
import java.io.*;
class GIT01
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0)
		{
			String[] inp=br.readLine().split(" ");
			int n=Integer.parseInt(inp[0]);
		    int m=Integer.parseInt(inp[1]);
		    String[] arr=new String[n];
		    for(int i=0;i<n;i++)
		    {
		    	arr[i]=br.readLine();
		    }
		    //display(arr,n);
		    int sum1=R(arr,n,m);
		    int sum2=G(arr,n,m);
		    System.out.println(Math.min(sum1,sum2));
		}
	}

	public static void display(String[] arr,int n)
	{
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}

	public static int R(String[] arr,int n,int m)
	{
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		for(int i=0;i<m;i++)
		{
			if(i%2==0)
			{
				sb1.append('R');
				sb2.append('G');
			}
			else
			{
				sb1.append('G');
				sb2.append('R');
			}
		}
		String s1=sb1.toString();
		String s2=sb2.toString();
		int cost=0;
		for(int i=0;i<n;i++)
		{
			if(i%2==0)
			{
				for(int j=0;j<m;j++)
				{
					String s=arr[i];
					char c1=s.charAt(j);
					char c2=s1.charAt(j);
					if(c1!=c2)
					{
						if(c1=='R')
							cost+=5;
						else
							cost+=3;
					}
				}
			}
			else
			{
				for(int j=0;j<m;j++)
				{
					char c1=arr[i].charAt(j);
					char c2=s2.charAt(j);
					if(c1!=c2)
					{
						if(c1=='R')
							cost+=5;
						else
							cost+=3;
					}
				}
			}
		}
		return cost;
	}

	public static int G(String[] arr,int n,int m)
	{
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		for(int i=0;i<m;i++)
		{
			if(i%2!=0)
			{
				sb1.append('R');
				sb2.append('G');
			}
			else
			{
				sb1.append('G');
				sb2.append('R');
			}
		}
		String s1=sb1.toString();
		String s2=sb2.toString();
		int cost=0;
		for(int i=0;i<n;i++)
		{
			if(i%2==0)
			{
				for(int j=0;j<m;j++)
				{
					char c1=arr[i].charAt(j);
					char c2=s1.charAt(j);
					if(c1!=c2)
					{
						if(c1=='R')
							cost+=5;
						else
							cost+=3;
					}
				}
			}
			else
			{
				for(int j=0;j<m;j++)
				{
					char c1=arr[i].charAt(j);
					char c2=s2.charAt(j);
					if(c1!=c2)
					{
						if(c1=='R')
							cost+=5;
						else
							cost+=3;
					}
				}
			}
		}
		return cost;
	}
}