/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiresProject;

/**
 *
 * @author Admin
 */
public class user {
    int id ; 
    String name , password , phone ;
    
    public int maxUsers() {
        JDBC jj = new JDBC ();
        int count = jj.getUserCount();
        return count;
    }
    
    public void addUser(user us)
    {
        String sql = "INSERT INTO `test`.`user` (`name`, `password`, `phone`) VALUES ('"+us.name+"', '"+us.password+"', '"+us.phone+"')";
        JDBC jd = new JDBC();
        jd.Excute(sql);
    }
}
