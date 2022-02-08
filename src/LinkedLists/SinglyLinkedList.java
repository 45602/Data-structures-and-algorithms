package LinkedLists;

import java.util.HashSet;

public class SinglyLinkedList {
	
	Node head;
	
	//class that represents one node in list
	static class Node {
		
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		public String toString() { 
			return "Data: " + data;
		}
	}
	
	//adds node at the end of linked list
	public static void insertOnEnd(SinglyLinkedList list, int data) {
		
		Node newNode = new Node(data);	
		if(list.head == null) { //if list is null, new node becomes head of the list (we usually check this for every operation with linked list)
			list.head = newNode;
		}
		else { //if not, iterate to the end of list and add it there
			Node temp = list.head;
			while(temp.next != null) { 
				temp = temp.next;
			}
			temp.next = newNode;	
		}
	}
	
	//adds node at the beginning of the linked list
	public static void insertOnBeginning(SinglyLinkedList list, int data) {
		Node newNode = new Node(data);
		if(list.head == null) { 
			list.head = newNode;
		}
		else {
			newNode.next = list.head; //new node points to previous head
			list.head = newNode; //new node becomes the head

		}
	}
	
	//adds node on specific place
	public static void insertOnPlace(SinglyLinkedList list, int data, int place) {
		
		//if place < 1 || place > length of list, i add on beginning and end respectfully
		if(place <= 1) {
			insertOnBeginning(list, data);
		}
		else if(place > lengthOfLinkedList(list)) { 
			insertOnEnd(list, data);
		}
		else {
			int counter = 1; 
			Node temp = list.head;
			while (counter != place-1) { //in order to add element on n-th place, we have to find current n-1th and n-th element
				counter++;
				temp = temp.next;
			}
			Node prev = temp; //if place is 3, prev will be current 2nd element and next will be current 3rd element
			Node next = temp.next;
			Node newNode = new Node(data);
			prev.next = newNode;
			newNode.next = next;
		}
	}
	
	//finds the length of linked list
	public static int lengthOfLinkedList(SinglyLinkedList list) {
		int len = 0;
		Node temp = list.head;
		while(temp!= null) {
			temp = temp.next;
			len++;
		}
		return len;
	}
	
	//deletes element on given place
	public static void deleteOnPlace(SinglyLinkedList list, int place) { 
		//if place <=1 or >= length of list, i assumed you want to delete first and last respectfully
		if(place <= 1) { 
			list.head = list.head.next;
		}
		else if(place >= lengthOfLinkedList(list)) {
			Node temp = list.head;
			while(temp.next.next != null) { 
				temp = temp.next;
			}
			temp.next = null;
		}
		else { 
			int counter = 1;
			Node temp = list.head;
			while(counter != place-1) { 
				counter++;
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
	}
	
	//prints out whole linked list as one string
	public static void printList(SinglyLinkedList list) { 
		if(list.head == null) { 
			System.out.println("List is empty");
			return;
		}
		String lista = "[";
		Node temp = list.head;
		lista += temp.toString() + "";
		temp = temp.next;
		do {
			if(temp != null) { 
				lista += ", ";
			}
			lista += temp.toString() + "";
			temp = temp.next;
		}while(temp!=null);
		lista += "]";
		System.out.println(lista);
	}
	
	//removes all elements from linked list
	public static void clear(SinglyLinkedList list) {
		if(list.head == null) { 
			return;
		}
		list.head = null;
	}
	
	//remove duplicates 
	public static void removeDuplicates(SinglyLinkedList list) { 

		HashSet<Integer> dataSet = new HashSet<Integer>();
		if(list.head == null) {
			return;
		}
		Node temp = list.head;
		dataSet.add(temp.data);
		while(temp!=null) { 
			if(!dataSet.contains(temp.next.data)) {  
				dataSet.add(temp.next.data);
				temp = temp.next;
			}
			else {
				temp.next = temp.next.next;
				temp = temp.next;
			}
		}
	}
	
	//reverse the list
	public static void reverseList(SinglyLinkedList list) {
		Node prev = null;
		Node curr = list.head;
		Node next = null;
		while(curr!=null)  {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		list.head = prev;
	}

	public static void main(String[] args) {
		SinglyLinkedList p = new SinglyLinkedList();
		p.head = new Node(3);
		insertOnEnd(p, 6);
		insertOnEnd(p, 5);
		insertOnEnd(p, 2);
		insertOnEnd(p, 2);
		insertOnEnd(p, 3);
		insertOnBeginning(p, 6);
		insertOnPlace(p, 7, 5);
		deleteOnPlace(p, 10);
		printList(p);
		removeDuplicates(p);
		printList(p);
		reverseList(p);
		printList(p);
		clear(p);
		printList(p);
	}
}
