package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connector  {

    private  String username = "root";
    private  String pwd="123456";
    private String url="jdbc:mysql://localhost:3306/supermarketshoppingsystem?useSSL=false&serverTimezone=UTC";
    public  Connection  connection = null;
    public static connector connector =null ;

    private  connector(){
    }

    public static connector getInstance(){

            if (connector==null)
            {
                connector = new connector();
            }

        return  connector;
    }

    public  void  connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =  DriverManager.getConnection(url,username,pwd);
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
