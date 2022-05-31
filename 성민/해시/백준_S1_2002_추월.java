package hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 백준_S1_2002_추월 {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

		N=Integer.parseInt(br.readLine());
		
		HashMap<String,Integer> hash=new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String car=br.readLine();
			hash.put(car, i);
		}
		
		
		int cnt=0;
		int out[]= new int[N];
		
		for(int i=0;i<N;i++) {
			String car=br.readLine();
			out[i]=hash.get(car);
		}
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(out[i]>out[j]) {
					cnt++;
					break;
				}
			}
		}
		bw.write(cnt+"\n");
		br.close();
		bw.close();
	}

}
