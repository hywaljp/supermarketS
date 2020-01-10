package servlet;

import action.DMLGoods;
import action.getGoods;
import action.getSupplier;
import action.getfirm;
import javaBean.goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class registerGoodsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8");
        if (req.getParameter("reGoodsOK").equals("OK")){
            ArrayList arrayList = new ArrayList();
            DMLGoods d  = new DMLGoods();
            if (!d.checked(req.getParameter("gname"))){
                goods goods = new goods();
                goods.setGname(req.getParameter("gname"));
                goods.setSno(Integer.parseInt(req.getParameter("sno")));
                goods.setFno(Integer.parseInt(req.getParameter("fno")));
                goods.setGifsell(Boolean.parseBoolean((req.getParameter("gifsell"))));
                goods.setgQTYWARN(Integer.parseInt(req.getParameter("gQTYWARN")));
                goods.setgQTY(Integer.parseInt(req.getParameter("gQTY")));
                goods.setgNUM(Integer.parseInt(req.getParameter("gnum")));
                arrayList= d.insert(goods);
                req.setAttribute("flag","goods");
                req.setAttribute("list",arrayList);
                req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
            }else {
                req.setAttribute("message","输入的名字重复请重新输入!");
                req.setAttribute("flag","reGoods");
                req.setAttribute("fno",new getfirm("fno").getArrayList());
                req.setAttribute("sno",new getSupplier("sno").getArrayList());
                req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
            }

        }else{
            req.setAttribute("flag","reGoods");
            req.setAttribute("fno",new getfirm("fno").getArrayList());
            req.setAttribute("sno",new getSupplier("sno").getArrayList());
            req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
        }
        System.out.println("chenggong");
    }
}
