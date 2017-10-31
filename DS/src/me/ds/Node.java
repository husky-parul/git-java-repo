package me.ds;

import java.util.*;

public class Node {
	Node next = null;
	int data = 0;

	public Node(int data) {
		this.data = data;
	}

	public static void append(Node n, int data) {
		Node head = n;
		Node tail = new Node(data);
		while (head.next != null) {
			head = head.next;
		}
		head.next = tail;
	}

	public static Node delete(Node n, int data) {
		Node head = n;
		if (n.data == data) {
			return n.next;
		} else {
			while (n != null) {
				if (n.next.data == data) {
					n.next = n.next.next;
					return head;
				}
				n = n.next;
			}
			return head;
		}
	}

	public static Node deleteDups(Node head) {
		HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();
		if (head == null) {
			return null;
		}
		Node currNode = head.next;
		Node prevNode = head;

		ht.put(head.data, 1);
		while (currNode != null) {
			if (ht.containsKey(currNode.data)) {
				prevNode.next = currNode.next;
			} else {
				ht.put(currNode.data, 1);
				prevNode = currNode;
			}
			currNode = currNode.next;
		}
		return head;
	}
	
	public static Node deleteDups2(Node head){
		Node ptr1=null;
		Node ptr2=null;
		ptr1=head;
		//pick elements one by one
		while(ptr1!=null && ptr1.next!=null){
			ptr2=ptr1;
			//compare with the rest of the elements
			while(ptr2.next!=null){
				if(ptr1.data==ptr2.next.data){
					ptr2.next=ptr2.next.next;
				}else{
					ptr2=ptr2.next;
				}
			}
			ptr1=ptr1.next;
		}
		
		return head;
	}

	public static void print(Node n) {
		while (n.next != null) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}

	public static void main(String args[]) {
		Node head = new Node(5);
		Node.append(head, 0);
		Node.append(head, 10);
		Node.append(head, 0);
		Node.append(head, 5);

		Node.print(head);
		System.out.println("---------");

		Node.print(Node.deleteDups2(head));
	}

}
