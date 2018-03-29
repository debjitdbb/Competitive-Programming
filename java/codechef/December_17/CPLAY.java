import java.util.*;
class CPLAY
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine())
        {
            boolean flag=true;
            String s=sc.nextLine();
            int a=0,b=0;
            for(int i=1;i<=10;i++)
            {
                char c=s.charAt(i-1);
                if(c=='1')
                {
                   if(i%2==0)
                        b++;
                    else
                        a++;
                }
                int ab=Math.abs(a-b);
                if(a>b)
                {
                    int ch=check('b',i);
                    if(ab>ch)
                    {
                        System.out.println("TEAM-A "+i);
                        flag=false;
                        break;
                    }
                }
                else
                {
                    int ch=check('a',i);
                    if(ab>ch)
                    {
                        System.out.println("TEAM-B "+i);
                        flag=false;
                        break;
                    }
                }
            }
            a=0;
            b=0;
            if(!flag)
                continue;
            for(int i=11;i<=20;i+=2)
            {
                char c=s.charAt(i-1);
                char c2=s.charAt(i);
                if(c=='1')
                    a++;
                if(c2=='1')
                    b++;
                if(a>b)
                {
                    System.out.println("TEAM-A "+(i+1));
                    flag=false;
                    break;
                }
                else if(a<b)
                {
                    System.out.println("TEAM-B "+(i+1));
                    flag=false;
                    break;
                }
            }
            if(flag)
            System.out.println("TIE");
        }
    }
 
    public static int check(char ch,int i)
    {
        if(ch=='b')
        {
            if(i%2==0)
                return (10-i)/2;
            else
                return (11-i)/2;
        }
        else
        {
            if(i%2==0)
                return (10-i)/2;
            else
                return (9-i)/2;
        }
    }
} 