package action;

import connector.connector;
import encryptionUtil.Encryption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginUserCheck  {


    public  boolean result =false;

    public boolean check(String name,String pwd){

       connector conn =  connector.getInstance();
       conn.connect();
        try {
            PreparedStatement p = conn.connection.prepareStatement("select username,pwd from login");
            ResultSet rs = p.executeQuery();
            while (rs.next()){
                try {
                    String enc = Encryption.decryptjm(rs.getString(2));
                    if (rs.getString(1).equals(name) & enc.equals(pwd))result=true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return  result;
    }


}
