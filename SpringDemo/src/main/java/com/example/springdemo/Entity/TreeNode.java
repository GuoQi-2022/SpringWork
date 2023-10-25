package com.example.springdemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class TreeNode {
    /**
     * 权
     */
    int value;
    /**
     * 左儿子
     */
    TreeNode left;
    /**
     * 右儿子
     */
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    /**
     * 前序遍历
     */
    public void frontShow() {
        /*当前节点*/
        System.out.print(this.value + " ");
        /*左节点*/
        if (left != null) {
            left.frontShow();
        }
        /*右节点*/
        if (right != null) {
            right.frontShow();
        }
    }

    /**
     * 中序遍历
     */
    public void midShow() {
        /*左节点*/
        if (left != null) {
            left.midShow();
        }
        /*当前节点*/
        System.out.print(value + " ");
        /*右节点*/
        if (right != null) {
            right.midShow();
        }
    }

    /**
     * 后序遍历
     */
    public void afterShow() {
        /*左节点*/
        if (left != null) {
            left.afterShow();
        }
        /*右节点*/
        if (right != null) {
            right.afterShow();
        }
        /*当前节点*/
        System.out.print(value + " ");
    }

    public TreeNode frontSearch(int i) {
        TreeNode target = null;
        /*当前节点*/
        if (this.value == i) {
            return this;
        } else {
            /*左节点*/
            if (left != null) {
                target = left.frontSearch(i);
            }
            if (target != null) {
                return target;
            }
            /*右节点*/
            if (right != null) {
                target = right.frontSearch(i);
            }
        }
        return target;
    }

    /**
     * 删除一个字树
     */
    public void delete(int i) {
        TreeNode parent = this;
        if (parent.left != null && parent.left.value == i) {
            parent.left = null;
            return;
        }
        if (parent.right != null && parent.right.value == i) {
            parent.right = null;
            return;
        }
        /*递归删除左节点*/
        if (parent.left != null) {
            parent = parent.left;
            if (parent != null) {
                parent.delete(i);
            }
        }
        if (parent.right != null) {
            /*递归删除右节点*/
            parent = parent.right;
            if (parent != null) {
                parent.delete(i);
            }
        }
    }
}
