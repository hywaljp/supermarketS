package servlet;

import action.DMLGoods;
import action.getGoods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class DeleteUpdateGoodsServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8");

        if (req.getParameter("UDC").equals("U")){
           boolean flag =  new DMLGoods().updateGoods(Integer.parseInt(req.getParameter("changeno")),req.getParameter("changewhat"),req.getParameter("changevalue"));
           if (flag)req.setAttribute("message","更改成功！");
           else req.setAttribute("message","更改失败！");
        }else if (req.getParameter("UDC").equals("D")){
            boolean flag = new DMLGoods().deleteGoods(Integer.parseInt(req.getParameter("udno")));
            if (flag) req.setAttribute("message","删除成功！");
           else req.setAttribute("message","删除失败！");
        }
            req.setAttribute("flag","goods");
            req.setAttribute("ud","ud");
            ArrayList goodsarr=new getGoods().getArrayList();
            req.setAttribute("list",goodsarr);
            req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
    }
}
