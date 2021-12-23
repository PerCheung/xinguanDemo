package ui;

import domain.User;
import service.Impl.UserServerImpl;
import service.UserServer;

import java.util.Scanner;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 19:26
 */
public class UserUI {
    private UserServer userServer = new UserServerImpl();
    private User user = new User();

    //创建扫描器
    private Scanner sc = new Scanner(System.in);

    /**
     * 开始
     */
    public void start() {
        login();
    }

    /**
     * 登录
     */
    private void login() {
        System.out.println("欢迎使用本疫情管理系统，您是否有账号，如果有就输入1继续登录，没有就输入0我们进入注册页面");
        String flag = sc.nextLine();
        if (flag.equals("1")) {
            System.out.println("您已进入登录界面");
            System.out.println("请输入账号：");
            String username = sc.nextLine().trim();
            System.out.println("请输入密码：");
            String password = sc.nextLine().trim();
            user.setUsername(username);
            user.setPassword(password);
            Integer i = userServer.findUserByPassword(user);
            switch (i) {
                case 0:
                    System.out.println("很抱歉，这个用户名尚未注册");
                    login();
                    break;
                case 1:
                    System.out.println("登陆成功");
                    //进入选项菜单
                    choose();
                    break;
                case 2:
                    System.out.println("密码错误，请检查后重新输入");
                    login();
            }
        } else if (flag.equals("0")) {
            reg();
        } else {
            System.out.println("您输入了错误的字符，我们再来一遍");
            login();
        }
    }

    /**
     * 注册
     */
    private void reg() {
        System.out.println("欢迎你注册疫情管理系统");
        System.out.println("请输入账号：");
        String username = sc.nextLine().trim();
        System.out.println("请输入密码：");
        String password = sc.nextLine().trim();
        System.out.println("请再次输入密码：");
        String password2 = sc.nextLine().trim();
        //判断两次输入密码是否相同
        if (password.equals(password2)) {
            user.setUsername(username);
            user.setPassword(password);
            userServer.reg(user);
            System.out.println("现在为您跳转到我们的系统");
            login();
        } else {
            System.out.println("两次输入密码不一致，请重新注册");
            reg();
        }
    }

    /**
     * 菜单
     */
    public void choose() {
        System.out.println("目前本系统可以处理如下操作：");
        System.out.println("1、登记捐款者的捐赠信息，这些物资与此同时也会进入我们的物资库。");
        System.out.println("2、分发我们的物资，把他们发放给需要的人。");
        System.out.println("请输入对应编号系统即进入对应操作：");
        String i = sc.nextLine();
        if (i.equals("1")) {
            new InStockUI().inStock();
        } else if (i.equals("2")) {
            new OutStockUI().outStock();
        } else {
            System.out.println("您输入了错误的字符，疫情不容马虎，作为管理员，我们相信你的能力，请重新输入");
            choose();
        }
    }
}
