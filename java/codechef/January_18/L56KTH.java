import java.util.*;
import java.io.*;
class L56KTH
{
	public static void main(String[] args) throws IOException
	{
		Bolt sc = new Bolt(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] arr=new int[n];
		int size=n*(n+1)/2;
		long[] ans=new long[size];
		int c=0;
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
				ans[c++]=f(i,j,arr);
		}
		Arrays.sort(ans);
		System.out.println(ans[k-1]);
	}

	public static long f(int l,int r,int[] arr)
	{
		long xor=arr[l];
		long min=arr[l];
		for(int i=l+1;i<=r;i++)
		{
			if(arr[i]<min)
				min=arr[i];
			xor=xor^arr[i];
		}
		return (min*xor);
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