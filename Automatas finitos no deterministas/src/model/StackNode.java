package model;

public class StackNode {

    public char data;
    public StackNode next;

    public StackNode(char data){
        this.data = data;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "data = " + data + ", ==> " + next;
    }   
}
