import java.util.*;
class STRMRG
{
	public static String reduce(String s)
	{
		int len=s.length();
		StringBuilder sb=new StringBuilder();
		sb.append(s.charAt(0));
		for(int i=1;i<len;i++)
		{
			if(s.charAt(i)!=s.charAt(i-1))
				sb.append(s.charAt(i));
		}
		
		return sb.toString();
	}

	public static int lcs(String s1,String s2,int m,int n)
    {
        // int m=s1.length();
        // int n=s2.length();
        int[][] arr = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    arr[i][j]=1+arr[i-1][j-1];
                else
                {
                    arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        return arr[m][n];
    }

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			String s1=reduce(sc.next());
			String s2=reduce(sc.next());
			// System.out.println(s1);
			// System.out.println(s2);
			int l1=s1.length();
			int l2=s2.length();
			int ans=lcs(s1,s2,l1,l2);
			System.out.println(l1+l2-ans);
		}
	}

}