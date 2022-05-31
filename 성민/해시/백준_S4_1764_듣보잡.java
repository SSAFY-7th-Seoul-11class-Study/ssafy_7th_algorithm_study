package hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 백준_S4_1764_듣보잡 {

	static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		HashSet<String> set =new HashSet<>();
		ArrayList<String> list=new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		
		for(int i=0;i<M;i++) {
			String s=br.readLine();
			
			if(set.contains(s)) {
				list.add(s);
			}
		}
		
		Collections.sort(list);
		
		bw.write(list.size()+"\n");
		
		for(int i=0;i<list.size();i++) {
			bw.write(list.get(i)+"\n");
		}
		
		br.close();
		bw.close();
	}

}
