package hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 백준_G5_1351_무한수열 {

	static long N,P,Q;
	static HashMap<Long,Long> map;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		
		N=Long.parseLong(st.nextToken());
		P=Long.parseLong(st.nextToken());
		Q=Long.parseLong(st.nextToken());

		
		
		map=new HashMap<Long,Long>();
		
		bw.write(go(N)+"\n");
		br.close();
		bw.close();
	}
	
	public static long go(long n) {
		if(n==0)
			return 1;
		
		if(map.containsKey(n)) { //해당하는 key 찾기
			return map.get(n);
		}
		
		map.put(n,go(n/P)+go(n/Q));
		
		return map.get(n);
	}

}
