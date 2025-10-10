package 일육이공;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 입력한 사전 내 이름과 순서대로 번호를 넣고, 번호를 넣으면 이름을 이름을 넣으면 번호를 출력하도록
 * */
public class No1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, String> dictionary = new HashMap<>();
        int dictionaryNumber = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            String input = br.readLine();
            dictionary.put(dictionaryNumber+"", input);
            dictionary.put(input, dictionaryNumber+"");
            dictionaryNumber++;
        }

        for(int i = 0; i < M; i++){
            String find = br.readLine();
            sb.append(dictionary.get(find)).append("\n");
        }
        System.out.println(sb);
    }
}
