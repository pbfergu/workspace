package Test;

import java.util.Stack;

import Questions.Solution;
import struture.ListNode;
import struture.TreeNode;

public class Test {
	public static void main(String[] args){
		
		Solution solution = new Solution();
		
		/*ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(9);
		ListNode p3 = new ListNode(9);
		ListNode p4 = new ListNode(9);
		ListNode p5 = new ListNode(9);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;*/
		
		/*
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(-2);
		TreeNode t3 = new TreeNode(-3);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(3);
		TreeNode t6 = new TreeNode(-2);
		TreeNode t7 = new TreeNode(-1);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t4.left = t7;
		
		/*solution.hasPathSum(t1, 2);*/
		/*TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(-2);
		t1.left = null;
		t1.right = t2;
		solution.isBalanced(t1);*/
		
		//solution.wordPattern("abba", "dog cat cat dog");
		//solution.isValid("()");
		
		int[] nums = {2,1};
		solution.findMin(nums);
	}

}
