import java.util.*;
import java.io.*;
class CSubQ{
    public static void main(String args[])throws IOException{
        Scanner sc=new Scanner(System.in);
        int i;
        int t;
        int x;
        int y;
        int z;
        int j;
        int n=sc.nextInt();
        int q=sc.nextInt();
        int l=sc.nextInt();
        int r=sc.nextInt();
        int arr[]=new int[n];
        for(j=1;j<=q;j++){
            x=sc.nextInt();
            y=sc.nextInt();
            z=sc.nextInt();
            if(x==1)
                arr[y-1]=z;
            else
                sub(y-1,z-1,arr,l,r);
        }
    }
    public static void sub(int a,int b,int c[],int l,int r){
        int i;
        int st=a;
        int x=0;
        int p=0;
        int d=0;
        for(i=a;i<=b;i++){
            if(c[i]>r){
                st=i+1;
                p=0;
                d=0;
                continue;
            }
            if(c[i]<l){
                if(p>0){
                    x+=d-st+1;
                    continue;
                }
                continue;
            }
            p++;
            d=i;
            x+=i-st+1;
        }
        System.out.println(x);
    }
}