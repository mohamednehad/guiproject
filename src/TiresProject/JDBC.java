/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiresProject;
import java.sql.* ;  // for standard JDBC programs
import java.math.* ; // for BigDecimal and BigInteger support
import java.util.Properties;

/**
 *
 * @author Admin
 */
public class JDBC {
    String dbms = "mysql";
    private int s;
    public  Connection getConnection() throws SQLException {
        String userName = "root";
        String password = "root";
        String serverName = "localhost";
        String portNumber = "3306";
    Connection conn = null;
    Properties connectionProps = new Properties();
    connectionProps.put("user", userName);
    connectionProps.put("password",password);

    if (this.dbms.equals("mysql")) {
        conn = DriverManager.getConnection(
                   "jdbc:" + this.dbms + "://" +
                   serverName +
                   ":" + portNumber + "/",
                   connectionProps);
    } 
    System.out.println("Connected to database");
    return conn;
}
    public int getUserCount()
    {
        
        try {
            Connection conn = getConnection();
            Statement st = conn.prepareStatement("select count(*) from test.user");
            ResultSet rs = st.executeQuery("select count(*) from test.user");
            rs.next();
            int s =  rs.getInt(1);           
            //System.out.print(s);
        } catch (Exception e) {
        }
        return s;       //s is a field !
    }
    
    public void Excute(String sql)
    {
      try {
            Connection conn = getConnection();
            Statement st = conn.prepareStatement("select count(*) from test.user");
            st.execute(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
