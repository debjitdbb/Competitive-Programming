import java.io.*;
import java.util.*;
 
class SQRGOOD {
    public static void main(String[] args) throws IOException
    {
        Bolt sc=new Bolt(System.in);
        ArrayList<Long> prime_arr = new ArrayList<Long>();
        int pp=0;
        int n=10000;
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;
        for(int p = 2; p*p <=n; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true){
                prime_arr.add(pp++,(long)(i*i));
                //str=str.append(i*i).append("\n");
            }
        }

        //test prime_arr
        // for(int i=0;i<prime_arr.size();i++)
        //     System.out.println(prime_arr.get(i));

        long input=sc.nextLong();
        boolean[] flag=new boolean[100000000];
        long limit=100000000;
        for(long i=0;i<pp;i++)
        {
         long sq=prime_arr.get((int)i);
         for(long j=1;sq*j<100000000;j++)
             flag[(int)(sq*j)]=true;
        }
        long count=0;
        for(int i=0;i<100000000;i++)
        {
         if(flag[i])
             count++;
         if(count==input)
         {
             System.out.println(i);
             break;
         }
        }
    }

    // public static void sieveOfEratosthenes()
    // {
    //     StringBuffer str=new StringBuffer();
    //     int pp=0;
    //     int n=100000;
    //     boolean prime[] = new boolean[n+1];
    //     for(int i=0;i<n;i++)
    //         prime[i] = true;
    //     for(int p = 2; p*p <=n; p++)
    //     {
    //         if(prime[p] == true)
    //         {
    //             for(int i = p*2; i <= n; i += p)
    //                 prime[i] = false;
    //         }
    //     }
    //     for(int i = 2; i <= n; i++)
    //     {
    //         if(prime[i] == true){
    //             prime_arr[pp++]=i*i;
    //             //str=str.append(i*i).append("\n");
    //         }
    //     }
    //     //System.out.println(str);
    // }
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