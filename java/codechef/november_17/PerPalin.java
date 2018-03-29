import java.util.*;
class PerPalin
{
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int p=sc.nextInt();
			if(n<3 || p<3)
			System.out.println("impossible");
				else
				{
					int x=n/p;
					StringBuffer str=new StringBuffer();
					int i=0;
					while(i<x)
					{
						if(p%2==0)
						{
							StringBuffer sb=new StringBuffer();
							for(int j=0;j<(p/2)-1;j++)
							{
								sb.append("a");
							}							
							sb.append("b");
							str.append(sb);
							str.append(sb.reverse());
						}
						else
						{
							for(int j=0;j<p/2;j++)
							{
								str.append("a");
							}							
							str.append("b");
							for(int j=0;j<p/2;j++)
							str.append("a");
						}
						i++;
					}
					System.out.println(str);
				}
			}
		}
	}
