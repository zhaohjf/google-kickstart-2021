import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CatsAndDogs {

    private static String feedCatsAndDogs(int N, int D, int C, int M, String S) {

        char[] s = S.toCharArray();

        int dogCount = 0;
        for (char sc : s) {
            if (sc == 'D') {
                dogCount++;
            }
        }
        int catCount = S.length() - dogCount;

        int count = 0;
        for (char sc : s) {
            if (sc == 'D') {
                D--;
                C = C + M > catCount ? catCount : C + M;
                count++;
            } else if (sc == 'C') {
                C--;
            }

            if (D >= 0 && count == dogCount) {
                return "YES";
            }

            if (C < 0 && count < dogCount) {
                return "NO";
            }
        }

        return "NO";
    }

    private static String feedCatsAndDogs_2(int N, int D, long C, int M, String S) {

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'D') {
                if (D <= 0 || C < 0) {
                    return "NO";
                }
                D--;
                C += M;
            } else {
                C--;
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nCases = Integer.valueOf(scanner.nextLine());

        for (int i = 1; i <= nCases; ++i) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            String S = scanner.nextLine();
            System.out.println("Case #" + i + ": " + feedCatsAndDogs(Integer.valueOf(split[0]), Integer.valueOf(split[1]),
                    Integer.valueOf(split[2]),Integer.valueOf(split[3]), S));
        }
    }
}
