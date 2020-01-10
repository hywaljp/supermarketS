package action;

import connector.connector;
import javaBean.Clerk;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class getClerk {
    public ArrayList getArrayList() {
        return arrayList;
    }

    public ArrayList arrayList = new ArrayList();

    public getClerk(){
        connector c = connector.getInstance();
        c.connect();
        try {
            PreparedStatement ps = c.connection.prepareStatement("select * from  clerk");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Clerk clerk = new Clerk();
                clerk.setCkno(resultSet.getInt(1));
                clerk.setCkname(resultSet.getString(2));
                clerk.setCkage(resultSet.getInt(3));
                clerk.setRedate(resultSet.getDate(4));
                arrayList.add(clerk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
