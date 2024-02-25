public class HeightLabel {
    public TreeNode rewire(TreeNode t) {

        if (t == null) {
            return null;
        }

        TreeNode newNode = new TreeNode(t.info);

        newNode.left = rewire(t.left);
        newNode.right = rewire(t.right);

        newNode.info = height(newNode);

        return newNode;
    }


    public int height(TreeNode t) {

        if (t == null) {
            return 0; // changed from -1
        }

        return 1 + Math.max(height(t.left), height(t.right));
    }
}



