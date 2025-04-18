import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] minusSplit = input.split("-");

        int result = 0;

        for (int i = 0; i < minusSplit.length; i++) {
            String[] plusSplit = minusSplit[i].split("\\+"); // +는 정규표현식 특수문자니까 \\+로 써야 함
            int sum = 0;

            for (String num : plusSplit) {
                sum += Integer.parseInt(num);
            }

            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}
