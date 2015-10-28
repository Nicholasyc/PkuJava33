/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //��Ÿ��ڵ�
		Stack<TreeNode> stack = new Stack<>();
		//����ӽڵ�
		Stack<TreeNode> stack2 = new Stack<>();
		// ���ڵ�洢
// 		TreeNode top;
		// ��ֹ�սڵ�
		if (root == null) {
			return res;
		}
		// ��ֹһ�������ڵ�
		if (root != null && root.left == null && root.right == null) {
			res.add(root.val);
			return res;
		}
		while (true) {
            //�������ӽڵ㶼�Ѿ������������ڵ�
			if (root.right != null && stack2.size() > 0
					&& stack2.contains(root.right)) {
				res.add(root.val);
				if (stack.size() == 0) {
				// 	res.add(root.val);
					return res;
				}
				stack2.add(root);
				root = stack.pop();
				continue;
			} else if (root.left != null && root.right == null
					&& stack2.size() > 0 && stack2.contains(root.left)) {
				// �������ӽڵ㶼�Ѿ������ֻ�������������
				res.add(root.val);
				if (stack.size() == 0) {
					return res;
				}
				stack2.add(root);
				root = stack.pop();
				continue;
			} else if (root.left != null && root.right != null
					&& stack2.size() > 0 && stack2.contains(root.left)) {
			    //������ȫ�������꣬��ʼ����������
				stack.push(root);
				root = root.right;
				continue;
			} else {
			    //�ӽڵ㻹û�б����꣬�����ӽڵ�
				if (root.left != null) {
					stack.push(root);
					root = root.left;
					continue;
				} else if (root.right != null) {
					stack.push(root);
					root = root.right;
					continue;
				} else {
					res.add(root.val);
				// 	if (stack.size() == 0) {
				//     	return res;
				//     }
					stack2.add(root);
					// if(stack.size()>0){
					root = stack.pop();

				}
			}

		}
    }
}