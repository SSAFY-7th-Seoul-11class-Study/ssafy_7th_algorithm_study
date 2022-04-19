package 정렬;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;




public class 백준_G2_1377_버블소트 {
	static int N;
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		
		Data[] datas =new Data[N];
		
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(br.readLine());
			datas[i]=new Data(num,i);
		}
		
		Arrays.sort(datas);
		
		for(int i=0;i<N;i++) {
			ans=Math.max(ans,datas[i].index-i);
		}
		bw.write((ans+1)+"\n");
		br.close();
		bw.close();
		
	}
}

class Data implements Comparable<Data>{
	int num;
	int index;
	
	public Data(int num, int index) {
		super();
		this.num = num;
		this.index = index;
	}

	@Override
	public int compareTo(Data o) {
		return num-o.num;
	}
	
	
	
}
