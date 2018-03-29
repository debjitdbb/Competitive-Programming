import java.io.*;
import java.util.*;
 
class KILLKTH {
	public static void main(String[] args) throws IOException
	{
		Bolt sc=new Bolt(System.in);
		String s=sc.next();
		int len=s.length();
		int count=0;
		String[] arr=new String[(len+1)*(len)/2];
		//Arrays.sort(carr);
		//s=new String(carr);
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<len;i++)
		{
			for(int j=i;j<len;j++)
			{
				arr[count++]=s.substring(i,j+1);
				//System.out.println(arr[count-1]);
				//System.out.println(sb);
			}
		}
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++)
			sb.append(arr[i]);
		//System.out.println(sb);
		int q=sc.nextInt();
		long g=0;
		while(q-->0)
		{
			int p=sc.nextInt();
			int m=sc.nextInt();
			long k=(p*g)%m + 1;
			//System.out.println(k);
			//System.out.println(g);
			char c=sb.charAt((int)(k-1));
			System.out.println(c);
			g+=(c-'a'+97);
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