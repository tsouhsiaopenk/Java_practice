package Java3_16;

public class solution {
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String args[]) {
//        solution ex = new solution();
//        ex.change(ex.str, ex.ch);
//        System.out.print(ex.str + " and ");
//        System.out.print(ex.ch);

//        System.out.println(isAdmin("Admin"));
        String s1="abc"+"def";//1
        String s2=new String(s1);//2
        if(s1.equals(s2))//3    true
            System.out.println(".equals succeeded");//4
        if(s1==s2)//5
            System.out.println("==succeeded");//6
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }

    public static boolean isAdmin(String userId){
        return userId.toLowerCase().equals("admin");
    }
}
