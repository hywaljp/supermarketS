package action;

import connector.connector;
import javaBean.goods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class orderGoods  {

    public LinkedList<goods> getArrayList() {
        return arrayList;
    }

    public void setArrayList(LinkedList<goods> arrayList) {
        this.arrayList = arrayList;
    }

    private LinkedList<goods> arrayList = new LinkedList<>();

    public orderGoods(String which, String type){
        connector con = connector.getInstance();
        con.connect();
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        try {
           if (type.equals("desc")){
               ps= con.connection.prepareStatement("select * from goods order by "+which+ " desc ");
           }
           else {
               ps = con.connection.prepareStatement("select * from goods order by "+which+ " asc ");
           }
             resultSet= ps.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
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
        }finally {
            try {
                ps.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
