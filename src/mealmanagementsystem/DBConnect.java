
package mealmanagementsystem;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBConnect {
    private Connection con;
    PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    public DBConnect(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    //step 1:get connection to db
    
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/meal","root","");
    //step 2:create statement
    st=con.createStatement();
    }
    catch(Exception e)
    {
        System.out.println("error:"+e);
        e.printStackTrace();
    }
    }
    
   public void register(String fn,String ln,String un,String pass,String phone,String email)
   {
        try {
            String query="insert into user(user,pass,phone,email,first_name,last_name)values('"+
                    un+"','"+pass+"','"+phone+"','"+email+"','"+fn+"','"+ln+"');";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"registation completed");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public ResultSet login(String un,String pass)
   {
        try {
            PreparedStatement ps;
            ps=con.prepareStatement("select user,pass from user where user=? and pass=?");
            ps.setString(1, un);
            ps.setString(2,pass);
            rs=ps.executeQuery();
            //System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
       
   }
    public void updatepass(String user,String newpass)
   {
        try {
            String query="UPDATE user SET pass='"+newpass+"' where user='"+user+"';";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"PASSWORD CHANGE SUCCESSFULL");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void insertmem(String id,String name,String phone,String user,String date)
   {
        try {
            String query="insert into member(id,name,phone,user,date) values ('"+id+"','"+name+"','"+phone+"','"+user+"','"+date+"');";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Member info inserted into Database");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void updatemem(String id,String name,String phone,String user,String date)
   {
        try {
            String query="update member set id='"+id+"',name='"+name+"',phone='"+phone+"',user='"+
                    user+"',date='"+date+"'"+"where id='"+id+"'and user='"+user+"';";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Member info updated");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void insertmeal(String date,String id,int meal,String user)
   {
        try {
            String query="insert into meal(date,id,meal,user) values ('"+date+"','"+id+
                    "','"+meal+"','"+user+"');";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Member info inserted into Database");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void updatemeal(String date,String id,int meal,String user)
   {
        try {
            String query="update meal set date='"+date+"',id='"+id+"',meal='"+meal+"',user='"+user+"'where id='"+id+"'and user='"+user+"'and date='"+date+"';";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Meal info updated");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void insertexpense(String date,double expense,String user)
   {
        try {
            String query="insert into expense(date,expense,user) values('"+date+"','"+
                    expense+"','"+user+"');";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"expense info inserted into Database");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void updateexpense(String date,double expense,String user)
   {
        try {
            String query="update expense set date='"+date+"',expense='"+expense+"',user='"+user+"'where user='"+user+"';";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"expense info updated");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void insertdebit(String date,String id,double tk,String user)
   {
       String query="insert into debit(date,id,taka,user) values ('"+date+
               "','"+id+"','"+tk+"','"+user+"');";
        try {
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Debit info inserted into Database");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
   public void updatedebit(String date,String id,double tk,String user)
   {
        try {
            String query="update debit set date='"+date+"',id='"+id+"',taka='"+tk+
                    "',user='"+user+"'where id='"+id+"'and user='"+user+"';";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Debit info updated");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void deletemem(String id,String user)
   {
        try {
            String query="delete from member where id='"+id+"'and user='"+user+"';";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Member deleted");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public ResultSet getmem(String user)
   {
        try {
            String query="select id,name,phone,date from member where user='"+user+"';";
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
   }
   public ResultSet getmeal(String user)
   {
        try {
            String query="select date,id,meal from meal where user='"+user+"';";
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
   }
   public ResultSet getmealdate(String user,String date)
   {
        try {
            String query="select date,id,meal from meal where user='"+user+"'and date='"+date+"';";
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
   }
    public ResultSet getmealid(String user,String date,String id)
   {
        try {
            String query="select date,id,meal from meal where user='"+user+"'and date='"+date+"' and id='"+id+"';";
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
   }
   public ResultSet getexpense(String user)
   {
        try {
            String query="select date,expense from expense where user='"+user+"';";
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
   }
    public ResultSet getexpensedate(String user,String date)
   {
        try {
            String query="select date,expense from expense where user='"+user+"'and date='"+date+"';";
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
   }
  public ResultSet getdebit(String user)
   {
        try {
            String query="select date,id,taka from debit where user='"+user+"';";
            rs=st.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
   }
  public ResultSet totalexpense(String mon,String yr,String user)
  {
     String query="SELECT sum(expense) FROM expense WHERE MONTH(date)='"+mon+"' and YEAR(date) ='"+yr+"' and user='"+user+"';";
        try {
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
  }
 
  public ResultSet totalmeal(String mon,String yr,String user)
  {
     String query="select sum(meal)  from meal where month(date)='"+mon+"'and year(date)='"+yr+"' and user='"+user+"';";
        try {
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
  }
   public ResultSet totalmeal(String mon,String yr,String id,String user)
  {
     String query="select sum(meal)  from meal where month(date)='"+mon+"'and year(date)='"+yr+"' and id='"+id+"' and user='"+user+"';";
        try {
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
  }
    public ResultSet totaldebited(String mon,String yr,String user)
  {
     String query="select sum(taka)  from debit where month(date)='"+mon+"'and year(date)='"+yr+"' and user='"+user+"';";
        try {
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
  }
     public ResultSet getname(String user,String id)
   {
        try {
            String query="select name from member where user='"+user+"' and id='"+id+"';";
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
   }
 
  public ResultSet showinfbyid(String mon,String yr,String id,String user)
  {
     String query="select id,sum(taka) from debit" 
             + " where month(date)='"+mon+"' and year(date)='"+yr
             +"' and user='"+user+"'and id='"+id+"'group by id;";
        try {
            rs=st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
  }
   
}
