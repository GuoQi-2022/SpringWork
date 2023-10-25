package com.example.springdemo.shuju;


import com.example.springdemo.Entity.BinaryTree;
import com.example.springdemo.Entity.TreeNode;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode treeNode = TreeNode.builder().value(1).build();
        /*设置根节点*/
        binaryTree.setRoot(treeNode);
        /*设置根节点的左右节点*/
        treeNode.setLeft(new TreeNode(2));
        treeNode.setRight(new TreeNode(3));
        /*设置根节点的左节点的子节点*/
        treeNode.getLeft().setLeft(new TreeNode(4));
        treeNode.getLeft().setRight(new TreeNode(5));
        /*设置根节点的右节点的子节点*/
        treeNode.getRight().setLeft(new TreeNode(6));
        treeNode.getRight().setRight(new TreeNode(7));
        /*前序遍历*/
        binaryTree.frontShow();
        System.out.println();
        System.out.println("=========================================================================================");
        /*中序遍历*/
        binaryTree.midShow();
        System.out.println();
        System.out.println("=========================================================================================");
        /*后序遍历*/
        binaryTree.afterShow();
        /*前序查找*/
        System.out.println();
        System.out.println("=========================================================================================");
        TreeNode result = binaryTree.frontSearch(8);
        System.out.println(result);
        /*删除一个子树*/
        System.out.println("=========================================================================================");
        binaryTree.delete(7);
        binaryTree.frontShow();
    }
}
