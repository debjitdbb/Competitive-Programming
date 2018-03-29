import java.util.*;
class RECTANGL
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int[] arr=new int[4];
			for(int i=0;i<4;i++)
				arr[i]=sc.nextInt();
			int[] ans=new int[2];
			boolean[] flag=new boolean[2];
			for(int i=0;i<4;i++)
			{
				int x=arr[i];
				if(ans[0]==0)
				{
					ans[0]=x;
					//flag[0]=true;
				}
				else if(ans[1]==0 && ans[0]!=arr[i])
					ans[1]=arr[i];
				else if(ans[0]==x)
					flag[0]=true;
				else if(ans[1]==x)
					flag[1]=true;
			}
			if(arr[0]==arr[1] && arr[1]==arr[2] && arr[2]==arr[3])
				System.out.println("YES");
			else if(flag[0] && flag[1])
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}
	}
}