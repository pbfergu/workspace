package Questions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingQueue;

import struture.ListNode;
import struture.TreeNode;

public class Solution {

	// 268 Missing number
	/*
	 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
     * For example,
     * Given nums = [0, 1, 3] return 2.
	 */
	public int missingNumber(int[] nums) {
		
		int size = nums.length;
		boolean bitMap[] = new boolean[size+1];
		for(int i = 0;i<size;i++){
			bitMap[nums[i]] = true;
		}
		for(int i = 0;i<size+1;i++){
			if(!bitMap[i])
				return i;
		}
		return size+1;
	}
	
	/*
	 * Given a binary tree, return all root-to-leaf paths.
	 * For example, given the following binary tree:
	
   		  1
 		/   \
	   2     3
 		\
  		 5
	   All root-to-leaf paths are:
	   ["1->2->5", "1->3"]
	 */
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 =0, num2 =0;
        for(int i = 0;l1!=null;i++){
           num1 = num1 + l1.val*(int)Math.pow(10,i);
           l1 = l1.next;
        }
        for(int i = 0;l2!=null;i++){
           num2 = num2 + l2.val*(int)Math.pow(10,i);
           l2 = l2.next;
        }
        int sum = num1 + num2;
        ListNode head = new ListNode(sum%10);
        ListNode p = head;
        sum /= 10;
        while(sum>0){
            p.next = new ListNode(sum % 10);
            sum = sum/10;
            p = p.next;
        }
        return head;
    }
	
	public int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s==null)
            return 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int max = 1;
        int start = 0;
        for(int i = 0; i<s.length();i++){
            //if(map.containsKey(s.charAt(i))){
        	if( ( map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start)){
                start = map.get(s.charAt(i))+1;
            }
            Stack<Integer> stack= new Stack<Integer>();
            Queue<Integer> queue = new LinkedList<Integer>();
            List<Integer> list = new ArrayList<Integer>();
            Set<Integer> hashSet = new HashSet<Integer>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            map.put(s.charAt(i),i);
        }
        
        int[] exist = new int[256];
        for(int i =0;i<256;i++)
            exist[i] = -1;
        for(int i =0;i<s.length();i++){
            if(exist[s.charAt(i)]>=start){
                
                start = exist[s.charAt(i)]+1;
            }
            max = Math.max(max,i-start+1);   
            exist[s.charAt(i)] = i;
        }
        return max;
    }
	
	 public String addBinary(String a, String b) {
	        int lengthA = a.length();
	        int lengthB = b.length();
	        int carry = 0;
	        String result = "";
	        for(int i = 0;i<lengthA||i<lengthB;i++ ){
	            int num1 = (i< lengthA) ? (int)(a.charAt(lengthA-i-1)):0;
	            int num2 = (i< lengthB) ? (int)(b.charAt(lengthB-i-1)):0;
	            int res = (num1 + num2 + carry) % 2;
	            carry = (num1 + num2 + carry)/2;
	            result = res + result;
	        }
	        if(carry!=0)
	            result = carry + result;
	        return result;
	    }
	 
	 public boolean hasPathSum(TreeNode root, int sum) {
	        if(root == null)
	            return false;
	        if(root.val == sum && root.left==null && root.right==null)
	            return true;
	        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
	        
	    }
	 
	 public String convert(String s, int numRows) {
	        if(s==null||s.length()<3||numRows>=s.length())
	            return s;
	        StringBuilder res = new StringBuilder();
	        StringBuilder[] resList = new StringBuilder[numRows];
	        for(int i = 0;i<s.length();){
	            for(int j = 0;j<numRows;j++,i++)
	                resList[j].append(s.charAt(i));
	            for(int j = numRows-2;j>0;j--,i++)
	                resList[j].append(s.charAt(i));
	        }
	        for(StringBuilder a : resList)
	            res.append(a);
	        return res.toString();
	        
	    }
	 
	 public int myAtoi(String str) {
	        String s = str.trim();
	        if(s.isEmpty())
	            return 0;
	        int i = 0;
	        int res = 0;
	        int sign = 1;
	        while(s.charAt(i)=='+'||s.charAt(i)=='-'){
	            
	            sign = (s.charAt(i)== '-') ? -1:1;
	            i++;
	        }
	        for(;i<s.length();i++){
	            char c = s.charAt(i);
	            if(Character.isDigit(c)){
	            	int num = c - '0';
	                if(sign==1 && (Integer.MAX_VALUE - num)/10 < res)
	                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	            }
	            else if(c==' ')
	                continue;
	            else
	                break;
	        }
	        return sign*res;
	    }
	 
	 public boolean isPalindrome(ListNode head) {
	        if(head==null||head.next==null)
	            return true;
	        ListNode end = head;
	        int length = 0;
	        while(end!=null){
	            length++;
	            end = end.next;
	        }
	        ListNode next = head.next;
	        head.next = null;
	        for(int i = 0;i<length/2 - 1;i++){
	            ListNode temp = next.next;
	            next.next = head;
	            head = next;
	            next = temp;
	        }
	        if(length%2 != 0)
	            next = next.next;
	        while(next!=null){
	            if(head.val != next.val)
	                return false;
	            next = next.next;
	        }
	        return true;
	    }
	 
	 public boolean isBalanced(TreeNode root) {
	        if(root==null)
	            return true;
	        List<Integer> path = new ArrayList<Integer>();
	        int depth = 0;
	        calDepth(root,depth,path);
	        
	        Collections.sort(path);
	        if(path.get(path.size()-1) - path.get(0) >1)
	            return false;
	        return true;
	    }
	    
	    private void calDepth(TreeNode root, int depth, List<Integer> path){
	        if(root==null){
	            path.add(depth);
	            //depth = 0;
	            return;
	        }
	        depth++;
	        calDepth(root.left,depth,path);
	        calDepth(root.right,depth,path);
	    }
	    
	    public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        for(int i = 0 ;i<numRows;i++){
	            List<Integer> list = new ArrayList<Integer>();
	            for(int j = 0;j<=i;j++)
	                if(j==0||j==i)
	                    list.add(1);
	                else
	                    list.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
	           
	        }
	        return res;
	    }
	    
	   /* public String longestPalindrome(String s) {
	        int length = s.length();
	        if(length<2)
	            return s;
	        String res = "";
	        int max = 0;
	        boolean[][] dp = new boolean[length][length];
	        for(int k = 0;k<length;k++){
	            for (int i = 0;i+k<length;i++){
	                int j = i + k;
	                if(i==j)
	                    dp[i][j] = true;
	                else if(s.charAt(i) != s.charAt(j))
	                    dp[i][j] = false;
	                else if(i==(j-1)){
	                    dp[i][j] = true;
	                    if(max < 1){
	                        max = 1;
	                        res = s.substring(i,j+1);
	                    }
	                }
	                else{
	                    dp[i][j] = dp[i+1][j-1];
	                    if(dp[i][j] && i-j > max){
	                        max = i - j;
	                        res = s.substring(i,j+1);
	                    }
	                }
	            }
	        }
	        return res;
	    }*/
	    int begin = 0;
	    int max = 0;
	    public String longestPalindrome(String s) {
	        if(s.length()<2)
	            return s;
	        String res = "";
	        for(int i = 0;i<s.length()-1;i++){
	            findLogest(s,i,i);
	            findLogest(s,i,i+1);
	        }
	        res = s.substring(begin,begin+max+1);
	        return res;
	    }
	    private void findLogest(String s, int i, int j){
	            while(i>=0 && j<s.length() && (s.charAt(i) == s.charAt(j))){
	                i--;
	                j++;
	            }
	            if(j - i > max+2){
	                max = j - i;
	                begin = i;
	            }
	        }
	    public List<String> binaryTreePaths(TreeNode root) {
	        List<String> paths = new LinkedList<String>();
	        
	        if(root == null)
	            return paths;
	            
	        if (root.left == null && root.right == null){
	            paths.add(root.val+"");
	            return paths;
	        }
	        for(String left : binaryTreePaths(root.left)){
	            paths.add(root.val+"->"+left);
	        }
	           
	        for(String right : binaryTreePaths(root.right)){
	        	
	            paths.add(root.val+"->"+right);
	        }
	            
	        return paths;
	    }
	    
	    public boolean isHappy(int n) {
	        HashSet<Integer> set = new HashSet<Integer>();
	        while(n!=1){
	            int result = 0;
	            boolean flag = false;
	            while(n!=0){
	                int a = n%10;
	                n /=10;
	                result += a*a;
	                if(!set.contains(a)){
	                    set.add(a);
	                    flag = true;
	                  
	                }
	            }
	            if(!flag)
	                return false;
	            n = result;
	        }
	        return true;
	    }
	    
	    public boolean wordPattern(String pattern, String str) {
	        String[] strArray = str.split(" ");
	        if(pattern.length()!=strArray.length)
	            return false;
	        Map<Character,String> map = new HashMap<Character,String>();
	        for(int i = 0;i<pattern.length();i++){
	            char c = pattern.charAt(i);
	            if(map.containsKey(c)){
	                if(map.get(c)!=strArray[i])
	                    return false;
	            }
	            map.put(c,strArray[i]); 
	        }
	        return true;
	    }
	    
	    public boolean isValid(String s) {
	        Stack<Character> stack = new Stack<Character>();
	        for(int i =0;i<s.length();i++){
	            switch(s.charAt(i)){
	                case '(':
	                    stack.push('(');
	                    break;
	                case '{':
	                    stack.push('{');
	                    break;
	                case '[':
	                    stack.push('[');
	                    break;
	                case ')':
	                    if(stack.isEmpty()||stack.pop()!='(')
	                        return false;
	                    //break;
	                case '}':
	                    if(stack.isEmpty()||stack.pop()!='{')
	                        return false;
	                    break;
	                case ']':
	                    if(stack.isEmpty()||stack.pop()!='[')
	                        return false;
	                    break;
	            }
	        }
	        return stack.isEmpty();
	    }
	    
	    public int findMin(int[] nums) {
	        //binary search
	        int begin = 0;
	        int end = nums.length-1;
	        while(begin<end){
	            if(nums[begin]<nums[end])
	                return nums[begin];
	            int mid = begin+(end-begin)/2;
	            if(nums[mid]>nums[begin])
	                begin = mid+1;
	            else
	                end = mid;
	        }
	        return nums[begin];
	    }
}

