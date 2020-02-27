package Java1_19;

public class TestLinkedlist {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.addIndex(0,8);
        System.out.println(linkedList.contains(2));
        linkedList.remove(2);
        //linkedList.
        linkedList.display();
    }
}
