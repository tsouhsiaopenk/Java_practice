import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zxp.Duck;
import zxp.Duck2;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");
        // 通过bean的名称获取对象，bean 名称就是 xml 中 bean的id
        String string = (String) context.getBean("bit");
        System.out.println(string);

        //通过类型获取bean对象，如果该类型有多个对象，
        // 就会报错，只支持一个该类型的对象
        String bit2 = context.getBean(String.class);
        System.out.println(bit2);

        Duck d1 = (Duck) context.getBean("d1");
        System.out.println(d1);

        Duck2 d2 = (Duck2) context.getBean("d2");
        System.out.println(d2);
    }
}