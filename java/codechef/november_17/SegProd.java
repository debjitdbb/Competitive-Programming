import java.util.*;
import java.math.*;
class SegProd{
    public static void main(String[] args) {
    try{
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int p=sc.nextInt();
            int q=sc.nextInt();
            BigInteger a[]=new BigInteger[n];
            int b[]=new int[(int)(Math.floor(q/64))+2];
            long a0=sc.nextLong();
            a[0]=BigInteger.valueOf(a0);
            for(int i=1;i<n;i++){
                long sdf=sc.nextLong();
                //a[i]=((prod%p)*(sdf%p))%p;
                a[i]=a[i-1].multiply(BigInteger.valueOf(sdf));
                //prod=a[i];
            }
            
            for(int i=0;i<b.length;i++)
                b[i]=sc.nextInt();
            int x=0;
            int l=0;
            int r=0;
            int ll=0;
            int rr=0;
            int u=0;
            for(int i=0;i<q;i++){
                if(i%64==0){
                    l=(b[i/64]+x)%n;
                    r=(b[i/64+1]+x)%n;
                }
                else{
                    l=(ll+x)%n;
                    r=(rr+x)%n;
                }
                BigInteger prod1;
                //System.out.println("l "+l+" r "+r);
                if(l>r){
                    prod1=a[l];
                    if(r>0)
                        prod1=prod1.divide(a[r-1]);
                    else
                        prod1=prod1.divide(a[r]);
                    
                }
                else{
                    prod1=a[r];
                    if(l>0)
                        prod1=prod1.divide(a[l-1]);
                    else
                        prod1=prod1.divide(a[l]);
                }
                x=(prod1.mod(BigInteger.valueOf(p))).intValue()+1;
                //System.out.println("x "+x);
                ll=l;
                rr=r;
                u=x;
            }
            System.out.println(x);
     
        }
        }
        catch(Exception e){
        return;
        }
    }     
}