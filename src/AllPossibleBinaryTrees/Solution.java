package AllPossibleBinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<TreeNode> result = new ArrayList<>();

    public void allPossibleFBT(int n, TreeNode t) {
//        if(n == 1){
//            if (t == null){
//                t = new TreeNode(0, null, null)
//                result.add(t);
//            }
//        }
//        if(n == 3) {
//            if(t == null)
//            {
//                TreeNode lc = new TreeNode(0, null, null);
//                TreeNode rc = new TreeNode(0, null, null);
//                t = new TreeNode(0, lc, rc);
//                result.add(t);
//            }
//        }

        //initialize left child, //initialize right child // Decrement counter by 3
        TreeNode lc = new TreeNode(0, null, null);
        TreeNode rc = new TreeNode(0, null, null);
        allPossibleFBT(n -2, t.left);
        allPossibleFBT(n-2, t.right);
    }

    public List<TreeNode> allPossibleFBT(int n) {
        if(n % 2 == 0) {
            return null;
        }
        return null;
    }
}
