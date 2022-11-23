import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectMySQL { 

    /**
     * @param args
     */
    public static void main(String[] args) { 

        Connection conn = null; 

        Statement st = null; 

        ResultSet rs = null; 

        try { 

            String dbURL = "jdbc:mysql://localhost/mysql_db"; 

            String username = "root"; 

            String password = ""; 

            //Tạo kết nối 

            conn = (Connection) DriverManager.getConnection(dbURL, username, password); 

            if (conn != null) { 

                System.out.println("Kết nối thành công"); 

            } 

 

            //DELETE a column 

 PreparedStatement preparedStmt = conn.prepareStatement("delete from dssv where id = ?"); 

preparedStmt.setInt(1, 4); 

preparedStmt.execute(); 

 

            //INSERT a column 

((java.sql.Statement) st).executeUpdate("INSERT INTO dssv " + "VALUES (4, 'minh', '1234567')"); 

 

            //UPDATE a column 

            PreparedStatement preparedStm,tPreparedStatement = conn.prepareStatement("update dssv set passwd = ? where id = ?");
preparedStmt.setString(1, "12345678"); 

preparedStmt.setInt   (2, 4); 

preparedStmt.executeUpdate(); 

 

                // Câu lệnh Xem dữ liệu 

 String sql = "select * from dssv"; 

            // Tạo đối tượng thực thi câu lệnh Select 

 st = (Statement) conn.createStatement(); 

            // Thực thi 

  rs = ((java.sql.Statement) st).executeQuery(sql); 

 

            // Nếu không có dữ liệu trong bảng 

  if (!rs.isBeforeFirst()) { 

  JOptionPane.showMessageDialog(null, "Bảng không có dữ liệu!"); 

            } 

            //Xử lý dữ liệu 

   System.out.println("Thực hiện lệnh in:"); 

   int rowCount = 0; 

   while(rs.next()) { 

                String pass = rs.getString("password"); 

                String user = rs.getString("username"); 

                int    id   = rs.getInt("ID"); 

                System.out.println(id + ", " + user + ", " + pass); 

                ++rowCount; 

            } 

            System.out.println("Tổng số hàng = " + rowCount); 

        } catch (SQLException e) { 

            e.printStackTrace(); 

        } 

    } 

} 

 

 

 

 