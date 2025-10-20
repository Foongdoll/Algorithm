package 구삼칠오;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No9375 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 옷 이름은 필요 없음
                String type = st.nextToken(); // 옷 종류
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int count : map.values()) {
                result *= (count + 1); // 해당 종류 안 입는 경우(+1)
            }

            System.out.println(result - 1); // 전부 안 입는 경우 제외
        }
    }
}
