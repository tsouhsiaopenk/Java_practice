package Java5_20;

public class ThreadState {
    public static void main(String[] args) {
        for(Thread.State state:Thread.State.values()){
            System.out.println(state);
        }
    }
}
