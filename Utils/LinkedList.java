/*
*/

import java.io.*;
import java.util.*;
import ../Exception/Exception.java;

class Node{
  int data;
  Node next;

  Node(int data){
    this.data = data;
    this.next = null;
  }
}

class LinkedList{
  Node head;
  Node tail;
  int size;

  LinkedList(){
    this.head=null;
    this.tail=null;
    this.size=0;
  }

  public void addToHead(int data){
    Node toAdd = new Node(data);
    if(head == null){
      head = toAdd;
      tail = toAdd;
    }
    else{
      toAdd.next = head;
      head = toAdd;
    }
    size+=1;
  }

  public void addToTail(int data){
    Node toAdd = new Node(data);
    if(tail == null){
      head = toAdd;
      tail = toAdd;
    }
    else{
      tail.next=toAdd;
      tail=toAdd;
    }
    size+=1;
  }

  public int removeFromFront() throws EmptyListException{
    if(size == 0){
      throw new EmptyListException("Cannot remove element since list is empty");
    }
    int data = head.data;
    head = head.next;
    if(head==null) tail=null;
    size-=1;
    return data;
  }

  public int removeFromTail() throws EmptyListException{
    if(size == 0){
      throw new EmptyListException("Cannot remove element since list is empty");
    }
    int data = tail.data;
    head = head.next;
    if(head==null) tail=null;
    size-=1;
    return data;
  }
}
