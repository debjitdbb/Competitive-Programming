import java.io.*;
class NW1
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		String[] days={"mon", "tues", "wed", "thurs", "fri", "sat", "sun"};
		StringBuffer sb=new StringBuffer("");
		while(t-->0)
		{
			String[] s=br.readLine().split(" ");
			int w=Integer.parseInt(s[0]);
			String str=s[1];
			int[] arr=new int[7];
			int j=0;
			for(int i=0;i<7;i++)
			{
				arr[i]=4;
				if(days[i].equals(str)) j=i;
			}
			w-=28;
			for(int i=0;i<w;i++)
			{
				arr[(j++)%7]++;
			}
			for(int i=0;i<7;i++)
				sb.append(arr[i]+" ");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}