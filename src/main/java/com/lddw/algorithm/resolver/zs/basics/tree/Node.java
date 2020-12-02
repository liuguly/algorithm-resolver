package com.lddw.algorithm.resolver.zs.basics.tree;

/**
 * <p>描述 TODO</p>
 * @date 2020/12/2 14:21
 * @author LiuXin
 * @since 1.0
 **/
public class Node {

	public int value;
	public Node left;

	public Node right;
	public Node parent;

	public Node(int data) {
		this.value = data;
	}

	public static Node getSuccessorNode(Node node){
		if(node == null){
			return node;
		}
		if(node.right !=null){
			return getLeftMost(node.right);
		}else {
			Node parent = node.parent;
			while(parent!=null && parent.left !=node){
				node = parent;
				parent= node.parent;
			}
			return parent;
		}
	}

	public static Node getLeftMost(Node node){
		if(node == null){
			return node;
		}
		while (node.left!=null){
			node = node.left;
		}
		return node;
	}



}
