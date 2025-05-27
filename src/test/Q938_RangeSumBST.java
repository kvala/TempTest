public class Q938_RangeSumBST {
    private int sum;
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val){
            this.val = val;

        }

    }
     public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;
     }

    private void dfs(TreeNode root, int low, int high){
        if(root == null){
            return;

        }

        if(low <= root.val && root.val <= high  ){
            sum+= root.val;
        }

        if(root.val > low){
            dfs(root.left, low, high);
        }

        if(high > root.val){
            dfs(root.right, low, high);
        }

    }
    public static void main(String[] args){
        Q938_RangeSumBST s = new Q938_RangeSumBST();

        s.rangeSumBST(null, 0, 0);
    }
}
