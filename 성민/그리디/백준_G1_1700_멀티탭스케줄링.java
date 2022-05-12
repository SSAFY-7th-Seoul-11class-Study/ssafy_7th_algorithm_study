package greedy;
/**
 * 1. 전기용품이 이미 꽂힌거면 그대로(할게 없음) => Set을 써야함
 * 2. 플러그 꽂아져있지 않은데 플러그 공간이 있으면 그냥 꽂으면 됨.
 * 3. 플러그 다 차 있으면 플러그 제거 하고 새로운거 꽂기
 *  => 근데 우리가 구하는게 최소횟수니까 제거 할 플러그를 잘 생각해서 빼야 함.
 *     나중에 다시는 사용 안할 꺼를 빼준다.
 *      
 *
 * @author Me1st
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class 백준_G1_1700_멀티탭스케줄링 {
	static int N,K; // 콘센트 개수, 전기용품개수
	static int Product[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Product = new int[K];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			Product[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		
		Set<Integer> set = new HashSet<>(); // 이 set을 멀티탭으로 쓸거
		for(int i = 0; i < K; i++) {
			//이미 꽃혀있는 전기제품인 경우 continue
			if(set.contains(Product[i]))
				continue;
			
			//멀티탭이 꽉 찾을 때
			if(N <= set.size()) {
				List<Integer> list = new ArrayList<>();		// 남은 전기제품 순서 중에서 사용중인 전기제품(순서대로 들어간다.)
				List<Integer> remain = new ArrayList<>(set);	// 멀티탭에 꽂힌 제품들 (=> 이후에 들어올 제품에서 다시는 안쓸거를 찾기 위해 만듬)
				
				// 위에서 선언한 list와 remain을 구한다.
				for(int j = i; j < K; j++) { //N개만 큼 제품이 들어갔을 꺼니까 i번째 부터 뒤에 것들
					if(set.contains(Product[j]) && !list.contains(Product[j])) { //콘센트에 있으면서 list에 없는거라면(
						list.add(Product[j]); //리스트엔 추가
						remain.remove(Integer.valueOf(Product[j])); //remain에선 삭제 ( 다시는 안쓸 제품이 아니니까)
					}
				}
				
				
				if(list.size() == N) {
					set.remove(list.get(list.size()-1));
				} // 전부 사용중이 아닌 경우 사용하지 않는 전기용품을 제거한다.
				else {
					set.remove(remain.get(0));
				}
				
				// 멀티탭이 다 찬 경우 무조껀 코드  빼니까 값 추가
				ans++;
			}
			
			//멀티탭에 여유가 있을 때  멀티탭에 추가
			set.add(Product[i]);
		}
		
		System.out.print(ans);
	}
}
