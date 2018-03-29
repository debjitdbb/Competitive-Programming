import java.io.*;
import java.util.*;
class MAXSC
{
	public static void main(String[] args) throws IOException
    {
        Bolt sc=new Bolt(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
        	int n=sc.nextInt();
        	int[][] arr=new int[n][n];
        	for(int i=0;i<n;i++)
        	{
        		for(int j=0;j<n;j++)
        		{
        			arr[i][j]=sc.nextInt();
        		}
        		Arrays.sort(arr[i]);
        	}
        	long count=0;
        	int prev=arr[n-1][n-1];
        	count+=prev;
        	for(int i=n-2;i>=0;i--)
        	{
        		for(int j=n-1;j>=0;j--)
        		{
        			if(arr[i][j]<prev)
        			{
        				count+=arr[i][j];
        				prev=arr[i][j];
        				break;
        			}
        			if(j==0)
        			{
        				count=-1;
        				i=-1;
        			}
        			//if(count==-1) break;
        		}
        	}
        	System.out.println(count);
        }
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