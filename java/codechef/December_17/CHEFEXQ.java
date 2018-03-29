import java.util.Scanner;
class CHEFEXQ
{

	public static void display(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int q=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		while(q-->0)
		{
			int type=sc.nextInt();
			int x=sc.nextInt();
			int k=sc.nextInt();
			if(type==1)
			{
				arr[x-1]=k;
				//display(arr);
			}
			else
			{
				int count=0;
				int xor=arr[0];
				if(xor==k)
							count++;
				for(int i=1;i<x;i++)
				{				
						xor=xor^arr[i];
						if(xor==k)
							count++;
				}
				System.out.println(count);
			}
		}
	}
}