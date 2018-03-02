package chestnut.com.babycirle.service;

/**
 * BabyCircle
 * Created by peter
 * on 2018.02
 * 二叉树练习
 */

public class TreeNode {

    TreeNode left;
    TreeNode right;
    int value;

    //中序
    public void printInoderTree(TreeNode root) {
        //base case
        if (root == null) {
            return;
        }
        //递归调用printTree
        printInoderTree(root.left);
        System.out.println(root.value);
        printInoderTree(root.right);
    }

    //中序
    public void printPreoderTree(TreeNode root) {
        //base case
        if (root == null) {
            return;
        }
        //递归调用printTree
        System.out.println(root.value);
        printPreoderTree(root.left);
        printPreoderTree(root.right);
    }

    public TreeNode reverseBinaryTree(TreeNode root) {
        //先处理base case，当root ==null 时，什么都不需要做,返回空指针
        if (root == null) {
            return null;
        } else {
            //把左子树翻转
            TreeNode left = reverseBinaryTree(root.left);
            //把右子树翻转
            TreeNode right = reverseBinaryTree(root.right);
            //把左右子树分别赋值给root节点，但是是翻转过来的顺序
            root.left = right;
            root.right = left;
            //返回根节点
            return root;
        }
    }

    public TreeNode flatten(TreeNode root) {
        //base case
        if (root == null) {
            return null;
        } else {
            //用递归的思想，把左右先铺平
            TreeNode left = flatten(root.left);
            TreeNode right = flatten(root.right);
            //把左指针和右指针先指向空。
            root.left = null;
            root.right = null;
            //假如左子树生成的链表为空，那么忽略它，把右子树生成的链表指向根节点的右指针
            if (left == null) {
                root.right = right;
                return root;
            }
            //如果左子树生成链表不为空，那么用while循环获取最后一个节点，并且它的右指针要指向右子树生成的链表的头节点
            root.right = left;
            TreeNode lastLeft = left;
            while (lastLeft != null && lastLeft.right != null) {
                lastLeft = lastLeft.right;
            }
            lastLeft.right = right;
            return root;
        }
    }
}
