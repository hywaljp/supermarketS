package action;

import connector.connector;
import javaBean.firm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class getfirm {
    public ArrayList getArrayList() {
        return arrayList;
    }

    public ArrayList arrayList = new ArrayList();

    public getfirm(){
        connector c = connector.getInstance();
        c.connect();
        try {
            PreparedStatement ps = c.connection.prepareStatement("select * from  firm");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                firm firm = new firm();
                firm.setFno(resultSet.getInt(1));
                firm.setFname(resultSet.getString(2));
                firm.setFaddress(resultSet.getString(3));
                firm.setfTN(resultSet.getString(4));
                arrayList.add(firm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("huoquchengong");
    }

    public  getfirm(String what){
        connector c = connector.getInstance();
        c.connect();
        try {
            PreparedStatement ps = c.connection.prepareStatement("select "+what+" from  firm");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                arrayList.add(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(arrayList);
        System.out.println("huoquchengong");
    }
}
