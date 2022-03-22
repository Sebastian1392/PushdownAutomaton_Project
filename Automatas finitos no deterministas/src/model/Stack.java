package model;

public class Stack {
    
    private StackNode stack;

    public void pushSimbol(char simbol){
        if(stack == null){
            stack = new StackNode(simbol);
        }else{
            StackNode newNode = new StackNode(simbol);
            newNode.setNext(stack);
            stack = newNode;
        }
    }

    public void popSimbol(char simbol){
        if(stack.getData() == simbol){
            stack = stack.getNext();
        }
    }

    public void printStack(){
        print(stack);
    }

    private void print(StackNode node){
        System.out.println(node);
        if(node.getNext() != null){
            print(node.getNext());
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.pushSimbol('Z');
        stack.pushSimbol('A');
        stack.pushSimbol('A');
        stack.pushSimbol('A');
        stack.printStack();
        stack.popSimbol('A');
        stack.printStack();
    }
}
