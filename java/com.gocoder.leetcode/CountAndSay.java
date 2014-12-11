/**
 * this is solution of Count and Say
 * <p/>
 * https://oj.leetcode.com/problems/count-and-say/
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String result = "1";
        if (n <= 0) {
            return result;
        }

        for (int i = 1; i < n; i++) {
            int count = 1;

            StringBuilder tmp = new StringBuilder();
            for (int m = 0; m < result.length(); m++) {
                if (m < result.length() - 1 && result.charAt(m) == result.charAt(m + 1)) {
                    count++;
                } else {
                    tmp.append(count).append(result.charAt(m));
                    count = 1;
                }
            }
            result = tmp.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(5));
    }
}
