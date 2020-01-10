package action;

import connector.connector;
import javaBean.goods;
import javafx.scene.chart.BubbleChart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DMLGoods  {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public DMLGoods() {
    }

    public ArrayList insert(goods good){

        connector con = connector.getInstance();
        con.connect();
        try {
            PreparedStatement ps= con.connection.prepareStatement("insert  into goods values(default,?,?,?,?,?,?,?)");
            ps.setString(1,good.getGname());
            ps.setInt(2,good.getgQTY());
            ps.setInt(3,good.getgQTYWARN());
            ps.setInt(4,good.getgNUM());
            ps.setBoolean(5,good.isGifsell());
            ps.setInt(6,good.getFno());
            ps.setInt(7,good.getSno());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new getGoods().getArrayList();
    }

    public boolean checked(String name){
        boolean result = false;
        connector con = connector.getInstance();
        con.connect();
        try {
            PreparedStatement ps= con.connection.prepareStatement("select gno from goods where gname = ? ");
            ps.setString(1,name);
            ResultSet rs  = ps.executeQuery();

            if ( !rs.next()) return false;
            else return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean deleteGoods(int gno){
        boolean result = false;
        connector con = connector.getInstance();
        con.connect();
        try {
            PreparedStatement ps= con.connection.prepareStatement("delete from goods where gno = "+gno);
            if (ps.executeUpdate()!=0){
                result =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }

    public boolean  updateGoods(int no,String which,String value){
        boolean result =false;
        connector con = connector.getInstance();
        con.connect();
        PreparedStatement ps=null;
        try {
            if (which.equals("gifsell") && value.equals("false")){
                ps= con.connection.prepareStatement("update goods set "+which+" = false where gno ="+no);
            }else if (which.equals("gifsell") && value.equals("true")){
                ps= con.connection.prepareStatement("update goods set "+which+" = true where gno ="+no);
            }else {
                ps= con.connection.prepareStatement("update goods set "+which+" = '"+value+"' where gno ="+no);
            }
            if (ps.executeUpdate()!=0) result=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean checked(String gno, String gnum){
        boolean result = false;
        connector con = connector.getInstance();
        con.connect();
        try {
            PreparedStatement ps= con.connection.prepareStatement("select gname from goods where gno = ?  and gQTY < ?");
            ps.setInt(1,Integer.parseInt(gno));
            ps.setInt(2,Integer.parseInt(gnum));
            ResultSet rs  = ps.executeQuery();
            if ( !rs.next()){
                return false;
            }
            else {
                name = rs.getString(1);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getNameAndPrice(String gno){
        connector con = connector.getInstance();
        con.connect();
        try {
            PreparedStatement ps= con.connection.prepareStatement("select gname,gnum from goods where gno = ?");
            ps.setInt(1,Integer.parseInt(gno));
            ResultSet rs  = ps.executeQuery();
            rs.next();
            return  rs.getString(1)+","+rs.getInt(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void update(String gname,int num ){
        connector con = connector.getInstance();
        con.connect();
        PreparedStatement ps=null;
        try {
            ps= con.connection.prepareStatement("update goods set gQTY = gQTY-? where gname = ?");
            ps.setInt(1,num);
            ps.setString(2,gname);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
