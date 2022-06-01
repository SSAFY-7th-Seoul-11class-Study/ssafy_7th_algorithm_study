package hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 백준_G5_2866_문자열잘라내기 {
	
	static int R,C;
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		count=0;
		
		st=new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		ArrayList<String> list =new ArrayList<>();
		
		for(int r=0;r<R;r++) {
			list.add(br.readLine());
		}
		
		ArrayList<String> collist= cols(list,C);
		int idx=1;
		while(true) {
			if(dup(collist,idx)) {
				bw.write(count+"\n");
				break;
			}else {
				count++;
				idx++;
			}
		}
		
		br.close();
		bw.close();
	}
	
	public static ArrayList<String> cols(ArrayList<String>list,int C) {
		ArrayList<String> tmp=new ArrayList<>();
		
		for(int c=0;c<C;c++) {
			StringBuilder sb = new StringBuilder();
			
			for(String s: list) {
				sb.append(s.charAt(c));
			}
			
			tmp.add(sb.toString());
		}
		return tmp;
	}
	
	public static boolean dup(ArrayList<String> list,int idx) {
		Map<String,Integer> map=new HashMap<>();
		
		for(String col:list) {
			col=col.substring(idx);
			map.put(col, map.getOrDefault(col, 0)+1);
			
			if(map.get(col)>=2) {
				return true;
			}
		}
		return false;
	}

}
