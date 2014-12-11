import java.util.ArrayList;
import java.util.List;


/**
 * this is solution of Pascal's Triangle
 * <p/>
 * https://oj.leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows <= 0) {
            return result;
        }

        for (int m = 1; m <= numRows; m++) {
            result.add(generateRow(m));
        }
        return result;
    }

    public List<Integer> generateRow(int row) {
        ArrayList<Integer> last = new ArrayList<>();
        last.add(1);

        for (int i = 1; i < row; i++) {
            for (int j = last.size() - 2; j >= 0; j--) {
                last.set(j + 1, last.get(j) + last.get(j + 1));
            }
            last.add(1);
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle().generate(9));
    }
}
