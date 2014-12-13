/**
 * this is solution of reverse-integer
 * <p/>
 * https://oj.leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public int reverse(int x) {
        int result = 0;

        if (x == Integer.MIN_VALUE) {
            return result;
        }

        int abs = Math.abs(x);

        while (abs != 0) {
            int t = abs % 10;

            if ((Integer.MAX_VALUE - t) / 10 < result) {
                return 0;
            }

            abs /= 10;
            result = result * 10 + t;
        }

        return x > 0 ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-2147483412));
    }
}
