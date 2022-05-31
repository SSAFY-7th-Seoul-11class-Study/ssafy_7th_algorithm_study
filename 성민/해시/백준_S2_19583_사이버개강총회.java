package hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 백준_S2_19583_사이버개강총회 {
	
	static String S,E,Q;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		
		S=st.nextToken();
		E=st.nextToken();
		Q=st.nextToken();
		
		HashSet<String> before = new HashSet<>();
		HashSet<String> after =new HashSet<>();
		
		int cnt=0;
		String str;
		while((str=br.readLine())!=null) {
			st =new StringTokenizer(str," ");
			String temp=st.nextToken();
			
			if(temp.compareTo(S)<=0) {
				before.add(st.nextToken());
			}else if(temp.compareTo(E)>=0 && temp.compareTo(Q)<=0) {
				after.add(st.nextToken());
			}
		}
		
		for(String a : before) {
			if(after.contains(a)) {
				cnt+=1;
			}
		}
		bw.write(cnt+"\n");
		br.close();
		bw.close();

	}

}
