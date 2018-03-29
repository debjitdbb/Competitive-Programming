import java.io.*;
class VilTribe
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0)
		{
			String s=br.readLine();
			char[] arr=s.toCharArray();
			int size=arr.length;
			int counta=0,index=0,countb=0;
			char prev=' ';
			boolean flag=false;
			for(int i=0;i<size;i++)
			{
				char ch=arr[i];
				if(ch=='.')
					continue;
				if(!flag)
				{
					if(ch=='A')
					{
						prev='A';
						index=i;
						counta++;
						flag=true;
					}
					else if(ch=='B')
					{
						prev='B';
						index=i;
						countb++;
						flag=true;
					}
				}

				else
				{
					if(ch=='A')
					{
						if(prev=='A')
						{
							counta+=i-index;
							index=i;
						}
						else if(prev=='B')
						{
							prev='A';
							counta++;
							index=i;
						}
					}

					else if(ch=='B')
					{
						if(prev=='B')
						{
							countb+=i-index;
							index=i;
						}
						else if(prev=='A')
						{
							prev='B';
							countb++;
							index=i;
						}
					}
				}
			}
			System.out.println(counta+" "+countb);
		}
	}
}