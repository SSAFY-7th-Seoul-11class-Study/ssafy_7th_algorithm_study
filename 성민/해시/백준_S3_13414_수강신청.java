package hash;

import java.io.*;
import java.util.*;

public class 백준_S3_13414_수강신청 {
	
	static int K; //수강 가능 인원
	static int L; //순서를 기록한 대기 목록 길이
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st =new StringTokenizer(br.readLine()," ");
		
		K=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		
		LinkedHashSet<String> hs = new LinkedHashSet<>();
		
		for(int i=0;i<L;i++) {
			String str=br.readLine();
			
			//이미 대기목록에 있으면 지우고 추가
			if(hs.contains(str)) {
				hs.remove(str);
			}
			hs.add(str);
		}
		
		Iterator<String> it =hs.iterator();
		
		while(it.hasNext()) {
			bw.write(it.next()+"\n");
			K--;
			
			if(K==0) {
				break;
			}
		}
		
		br.close();
		bw.close();
		
	}

}
