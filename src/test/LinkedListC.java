package test;

public class LinkedListC {
    int value;
    LinkedListC next;

    LinkedListC(){}

    LinkedListC(int v){
        this.value = v;
    }

    LinkedListC(int v, LinkedListC next){
        this.value=v;
        this.next = next;
    }

    public void printLinkedList(LinkedListC node){
        
        while(node != null){
            System.out.print(node.value + "  ");
            node = node.next;
        }
    }


    public static void main(String[] args){
    // l1 = [2,4,3], l2 = [5,6,4]

        LinkedListC n1 = new LinkedListC(2);
        LinkedListC n2 = new LinkedListC(4, n1);
        LinkedListC n3 = new LinkedListC(3, n2);

        
        n3.printLinkedList(n3);

    }
}
