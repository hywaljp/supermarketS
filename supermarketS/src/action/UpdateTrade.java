package action;

import connector.connector;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class UpdateTrade  {

    public  void update(int summoney, int ckno,String date){
        connector c  = connector.getInstance();
        c.connect();
        try {
            PreparedStatement ps = c.connection.prepareStatement("insert into trade values (default ,?,?,?)");
            ps.setInt(1,summoney);
            ps.setInt(2,ckno);
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(date));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
