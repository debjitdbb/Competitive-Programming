import java.io.*;
import java.util.*;
class VK18
{
    public static void main(String [] args) throws Exception
    {
        Bolt sc=new Bolt(System.in);
        int t=sc.nextInt();
        long[] arr=new long[2000001];
        long sum=0;
            for(int i=1;i<arr.length;i++)
            {
                    int r=i;
                    int odd=0,even=0;
                    while(r>0){
                        if((r%10)%2==0)
                            odd+=r%10;
                        else
                           even+=r%10;
                        r/=10;
                    }
                    arr[i]=sum+Math.abs(even-odd);
                    sum=arr[i];
                    //System.out.println(sum);                         
            }
            long[] ans=new long[1000001];
            ans[1]=2;
            sum=2;
            for(int i=2;i<ans.length;i++)
            {
                sum+=arr[2*i]+arr[2*i-1]-2*arr[i];
                ans[i]=sum;
            }
            while(t-->0)
            {
                int n=sc.nextInt();
                System.out.println(ans[n]);
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