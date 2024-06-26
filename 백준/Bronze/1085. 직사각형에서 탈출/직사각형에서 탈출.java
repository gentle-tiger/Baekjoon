import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

//       현재 위치 (x,y)
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
//      직사각형의 크기(w(x축),h(y축))
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int a = w - x; // x축에서 w 까지의 길이
        int b = h - y; // y축에서 h 까지의 길이

        int xMin = min(x,a);
        int yMin = min(y,b);
        System.out.println(min(xMin,yMin));


    }
}
