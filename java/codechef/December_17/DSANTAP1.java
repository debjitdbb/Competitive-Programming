import java.util.Scanner;
import java.io.*;
class DSANTAP1
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int g=sc.nextInt();
			int b=sc.nextInt();
			int x=sc.nextInt();
			int y=sc.nextInt();
			int[] vol=new int[g];
			for(int i=0;i<g;i++)
				vol[i]=sc.nextInt();
			int[][] arr=new int[n][4];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<4;j++)
					arr[i][j]=sc.nextInt();
			}
			for(int i=1;i<=n;i++)
			{
				int in=i-1;
				System.out.println(2+" "+arr[in][3]);
				System.out.println(1+" "+i);
				System.out.println(3+" "+arr[in][3]);
				System.out.println(2+" "+arr[in][2]);
				System.out.println(1+" "+0);
				//if(i!=n)
				    System.out.println(3+" "+arr[in][2]);
			    //else
			    	//System.out.println(0);
			}
			System.out.println(0);
		}
	}
} 