package tpmp;

public class ConstructBinaryTreeFromInPre {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null)
			return null;
		if (preorder.length == 0)
			return null;
		TreeNode root = new TreeNode(preorder[0]);
		int position = getPosition(preorder[0], inorder);
		int[] leftSubInOrder = getSubOrder(inorder, position, true, true);
		int[] rightSubInOrder = getSubOrder(inorder, position, false, true);
		int[] leftSubPreOrder = getSubOrder(preorder, position, true, false);
		int[] rightSubPreOrder = getSubOrder(preorder, position, false, false);

		root.left = buildTree(leftSubPreOrder, leftSubInOrder);
		root.right = buildTree(rightSubPreOrder, rightSubInOrder);
		return root;

	}

	private int getPosition(int target, int[] targetOrder) {
		int i;
		for (i = 0; i < targetOrder.length; i++) {
			if (targetOrder[i] == target) {
				return i;
			}
		}
		return 0;
	}

	private int[] getSubOrder(int[] targetOrder, int pos, boolean leftFlag, boolean inFlag) {
		int[] subOrder;
		if (leftFlag) {
			if (inFlag) {
				subOrder = new int[pos];
				System.arraycopy(targetOrder, 0, subOrder, 0, pos);
			} else {
				subOrder = new int[pos];
				System.arraycopy(targetOrder, 1, subOrder, 0, pos);
			}
		} else {
			subOrder = new int[targetOrder.length - pos - 1];
			System.arraycopy(targetOrder, pos + 1, subOrder, 0, targetOrder.length - pos - 1);
		}
		return subOrder;

	}

}
