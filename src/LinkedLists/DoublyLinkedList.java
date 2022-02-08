package LinkedLists;

import LinkedLists.SinglyLinkedList.Node;

public class DoublyLinkedList {
	
	Node head;
	
	static class Node { 
		
		int data;
		Node prev;
		Node next;
		
		public Node(int data) { 
			this.data = data;
			this.prev = null;
			this.next = null;
		}
		
		public String toString() {
			String s = "Data: " + data + ", ";
			if(prev == null) { 
				s += "prev: null, ";
			}
			else {
				s+= "prev: " + prev.data + ", ";
			}
			if(next == null) { 
				s += "next: null ";
			}
			else { 
				s += "next: " + next.data;
			}
			return s;
		}
	}
	
	public static void printList(DoublyLinkedList list) { 
		if(list.head == null) { 
			System.out.println("List is empty");
			return;
		}
		String lista = "[";
		Node temp = list.head;
		lista += temp.toString() + " | ";
		temp = temp.next;
		do {
			if(temp.next != null ) { 
				lista += temp.toString() + " | ";
				temp = temp.next;
			}
			else {
				lista += temp.toString();
				break;
			}
		}while(temp!=null);
		lista += "]";
		System.out.println(lista);
	}
	public static void printListSmarter(DoublyLinkedList list) { 
		if(list.head == null) { 
			System.out.println("List is empty");
			return;
		}
		String lista = "[";
		Node temp = list.head;
		lista += temp.toString() + " | ";
		temp = temp.next;
		do {
			if(temp.next != null ) { 
				lista += temp.toString() + " | ";
				temp = temp.next;
			}
			else {
				lista += temp.toString();
				break;
			}
		}while(temp!=null);
		lista += ">>BACK<< ";
		lista += temp.toString() + " | ";
		temp = temp.prev;
		do {
			if(temp.prev != null) { 
				lista += temp.toString() + " | ";
				temp = temp.prev;
			}
			else {
				lista += temp.toString();
				break;
			}
		}while(temp!=null);
		lista += "]";
		System.out.println(lista);
	}
	
	public static void insertOnEnd(DoublyLinkedList list, int data) {
		Node newNode = new Node(data);
		if(list.head == null) {
			list.head = newNode;
			return;
		}
		Node temp = list.head;
		while(temp.next!=null) { 
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.prev = temp;
	}
	public static void insertOnBeginning(DoublyLinkedList list, int data) {
		Node newNode = new Node(data);
		if(list.head == null) { 
			list.head = newNode;
			return;
		}
		Node temp = list.head;
		list.head = newNode; 
		newNode.next = temp;
		newNode.prev = null;
		temp.prev = newNode;
	}
	public static void insertOnPlace(DoublyLinkedList list, int data, int place) {
		
		if(place <= 1) {
			insertOnBeginning(list, data);
		}
		else if(place > lengthOfLinkedList(list)) { 
			insertOnEnd(list, data);
		}
		else {
			int counter = 1; 
			Node temp = list.head;
			while (counter != place-1) {
				counter++;
				temp = temp.next;
			}
			Node prev = temp;
			Node next = temp.next;
			Node newNode = new Node(data);
			prev.next = newNode;
			newNode.prev = prev;
			newNode.next = next;
			next.prev = newNode;
		}
	}
	public static int lengthOfLinkedList(DoublyLinkedList list) {
		int len = 0;
		Node temp = list.head;
		while(temp!= null) {
			temp = temp.next;
			len++;
		}
		return len;
	}
	public static void main(String[] args) { 
		DoublyLinkedList dll = new DoublyLinkedList();
		Node p = new Node(3);
		dll.head = p;
		insertOnEnd(dll, 4);
		insertOnBeginning(dll,2);
		printList(dll);
		printListSmarter(dll);
	}
}
