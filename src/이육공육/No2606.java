package 이육공육;

/**
 * BOJ 2606 · 바이러스
 * - 문제 요약: 1번 컴퓨터를 시작점으로 감염이 퍼지는 컴퓨터 수를 계산한다.
 * - 알고리즘: 그래프 탐색 (너비 우선 탐색, 인접 행렬)
 * - 시간 복잡도: O(N²)
 * - 공간 복잡도: O(N²)
 * - 사용 이유: 인접 행렬을 순회하며 방문 표시를 하면 연결된 모든 컴퓨터를 빠르게 찾을 수 있다.
 * - 기타: ArrayList를 큐처럼 사용하지만 인접 리스트로 바꾸면 희소 그래프에서 더 효율적이다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
 예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터 는 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
 */
public class No2606 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[][] computer = new int[T+1][T+1];

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());

            computer[com1][com2] = 1;
            computer[com2][com1] = 1;
        }

        boolean[] visited = new boolean[T+1];
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        visited[1] = true;
        int i = 0;
        int cnt = 0;
        while (i < arr.size()) {
            int c = arr.get(i);
            for(int j = 1; j <= T; j++) {
                if(computer[c][j] != 0 && !visited[j]) {
                    visited[j] = true;
                    if(j != 1) {
                        arr.add(j);
                        cnt++;
                    }
                }
            }
            i++;
        }
        System.out.println(cnt);
    }
}
