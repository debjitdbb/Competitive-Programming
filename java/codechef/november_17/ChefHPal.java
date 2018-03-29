import java.util.Scanner;
class ChefHPal
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int a=sc.nextInt();
			if(a>2)
			{
				StringBuffer sb=new StringBuffer();
				int x=n/3;
				int r=n%3;
				for(int i=0;i<x;i++)
					sb.append("abc");
				for(int i=0;i<r;i++)
					sb.append("abc".charAt(i));
				System.out.println("1 "+sb.toString());
			}
			else if(a==1)
			{
				StringBuffer sb=new StringBuffer();
				for(int i=0;i<n;i++)
				{
					sb.append('a');
				}
				System.out.println(n+" "+sb.toString());
			}
			else if(a==2)
			{
				StringBuffer sb=new StringBuffer();
				if(n==1) System.out.println("1 a");
				else if(n==2) System.out.println("1 ab");
				else
				{
					String s="bbabaa"; 
					int x=n/6;
					int y=n%6;
                    for(int i=0;i<x;i++)
                    sb.append(s);
                    for(int i=0;i<y;i++)
                    sb.append((s.charAt(i)));
                    if(n>8)
                    System.out.println("4 "+sb);
                    else
                    {
                        if(n==3)
                        System.out.println("2 aab");
                        else if(n==4)
                        System.out.println("2 aabb");
                        else if(n==7)
                        System.out.println("3 aaababb");                        
                        else if(n==8)
                        System.out.println("3 aaababbb");
                        else
                        {
                        	System.out.println("3 "+sb);
                        }                        
                    }
				}
			}
		}
	}
}