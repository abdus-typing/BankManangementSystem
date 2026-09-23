package bank.management.system;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.io.IOException;

public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Properties props=new Properties();
            props.load(new FileInputStream("config.properties"));
            String url=props.getProperty("db.url");
            String user=props.getProperty("db.user");
            String password=props.getProperty("db.password");

            c=DriverManager.getConnection(url,user,password);
            s= c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
