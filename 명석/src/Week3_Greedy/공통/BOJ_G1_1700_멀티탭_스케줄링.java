/*
BOJ G1 1700 멀티탭 스케쥴링
1. 이미 꽂혀있으면 꽂을 필요가 없다.
2. 꽂혀있지 않지만 아직 콘센트의 자리가 남아 있을때는 그냥 꼽으면 된다
3.. 콘센트가 꽉 차 있을 때, 어느 것을 뽑는 게 좋을까?
 3-1. 이제 다신 사용되지 않는 것
 3-2. 지금 현재 꽂혀있는 것들이 다 사용된다면 가장 늦게 사용될 예정인 것
 */
package Week3_Greedy.공통;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_G1_1700_멀티탭_스케줄링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 0; i < K; i++)
            arr.addLast(Integer.parseInt(st.nextToken()));
        int count = 0;
        // 중복되는 기기가 없어야하므로 set 이용
        Set<Integer> concent = new HashSet<>();
        while (arr.size() > 0) {
            // 현재 꽂아야할 기기의 번호
            int curNum = arr.get(0);
            arr.remove(0);
            // 1. 이미 꽂혀있는 경우 _ 꽂을 필요가 없으므로 다음 순서 기기로 이동
            if (concent.contains(curNum))
                continue;
            // 2. 콘센트에는 안꽂혀있지만 자리가 남는 경우 _ 바꾼건 아니므로 꽂고 다음 순서 기기로 이동
            if (concent.size() < N && concent.add(curNum)) // 콘
                continue;
            // 3. 이미 다 꽂혀있고 하나를 뽑아야 할 경우
            // 3-2. 콘센트 중 하나를 빼야할때, 앞으로 사용될 것 중 가장 멀리 있는 것을 체크해야함.
            int idx = -1;
            int removeNum = -1;
            for (int c : concent) {
                int tmpIdx = 0;
                // 만약 기기가 뒤에 있다면 순서를 체크
                if (arr.contains(c)) {
                    tmpIdx = arr.indexOf(c);
                } else {// 3-1. 앞으로의 순서에 중복되는게 없다면 해당 기기를 뽑기
                    removeNum = c;
                    break;
                }
                // 가장 뒷 순서에 있는 기기를 저장
                if (tmpIdx > idx) {
                    idx = tmpIdx;
                    removeNum = arr.get(idx);
                }
            }
            // 콘센트에 있는 기기 뽑고, 꽂고, 카운트 증가
            concent.remove(removeNum);
            concent.add(curNum);
            count++;
        }
        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
