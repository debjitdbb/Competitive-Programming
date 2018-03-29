import java.util.*;
import java.math.*;
class BinoSum
{
	//static BigInteger[][] ncr=new BigInteger[100][100];
	public static void main(String[] args)
	{
		//Arrays.fill(ncr,BigInteger.valueOf(-1));
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		long a=sc.nextLong();
		long p=sc.nextLong();
		int q=sc.nextInt();
		while(q-->0)
		{
			long l=sc.nextLong();
			long d=sc.nextLong();
			long t=sc.nextLong();
			BigInteger sum=BigInteger.ZERO;
			for(int i=1;i<=t;i++)
			{
				sum=sum.add((c(d++,l)).multiply(BigInteger.valueOf(a)));
			}
			System.out.println(sum.mod(BigInteger.valueOf(p)));
		}
	}

	public static BigInteger c(long n,long r)
	{
		//if(ncr[(int)n][(int)r].equals(BigInteger.valueOf(-1))!=true)
		//	return ncr[(int)n][(int)r];
		if( r == 0 || n == r)
			return BigInteger.valueOf(1);
		BigInteger ans = (c(n-1,r).add(c(n-1,r-1)));
		return  ans;
	}	
}
