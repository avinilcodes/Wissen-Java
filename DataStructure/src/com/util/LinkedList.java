package com.util;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {
	private Node head = null;

	public void add(E e) {
		Node newNode = new Node(e);
		if (head == null) {
			head = newNode;
		} else {
			Node last = head;
			while (last.getNext() != null) {
				last = last.getNext();
			}
			last.setNext(newNode);
		}

	}
	public void set(int idx, E e) {
		Node newNode = new Node(e);
		if(idx == 0) {
			newNode.setNext(head.getNext());
		}
		else {
			Node temp = head;
			while(idx>1) {
				temp = temp.getNext();
				idx-=1;
			}
			Node te1 = temp.getNext().getNext();
			newNode.setNext(te1);
			temp.setNext(newNode);
			}
	}
	public void add(int idx, E e) {
		Node newNode = new Node(e);
		if (idx == 0) {
			newNode.setNext(head);
			head = newNode;
		} else {
			Node node = head;
			while (idx != 1) {
				try {
					node = node.getNext();
				} catch (IndexOutOfBoundsException f) {
					System.out.println(f.getMessage());
				}
				idx -= 1;
			}
			Node nextNode = node.getNext();
			node.setNext(newNode);
			newNode.setNext(nextNode);
		}
	}

	public E get(int idx) {
		if (idx == 0) {
			return head.getData();
		} else {
			Node node = head;
			while (idx != 0) {
				try {
					node = node.getNext();
				} catch (IndexOutOfBoundsException f) {
					System.out.println(f.getMessage());
				}
				idx -= 1;
			}
			return node.getData();
		}
	}

	public void reverse() {
		Node prev = null;
		Node curr = head;
		Node temp = head.getNext();
		while (curr.getNext() != null) {
			curr.setNext(prev);
			prev = curr;
			curr = temp;
			temp = temp.getNext();
		}
		curr.setNext(prev);
		head = curr;
	}

	public int length() {
		Node last = head;
		if (head == null)
			return 0;
		int i = 1;
		while (last.getNext() != null) {
			i += 1;
			last = last.getNext();
		}
		return i;
	}

	public void remove(int idx) {
		int i = length();
		if(idx>=i) {
			System.out.println("ArrayIndexOutOfBoundsException");
		}
		else if(idx==0) {
			head = head.getNext(); 
		}
		else {
			Node temp=head;
			while(idx>1) {
				temp=temp.getNext();
				idx-=1;
			}
			Node temp1 = temp.getNext().getNext();
			Node temp2 = temp.getNext();
			temp2.setNext(null);
			temp.setNext(temp1);
		}

	}

	public void remove(E e) {
		Node prev = head;
		Node curr = head;
		Node neNode = new Node(e);
		while(curr.getData()==neNode.getData()){
			prev = curr;
			curr = curr.getNext();
		}
		prev = curr.getNext();
		curr.setNext(null);
	}

	
	
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			Node temp = head;

			@Override
			public boolean hasNext() {
				if (temp != null)
					return true;
				else
					return false;
			}

			@Override
			public E next() {
				E e = temp.getData();
				temp = temp.getNext();
				return e;
			}
		};
	}

	private class Node {
		private E data;
		private Node next;

		public Node(E data) {
			super();
			this.data = data;
		}

		public Node(E data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		public void setData(E data) {
			this.data = data;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public E getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}
	}

}
