package servlet;

import action.getClerk;
import action.getGoods;
import action.getSupplier;
import action.getfirm;
import connector.connector;
import javaBean.Clerk;
import javaBean.firm;
import javaBean.goods;
import javaBean.supplier;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;


public class showAllMessageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8");

        ArrayList<firm> firmarr = new ArrayList();
        ArrayList<supplier> supplierarr = new ArrayList();
        ArrayList<Clerk> clerkmarr = new ArrayList();
        ArrayList<goods> goodsarr = new ArrayList();

        System.out.println(req.getParameter("what"));
        System.out.println(req.getParameter("search"));
        if (req.getParameter("what")!=null && !"".equals(req.getParameter("what"))){
            if (req.getParameter("what").equals("firm")){
                req.setAttribute("flag","firm");
                firmarr=new getfirm().getArrayList();
                req.setAttribute("list",firmarr);
                req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
            }else if (req.getParameter("what").equals("supplier")){
                req.setAttribute("flag","supplier");
                supplierarr=new getSupplier().getArrayList();
                req.setAttribute("list",supplierarr);
                req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
            }else if (req.getParameter("what").equals("clerk")){
                req.setAttribute("flag","clerk");
                clerkmarr=new getClerk().getArrayList();
                req.setAttribute("list",clerkmarr);
                req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
            }else {
                req.setAttribute("flag","goods");
                goodsarr=new getGoods().getArrayList();
                req.setAttribute("list",goodsarr);
                req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
            }
        }
        else if (req.getParameter("search")!=null && !"".equals(req.getParameter("search"))){
            if (req.getParameter("search").equals("goods")){
                ArrayList arrayList = new ArrayList();
                goodsarr = new getGoods().getArrayList();
                String no = (String) req.getParameter("no");
                String name = (String) req.getParameter("name");
                System.out.println(no+name);

                goods newgoods = new goods();
                if (no!=null && no!="" ) newgoods.setGno(Integer.parseInt(no));
                if (name!=null&&name!="")newgoods.setGname(name);

                if (no!=null&& !no.equals("")){
                    for (goods g:goodsarr){
                        if (Integer.parseInt(no) == g.getGno()){
                            newgoods = g;
                            break;
                        }
                    }

                    if (name!=null && name!=""){
                       if (newgoods.getGname().indexOf(name)!=-1){
                           req.setAttribute("flag","goods");
                           arrayList.add(newgoods);
                           req.setAttribute("list",arrayList);
                           req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
                       } else{
                           req.setAttribute("flag","goods");
                           req.setAttribute("list",arrayList);
                           req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
                       }
                    }
                    arrayList.add(newgoods);
                    req.setAttribute("flag","goods");
                    req.setAttribute("list",arrayList);
                    req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);

                }
                else {

                    if (name!=null&&name!=""){
                        connector con =connector.getInstance();
                        con.connect();

                        try {
                            PreparedStatement ps = con.connection.prepareStatement("select * from goods where gname like ?");
                            ps.setString(1,"%"+name+"%");
                            ResultSet resultSet = ps.executeQuery();
                            while (resultSet.next()){
                                goods goods = new goods();
                                goods.setGno(resultSet.getInt(1));
                                goods.setGname(resultSet.getString(2));
                                goods.setgNUM(resultSet.getInt(5));
                                goods.setgQTY(resultSet.getInt(3));
                                goods.setgQTYWARN(resultSet.getInt(4));
                                goods.setGifsell(resultSet.getBoolean(6));
                                goods.setFno(resultSet.getInt(7));
                                goods.setSno(resultSet.getInt(8));
                                arrayList.add(goods);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    req.setAttribute("flag","goods");
                    req.setAttribute("list",arrayList);
                    req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);

                }

            }

        }

        System.out.println("111");

    }
}
