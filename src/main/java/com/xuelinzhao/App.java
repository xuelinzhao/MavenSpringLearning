package com.xuelinzhao;

import com.xuelinzhao.dao.UserDAOImp;
import com.xuelinzhao.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        UserDAOImp udi = (UserDAOImp) context.getBean("userDaoImp");
        User user = User.createUser("Ze","123",100.0);
        udi.addUser(user);

        ArrayList<User> userList = udi.findAllUsers();
        for (User user in userList){
            System.out.println(user.toString());
        }
    }
}
