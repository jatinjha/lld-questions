package com.jatin.mulitlevelcache;

public class DoublyLinkedList<V> {
    private DLLNode<V> tail;
    private DLLNode<V> head;
    public DoublyLinkedList(){
        tail = new DLLNode<>(null);
        head = new DLLNode<>(null);
        tail.prev = head;
        head.next = tail;
    }

    public void addNode(DLLNode dllNode){
        dllNode.next = head.next;
        dllNode.prev = head;
        head.next.prev = dllNode;
        head.next = dllNode;
    }

    public void removeNode(DLLNode dllNode){
        dllNode.next.prev = dllNode.prev;
        dllNode.prev.next = dllNode.next;
    }

    public DLLNode<V> getTail() {
        return tail;
    }

    public DLLNode<V> getHead() {
        return head;
    }
}
