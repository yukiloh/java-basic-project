package FilterExercise.LoginExercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


/*一个演示了用户登陆的页面，因无法正常使用数据库池等技术，故使用最原始的jdbc调用方法*/


@WebServlet({"/login_check"})
public class ExerciseForLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("do post");

        User user = new User();
        user.setUser(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        System.out.println(user.getUser());
        System.out.println(user.getPassword());

        LoginDao loginDao = new LoginDao();
        try {
            if (loginDao.login(user) != null) {
                System.out.println("succeed!");
                req.getRequestDispatcher("/success").forward(req,resp);
            }else {
                System.out.println("failed!");
                req.getRequestDispatcher("/failed").forward(req,resp);
            }
            ;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
