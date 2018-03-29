import java.io.*;
import java.util.*;
 
class MONSTER {
	public static void main(String[] args) throws IOException
	{
		Bolt sc=new Bolt(System.in);
		int n=sc.nextInt();
		int[] h=new int[n];
		ArrayList<Integer> al=new ArrayList<Integer>();
		ArrayList<Integer> index=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			al.add(sc.nextInt());
			index.add(i);
		}
		int q=sc.nextInt();
		long count=0;
		while(q-->0)
		{
			count=0;
			int x=sc.nextInt();
			int y=sc.nextInt();
			for(int i=0;i<n;i++)
			{
				// if(h[i]<=0)
				// 	continue;
				if((index.get(i)&x)==index.get(i))
				{
					int a=al.get(i);
					al.set(i,a-y);
					if(al.get(i)<=0)
					{
						al.remove(i);
						index.remove(i);
						n--;
						i--;
					}
					//for(int j=0;j<index.size();j++)
					//{
						//System.out.println("index "+index.get(j)+" health "+al.get(j));
					//}
				}
				// if(h[i]>0)
				// 	count++;
			}
			System.out.println(al.size());
		}
		//System.out.print(sb);
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