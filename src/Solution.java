import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root == null){
            return new LinkedList<>();
        }
        queue.add(root);
        int flag = 1;
        while (!queue.isEmpty()) {
            LinkedList<Integer> li = new LinkedList<>();
            ArrayDeque<TreeNode> preQ = new ArrayDeque<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.pollFirst();
                li.add(node.val);
                if (flag == 1){
                    if (node.left != null){
                        preQ.offerFirst(node.left);
                    }
                    if (node.right != null){
                        preQ.offerFirst(node.right);
                    }
                } else {
                    if (node.right != null){
                        preQ.offerFirst(node.right);
                    }
                    if (node.left != null){
                        preQ.offerFirst(node.left);
                    }
                }
            }
            queue = preQ;
            flag = -flag;
            res.add(li);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<List<Integer>> lists1 = solution.levelOrder(root);
        lists1.forEach(System.out::println);
    }
}





