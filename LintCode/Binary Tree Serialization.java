//method1

//BFS
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        
        if (root == null) return "{}";
        
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            if (node == null) continue;
            list.add(node.left);
            list.add(node.right);
        }
        
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(list.get(0).val);
        
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(list.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }
    
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) return null;
        
        String[] vals = data.substring(1, data.length() - 1).split(",");
        
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        list.add(root);
        
        int index = 0;
        boolean isLeftChild = true;
        
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    list.get(index).left = node;
                } else {
                    list.get(index).right = node;
                }
                list.add(node);
            }
            if (!isLeftChild) index++;
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}

//BFS
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        serialHelper(root, sb);
        return sb.substring(0, sb.length() - 1);
        
    }
    private void serialHelper(StringBuilder result, TreeNode root) {
        if (root == null) {
            result.append("#").append(",");
            return;
        }
        result.append(root.val).append(",");
        serialHelper(result, root.left);
        serialHelper(result, root.right);
        
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        
        StringTokenizer st = new StringTokenizer(data, ",");
        return deseriaHelper(st);
    }
    
    private TreeNode deseriaHelper(StringTokenizer st) {
        if (!st.hasMoreTokens()) return null;
        
        String val = st.nextToken();
        if (val.equals("#")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deseriaHelper(st);
        root.right = deseriaHelper(st);
        
        return root;
    }
}
