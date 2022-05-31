package hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 백준_S4_1620_나는야포켓몬마스터이다솜 {
	
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> hash1 = new HashMap<Integer,String>();
		HashMap<String,Integer> hash2 = new HashMap<String,Integer>();
		
		for(int i=1;i<=N;i++) {
			String S=br.readLine();
			hash1.put(i, S);
			hash2.put(S, i);
		}
		
		for(int i=0;i<M;i++) {
			String S=br.readLine();
			
			if(49<=S.charAt(0) && S.charAt(0)<=57) {
				bw.write(hash1.get(Integer.parseInt(S))+"\n");
			}else {
				bw.write(hash2.get(S)+"\n");
			}
		}
		br.close();
		bw.close();
	}

}
