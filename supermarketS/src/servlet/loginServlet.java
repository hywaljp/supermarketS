package servlet;

import action.getGoods;
import action.loginUserCheck;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("uname");
        String pwd  = req.getParameter("pwd");
        if (new loginUserCheck().check(username,pwd)){

            Cookie cookie = new Cookie("username",username);
            cookie.setMaxAge(600);
            resp.addCookie(cookie);
            req.setAttribute("flag","goods");
            req.setAttribute("list",new getGoods().getArrayList());
            req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
        }

        else {
            req.setAttribute("message","账户名或者密码错误！");
            req.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);
        }
    }


}
