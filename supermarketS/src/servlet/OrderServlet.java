package servlet;


import action.getSupplier;
import action.getfirm;
import action.orderGoods;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class OrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8");

        System.out.println(req.getParameter("order"));
        System.out.println( req.getParameter("howorder"));
        req.setAttribute("flag","goods");
        req.setAttribute("list",new orderGoods(req.getParameter("order"),req.getParameter("howorder")).getArrayList());
        req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
    }
}
