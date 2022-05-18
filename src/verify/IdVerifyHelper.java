package verify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IdVerifyHelper {


    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        int[] letterNums =
                {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 33};
        try {
            String pathname = "src/verify/idList.txt";
            File filename = new File(pathname);
            BufferedReader br = new BufferedReader(new FileReader(String.valueOf(filename)));//構造一个BufferedReader類来讀取文件
            String s = "";
            while ((s = br.readLine()) != null) {
                System.out.println("====您輸入的身分證字號" + s + "====");
                if (s.matches("[A-Z]\\d{9}")) {
//                    s = s.toUpperCase();
                    if (s.charAt(1) == '1' || s.charAt(1) == '2') {
                        char letter = s.charAt(0); //取出第一個字母
                        s = letterNums[letter - 'A'] + s.substring(1); //變成一整串數字
                        int total = s.charAt(0) - '0';
                        if (s.length() == 11) {
                            for (int i = 1; i < 10; i++) {
                                total += (s.charAt(i) - '0') * (10 - i); //依序加總
                            }
                            //以10減去加總值之個位數後取個位數
                            int checkNum = (10 - total % 10) % 10;
                            //計算結果和最後一位數比較
                            if (checkNum == (s.charAt(10) - '0')) {
                                System.out.println("====驗證成功====");
                            } else {
                                System.out.println("====驗證失敗====");
                            }
                        } else {
                            System.out.println("====驗證失敗====");
                        }
                    } else {
                        System.out.println("====驗證失敗====");
                    }
                } else {
                    System.out.println("====驗證失敗====");
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
