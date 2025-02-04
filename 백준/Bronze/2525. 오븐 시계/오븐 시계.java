import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        
        int time = Integer.parseInt(br.readLine());
        // System.out.println(hour + " " +  minute + " "+ time);

        minute += time;
        // System.out.println("분 :" + minute);
        if(minute >= 60){
            int plusHour = minute / 60;
            hour += plusHour;
            minute = minute % 60;
            // System.out.println("plusHour :" + plusHour);
        }
        
        if(hour >= 24){
           hour = hour % 24;
        }

        System.out.print(hour + " " + minute);
    }
}