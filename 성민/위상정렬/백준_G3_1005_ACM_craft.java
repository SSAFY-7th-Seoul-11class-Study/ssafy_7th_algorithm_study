package 위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 처음 indegree 가 0 인 건물들은 이전 테크가 없기 때문에 총 소요시간이 d[i] 입니다.

2. Queue에서 건물을 빼면서 해당 건물과 연결된 다른 건물들의 result 를 갱신해줍니다.

3. 이전까지의 소요시간 result[node] + 현재 건물의 소요시간 d[i] 로 이루어지며 이전 테크가 전부 올라가야 현재 건물을 지을 수 있기 때문에 가장 오래 걸리는 시간으로 갱신해줍니다.
 * @author Me1st
 *
 */
public class 백준_G3_1005_ACM_craft {
	static int n;   // 노드 갯수
    static int k;   // 간선 갯수
    static int[] d;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int tc = Integer.parseInt(br.readLine());
 
        for(int t=0; t<tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            d = new int[n+1];
 
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            for(int i=0; i<n+1; i++)
                list.add(new ArrayList<Integer>());
 
            int[] indegree = new int[n+1];
 
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++)
                d[i] = Integer.parseInt(st.nextToken());
    
            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
    
                // v1 -> v2
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
    
                list.get(v1).add(v2);
                indegree[v2]++;
            }
 
            int w = Integer.parseInt(br.readLine());
    
            topologicalSort(indegree, list, w);    
        }
    }
 
    static void topologicalSort(int[] indegree, List<List<Integer>> list, int w) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] result = new int[n+1];
 
        // 건물의 소요 기본 소요시간은 d[i]
        for(int i=1; i<=n; i++) {
            result[i] = d[i];
 
            if(indegree[i] == 0)
                q.offer(i);
        }
 
        // 건물의 총 소요시간 = 이전까지의 소요시간 + 현재 건물 소요시간
        // Max 해주는 이유는 이전 테크가 다 올라야 현재 건물을 지을 수 있기 때문
        while(!q.isEmpty()) {
            int node = q.poll();
 
            for(Integer i : list.get(node)) {
                result[i] = Math.max(result[i], result[node] + d[i]);
                indegree[i]--;
 
                if(indegree[i] == 0)
                    q.offer(i);
            }
        }
 
        System.out.println(result[w]);
	}

}
