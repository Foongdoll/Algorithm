package 일공일이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/** # 백준 1012번 유기농 배추
 * 차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다.
 * 농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에, 한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다.
 * 이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다. 특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어,
 * 그 배추들 역시 해충으로부터 보호받을 수 있다. 한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.
 *
 * 한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어 놓았다. 배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다.
 * 예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의 배추흰지렁이가 필요하다. 0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.
* */
public class No1012 {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로
            int N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 배추 수

            int[][] farm = new int[N][M];

            // 배추 심기
            for (int i = 0; i < K; i++) {
                StringTokenizer xy = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(xy.nextToken());
                int y = Integer.parseInt(xy.nextToken());
                farm[y][x] = 1;
            }

            int cnt = 0;

            // 전부 돌면서 1이면 새 덩어리 발견 → BFS로 연결된 1을 모두 2로 마킹
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (farm[y][x] == 1) {
                        cnt++;
                        bfs(farm, N, M, y, x);
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }

    private static void bfs(int[][] farm, int N, int M, int sy, int sx) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        farm[sy][sx] = 2;               // 방문 마킹
        q.offer(new int[]{sy, sx});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (0 <= ny && ny < N && 0 <= nx && nx < M && farm[ny][nx] == 1) {
                    farm[ny][nx] = 2;   // 방문 마킹
                    q.offer(new int[]{ny, nx});
                }
            }
        }
    }
}
