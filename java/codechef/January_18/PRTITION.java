import java.io.*;
import java.util.*;
 
class PRTITION {
	public static void main(String[] args) throws IOException
	{
		Bolt sc=new Bolt(System.in);
		int t=sc.nextInt();
		StringBuffer sb=new StringBuffer();
		while(t-->0)
		{
			int x=sc.nextInt();
			int n=sc.nextInt();
			if(n<4)
			{
				sb.append("impossible");
				sb.append("\n");
				continue;
			}
			long sum=(((long)(n+1))*(long)n)/2;
			sum-=x;
			if(sum%2!=0)
			{
				sb.append("impossible");
				sb.append("\n");
				continue;
			}
			int[] arr=new int[n+1];
			for(int i=1;i<=n;i++)
			{
				if(i==x) arr[i]=0;
				else
					arr[i]=i;
			}
			int[] ans=new int[n+1];
			sum/=2;
			ans[x]=2;
			long p=0;
			for(int i=n;i>0;i--)
			{
				if(i==x)
				{
					//ans[i]=2;
					continue;
				}
				p+=arr[i];
				if(p<sum) ans[i]=1;
				else if(p>sum)
				{
					p-=i;
					int y=(int)(sum-p);
					if(y==x){
						if(x>2)
						{
							ans[1]=1;
							ans[x-1]=1;
							break;
						}
						else
						{
							ans[i+1]=0;
							ans[i]=1;
							ans[x+1]=1;
							break;
						}
					}
					else
					{
						ans[y]=1;
						break;
					} 
				}
				else
				{
					ans[i]=1;
					break;
				}
			}
			for(int i=1;i<=n;i++)
				sb.append(ans[i]);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}

class Bolt{
 
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
 
        Bolt(InputStream is) {
            in = is;
        }
 
        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }
 
        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
 
        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
 
        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }