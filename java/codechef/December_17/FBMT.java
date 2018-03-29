import java.util.*;
class FBMT
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			if(n==0)
			System.out.println("Draw");
		else
		{
			String s=sc.next();
			int a=1;
			int b=0;
			String s2="";
			boolean flag=false;
			while(n-->1)
			{
				String temp=sc.next();
				if(temp.compareTo(s)==0)
					a++;
				else if(!flag)
				{
					flag=true;
					s2=temp;
					b++;
				}
				else
					b++;
			}
			if(a>b)
				System.out.println(s);
			else if(b>a)
				System.out.println(s2);
			else
				System.out.println("Draw");
		}
		}
	}
}