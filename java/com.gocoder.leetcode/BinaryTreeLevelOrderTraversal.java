import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * this is solution of Binary Tree Level Order Traversal
 * <p/>
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int level = 0;

        List<Integer> rootNode = new ArrayList<>();
        rootNode.add(root.val);
        map.put(level, rootNode);

        generateNextLevelNodes(map, root, level + 1);

        for (Integer key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    private void generateNextLevelNodes(TreeMap<Integer, List<Integer>> map, TreeNode node,
        int level) {
        List<Integer> currentNode = map.get(level);

        if (currentNode == null) {
            currentNode = new ArrayList<>();
        }


        if (node.left != null) {
            currentNode.add(node.left.val);
        }

        if (node.right != null) {
            currentNode.add(node.right.val);
        }

        if (currentNode.size() != 0) {
            map.put(level, currentNode);
        }

        level++;
        if (node.left != null) {
            generateNextLevelNodes(map, node.left, level);
        }

        if (node.right != null) {
            generateNextLevelNodes(map, node.right, level);
        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        //        TreeNode root = new TreeNode(1);
        //        root.left = new TreeNode(2);
        //        root.right = new TreeNode(3);
        //
        //        root.left.left = new TreeNode(4);
        //        root.right.right = new TreeNode(5);
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrderBottom(root));
    }


    static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
