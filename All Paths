import java.util.*;
public class AllPaths {
    public String[] paths(TreeNode t) {

        if (t == null) {
            return new String[0];
        }

        List<String> list = new ArrayList<>();

        helper(t, "", list);

        String[] array = list.toArray(new String[list.size()]);
        Arrays.sort(array);

        return array;
    }

    public void helper(TreeNode t, String path, List<String> list) {

        path += t.info;

        if (t.left == null && t.right == null) {
            list.add(path);
        } else {

            path += "->";
            if (t.left != null) {
                helper(t.left, path, list);
            }
            if (t.right != null) {
                helper(t.right, path, list);
            }
        }
    }
}

