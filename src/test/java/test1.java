import com.bjpowernode.dao.UserDao;
import com.bjpowernode.domain.User;
import com.bjpowernode.service.UserService;
import com.bjpowernode.service.impl.UserServiceImpl;
import com.bjpowernode.util.ServiceFactory;
import com.bjpowernode.util.SqlSessionUtil;

public class test1 {
    public static void main(String[] args) {
        //通过工厂类获取代理对象，并将需要代理的对象放入代理框架中
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        //User u = us.select(1);
//        User use = new User();
//        use.setUserid(1);
//        use.setEmail("hnlghwl@163.com");
//        us.update(use);
       // System.out.println(u);
        User u = us.select1("o");
        System.out.println(u);
    }
}
