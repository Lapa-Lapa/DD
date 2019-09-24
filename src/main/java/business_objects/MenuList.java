package business_objects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MenuList {
    public static List<String> getExpectedMenuList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("expectedMenuList.xml");
        return (List<String>) context.getBean("expectedMenuList");
    }
}
