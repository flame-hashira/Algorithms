import java.util.*;
class node {
	 char ch;
	 int item;
	 node left;
	 node right;
 }
class ImplementComparator implements Comparator<node> {

	 public int compare(node a, node b) {
	 	return a.item - b.item;
	 }

 }

class Huffman {
	 public static void main(String[] args) {
		 Scanner scan= new Scanner(System.in);
		 System.out.println("Type the number of characters: ");
		 int n = scan.nextInt();
		 char[]array= new char[n];
		 int []frequency = new int[n];
		 System.out.println("Type character");
		 for(int i=0;i<n;i++)
		 {
		 	array[i]= scan.next().charAt(0);
		 }
		 System.out.println("Type frequency for the character");
		 for(int i=0;i<n;i++)
		 {
		 	frequency[i]=scan.nextInt();
		 }
		 PriorityQueue<node> q = new PriorityQueue<node>(n, new ImplementComparator());
		 for (int i = 0; i < n; i++) {
			 node hn = new node();
			 hn.ch = array[i];
			 hn.item = frequency[i];
			 hn.left = null;
			 hn.right = null;
			 q.add(hn);
		 }
		 node root = null;
		 while (q.size() > 1) {
			 node x = q.peek();
			 q.poll();
			 node y = q.peek();
			 q.poll();
			 node f = new node();
			 f.item = x.item + y.item;
			 f.ch = '-';
			 f.left = x;
			 f.right = y;
			 root = f;
			 q.add(f);
		 }
		 System.out.println(" Huffman code ");
		 printing(root, "");
	 }
	 public static void printing(node root, String strings) {
		 if (root.left == null && root.right == null && Character.isLetter(root.ch)) {
			 System.out.println(root.ch + " | " + strings);
			 return;
		 }
		 printing(root.left, strings + "0");
		 printing(root.right, strings + "1");
	 }
 }