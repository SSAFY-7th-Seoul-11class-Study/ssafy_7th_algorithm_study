package hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class 백준_S4_1544_사이클단어 {
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		
		HashSet<String> hash =new HashSet<>();
		
		hash.add(br.readLine()); //첫 단어 저장
		
		for(int i=1;i<N;i++) {
			check(hash,br.readLine());
		}
		
		bw.write(hash.size()+"\n");
		br.close();
		bw.close();
	}
	
	public static void check(HashSet<String> hash,String S) {
		int n=S.length();
		StringBuilder sb;
		
		for(String str : hash) {
			sb=new StringBuilder(str);
			for(int i=0;i<n;i++) {
				//같은 단어면 종료
				if(S.equals(sb.toString()))
					return;
				
				//다른 단어면 순환
				else {
					sb=sb.append(sb.charAt(0)).deleteCharAt(0);
				}
			}
		}
		
		//다 돌려봐도 같지 않으면 새로운 단어
		hash.add(S);
	}

}
