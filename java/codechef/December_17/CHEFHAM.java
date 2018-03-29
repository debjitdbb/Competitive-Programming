import java.util.*;
import java.io.*;
class CHEFHAM
{
    public static void main(String [] args) throws Exception
    {
        Bolt sc=new Bolt(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            if(n==1)
            {
                System.out.println(0);
                System.out.println(arr[0]);
                continue;
            }
            if(n==2)
            {
                if(arr[0]==arr[1])
                {
                    System.out.println(0);
                    System.out.println(arr[0]+" "+arr[1]);
                }
                else
                {
                    System.out.println(2);
                    System.out.println(arr[1]+" "+arr[0]);
                }
                continue;
            }
            if(n==3)
            {
                if(arr[0]==arr[1] && arr[1]==arr[2])
                {
                    System.out.println(0);
                    System.out.println(arr[0]+" "+arr[2]+" "+arr[1]);
                }
                else if(arr[0]==arr[1])
                {
                    System.out.println(2);
                    System.out.println(arr[0]+" "+arr[2]+" "+arr[1]);
                }
                else if(arr[1]==arr[2])
                {
                    System.out.println(2);
                    System.out.println(arr[1]+" "+arr[2]+" "+arr[0]);
                }
                else if(arr[0]==arr[2])
                {
                    System.out.println(2);
                    System.out.println(arr[1]+" "+arr[2]+" "+arr[0]);
                }
                else
                {
                    System.out.println(3);
                    System.out.println(arr[1]+" "+arr[2]+" "+arr[0]);
                }
                continue;
            }

            else
            {
                int[] ans=new int[n];
                int count=0;
                int ub=0;
                if(n%4==0)
                    ub=n;
                else if(n%4==3 && (arr[n-1]!=arr[n-2]) && (arr[n-2]!=arr[n-3]) && arr[n-1]!=arr[n-3])
                {
                    count+=3;
                    ans[n-1]=arr[n-2];
                    ans[n-2]=arr[n-3];
                    ans[n-3]=arr[n-1];
                    ub=(n/4)*4;
                }
                else if(n%4==2 && (arr[n-1]!=arr[n-2]))
                {
                    count+=2;
                    ans[n-1]=arr[n-2];
                    ans[n-2]=arr[n-1];
                    ub=(n/4)*4;
                }
                else if(n%4==2)
                {
                    if(arr[n-6]!=arr[n-3])
                    {
                        ans[n-6]=arr[n-3];
                        ans[n-3]=arr[n-6];
                        ans[n-1]=arr[n-4];
                        ans[n-4]=arr[n-1];
                        ans[n-2]=arr[n-5];
                        ans[n-5]=arr[n-2];
                        count+=6;
                    }
                    else
                    {
                        ans[n-6]=arr[n-5];
                        ans[n-5]=arr[n-6];
                        ans[n-1]=arr[n-4];
                        ans[n-4]=arr[n-1];
                        ans[n-2]=arr[n-3];
                        ans[n-3]=arr[n-2];
                        count+=6;
                    }
                    ub=((n/4)-1)*4;
                }
                else if(n%4==1)
                {
                    ans[n-4]=arr[n-1];
                    ans[n-5]=arr[n-2];
                    ans[n-2]=arr[n-5];
                    ans[n-3]=arr[n-4];
                    ans[n-1]=arr[n-3];
                    count+=5;
                    ub=((n/4)-1)*4;
                }
                else if(n%4==3)
                {
                    ans[n-4]=arr[n-1];
                    ans[n-5]=arr[n-2];
                    ans[n-1]=arr[n-6];
                    ans[n-2]=arr[n-4];
                    ans[n-6]=arr[n-3];
                    ans[n-7]=arr[n-5];
                    ans[n-3]=arr[n-7];
                    count+=7;
                    ub=((n/4)-1)*4;
                }

                for(int i=0;i<ub;i+=4)
                {
                    if((arr[i]==arr[i+1]) || (arr[i+2]==arr[i+3]))
                    {
                        ans[i]=arr[i+2];
                        ans[i+1]=arr[i+3];
                        ans[i+2]=arr[i];
                        ans[i+3]=arr[i+1];
                        count+=4;
                    }
                    else if((arr[i]==arr[i+2]) || (arr[i+1]==arr[i+3]))
                    {
                        ans[i+1]=arr[i+2];
                        ans[i]=arr[i+1];
                        ans[i+2]=arr[i+3];
                        ans[i+3]=arr[i];
                        count+=4;
                    }
                    else if((arr[i]==arr[i+3]) || (arr[i+1]==arr[i+2]))
                    {
                        ans[i]=arr[i+1];
                        ans[i+1]=arr[i];
                        ans[i+2]=arr[i+3];
                        ans[i+3]=arr[i+2];
                        count+=4;
                    }
                    else
                    {
                        ans[i]=arr[i+1];
                        ans[i+1]=arr[i+2];
                        ans[i+2]=arr[i+3];
                        ans[i+3]=arr[i];
                        count+=4;
                    }
                }


                System.out.println(count);
                for(int i=0;i<n;i++)
                {
                    System.out.print(ans[i]+" ");
                }
                System.out.println();
            }
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
