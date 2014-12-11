import java.util.ArrayList;
import java.util.List;


/**
 * this is solution of Pascal's Triangle II
 * <p/>
 * https://oj.leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> last = new ArrayList<>();
        last.add(1);

        for (int i = 0; i < rowIndex; i++) {
            for (int j = last.size() - 2; j >= 0; j--) {
                last.set(j + 1, last.get(j) + last.get(j + 1));
            }
            last.add(1);
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangleII().getRow(9));
    }
}
