import java.util.Scanner;
class Clrl
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int r=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
			int ub=1000000001,lb=0;
			boolean flag=true;
			for(int i=0;i<n-1;i++)
			{
				int a=arr[i];
				int b=arr[i+1];
				if(a>ub || a<lb)
				{
					flag=false;
					break;
				}
				if(b<a)
				{
					ub=a;
				}
				else if(b>a)
				{
					lb=a;
				}
			}
			if(flag==true &&(arr[n-1]<lb || arr[n-1]>ub)) flag=false;
			if(flag) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}