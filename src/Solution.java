import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//class Solution {
//    public int[] levelOrder(TreeNode root) {
//        if (root == null) {
//            return new int[0];
//        }
//        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
//            add(root);
//        }};
//        ArrayList<Integer> res = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            res.add(node.val);
//            if (node.left != null) {
//                queue.offer(node.left);
//            }
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
//        }
//        int[] ints = new int[res.size()];
//        int index = 0;
//        for (int i :
//                res) {
//            ints[index++] = i;
//        }
//        return ints;
//    }
//}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return new LinkedList<>();
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            LinkedList<Integer> li = new LinkedList<>();
            for (int i = queue.size(); i > 0 ; i--){
                TreeNode node = queue.poll();
                li.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(li);
        }
        return res;
    }
}