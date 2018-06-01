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
//      udi.addUser(user);

        ArrayList<User> userList = udi.findAllUsers();
//        System.out.println(userList.size());
//        for (User u : userList){
//            System.out.println(u.toString());
//        }
        User user1 = udi.findByUsername("Le");
        if (user1!=null){
            System.out.println(user1.toString());
        }else{
            System.out.println("Not found");
        }

    }
}
