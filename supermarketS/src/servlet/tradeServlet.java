package servlet;

import action.DMLGoods;
import action.UpdateTrade;
import action.getGoods;
import javaBean.trade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class tradeServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8");
        DMLGoods dmlGoods = new DMLGoods();
        String ckb = "";
        String[] re = null;
        if (req.getParameter("tradeOK").equals("OK")){
            ckb = req.getParameter("str");
            re = ckb.split(",");
            String failure = "";
            int middle = re.length/2;
            int j = middle;
            for (int i =0;i<middle;i++,j++ ){
                if (dmlGoods.checked(re[i],re[j])){
                    failure += dmlGoods.getName()+",";
                }
            }
            if (failure !=""){
                req.setAttribute("message",failure+"这些商品的数量不足!");
            }else {
                int k = middle;
                int sumprice = 0;
                ArrayList list = new ArrayList();
                for (int i =0;i<middle;k++,i++){
                    trade t = new trade();
                    String[] r = dmlGoods.getNameAndPrice(re[i]).split(",");
                    t.setName(r[0]);
                    t.setPrice(Integer.parseInt(r[1]));
                    t.setNum(Integer.parseInt(re[k]));
                    sumprice += Integer.parseInt(r[1])*Integer.parseInt(re[k]);
                    list.add(t);
                    trade.list.add(t);
                }
                Date dd=new Date();
                SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                req.setAttribute("date",sim.format(dd));
                req.setAttribute("list",list);
                req.setAttribute("sumprice",sumprice);
                req.setAttribute("whore",1);

                trade.ckno=1;
                trade.date =sim.format(dd);
                trade.sumprice = sumprice;

                req.getRequestDispatcher("/jsp/confirmReceipt.jsp").forward(req,resp);
            }
        }else if (req.getParameter("tradeOK").equals("succeed")){
            UpdateTrade u = new UpdateTrade();
            u.update(trade.sumprice,trade.ckno,trade.date);
            for (int i=0;i<trade.list.size();i++){
                dmlGoods.update(trade.list.get(i).getName(),trade.list.get(i).getNum());
            }
            trade.list.clear();
        }else if (req.getParameter("tradeOK").equals("failure")){
            req.setAttribute("message","交易失败！");
        }
            req.setAttribute("select","select");
            req.setAttribute("flag","goods");
            ArrayList goodsarr=new getGoods().getArrayList();
            req.setAttribute("list",goodsarr);
            req.getRequestDispatcher("/jsp/main.jsp").forward(req,resp);

    }
}
