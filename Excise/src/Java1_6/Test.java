package Java1_6;

public class Test {
    public static void testAdd(){
        SeqList seqList = new SeqList();
        seqList.add(0,1);
        seqList.add(0,2);
        seqList.add(0,3);
        seqList.display();
    }
    public static void testContains(){
        SeqList seqList = new SeqList();
        seqList.add(0,1);
        seqList.add(0,2);
        seqList.add(0,3);
        seqList.add(0,4);
        System.out.println(seqList.contains(2));
    }
    public static void testSearch(){
        SeqList seqList = new SeqList();
        seqList.add(0,1);
        seqList.add(0,2);
        seqList.add(0,3);
        seqList.add(0,4);
        seqList.display();
        System.out.println(seqList.search(2));
    }
    public static void testRemove(){
        SeqList seqList= new SeqList();
        seqList.add(0,1);
        seqList.add(0,2);
        seqList.add(0,3);
        seqList.add(0,4);
        seqList.remove(2);
        seqList.display();
    }
    public static void testClear(){
        SeqList seqList= new SeqList();
        seqList.add(0,1);
        seqList.add(0,2);
        seqList.add(0,3);
        seqList.add(0,4);
        seqList.display();
        seqList.clear();
        seqList.display();
    }
    public static void main(String[] args) {
        // testAdd();
        // testContains();
        // testSearch();
        // testRemove();
        testClear();
    }

}
