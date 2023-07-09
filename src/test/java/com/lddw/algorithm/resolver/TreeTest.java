package com.lddw.algorithm.resolver;

import com.lddw.algorithm.resolver.zs.basics.tree.Node;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class TreeTest {


    /**
     * 先序遍历
     * @param head 头节点
     */
    @Test
    public void preOrderUnRecur(Node head){
        System.out.println("先序遍历，利用栈，pre-order: ");
        if(head!=null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value + "");
                if(head.right !=null){
                    stack.push(head.right);
                }
                if(head.left!=null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 后续遍历
     * @param head 头节点
     */
    @Test
    public void posOrderUnRecur(Node head){
        System.out.println("后续遍历: ");
        if(head!=null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while(!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if(head.left !=null){
                    s1.push(head.left);
                }
                if(head.right !=null){
                    s1.push(head.right);
                }
            }
            while(!s2.isEmpty()){
                System.out.println(s2.pop().value + " ");
            }
        }
        System.out.println();
    }


    /**
     * 中序遍历
     * @param head 头节点
     */
    @Test
    public void inOrderUnRecur(Node head){
        System.out.println("中序遍历:");
        if(head!=null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head !=null){
                if(head!=null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    head = head.right;
                }
                System.out.println(head.value + " ");
            }
        }
        System.out.println();
    }


    public static int preValue = Integer.MIN_VALUE;

    /**
     * 判读是否是二叉搜索树
     * @param head 头结点
     * @return true false
     */
    public boolean checkBST(Node head){
        if(head ==null){
            return true;
        }
        boolean isLeftBst = checkBST(head.left);
        if(!isLeftBst){
            return false;
        }
        if(head.value <= preValue){
            return false;
        }else {
            preValue = head.value;
        }
        return checkBST(head.right);
    }


}
