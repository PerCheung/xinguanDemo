import ui.UserUI;

/**
 * 本系统基于纯java基础开发，使用jdbc操作mysql数据库，在控制台展现了登陆注册，物资捐赠，物资发放功能。
 *
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 18:06
 */
public class Start {
    //本项目由此开始
    public static void main(String[] args) {
        new UserUI().start();
    }
}
