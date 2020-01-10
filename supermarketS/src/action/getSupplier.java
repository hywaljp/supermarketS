package action;

import connector.connector;
import javaBean.supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class getSupplier {
    public ArrayList getArrayList() {
        return arrayList;
    }

    public ArrayList arrayList = new ArrayList();

    public getSupplier(){
        connector c = connector.getInstance();
        c.connect();
        try {
            PreparedStatement ps = c.connection.prepareStatement("select * from supplier ");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                supplier supplier = new supplier();
                supplier.setSno(resultSet.getInt(1));
                supplier.setSname(resultSet.getString(2));
                supplier.setSaddress(resultSet.getString(3));
                supplier.setSTN(resultSet.getString(4));
                arrayList.add(supplier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("huoquchengong");
    }
    public getSupplier(String what){
        connector c = connector.getInstance();
        c.connect();
        try {
            PreparedStatement ps = c.connection.prepareStatement("select "+what+" from supplier ");
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
