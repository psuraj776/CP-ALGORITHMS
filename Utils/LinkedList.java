/*
*/

import java.io.*;
import java.util.*;

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

  public void add(int data){
    Node toAdd = new Node(data);
    if(head == null){
      head = toAdd;
      tail = toAdd;
    }
    else{
      tail.next=toAdd;
      tail=toAdd;
    }
    size+=1;
  }

  public int removeFromFront(){
    try{
      if(
    }
  }
}
