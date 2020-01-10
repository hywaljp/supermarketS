package action;


import connector.connector;
import javaBean.goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class getGoods {

    public ArrayList getArrayList() {
        return arrayList;
    }

    public ArrayList arrayList = new ArrayList();

    public getGoods(){
        connector c = connector.getInstance();
        c.connect();
        try {
            PreparedStatement ps = c.connection.prepareStatement("select * from  goods");
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
        System.out.println("huoquchengong");
    }
}
