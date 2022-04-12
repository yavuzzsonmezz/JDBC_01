package mustafa;

import java.sql.*;

public class Jdbc_01 {

    private static final String CONNECTSTR="jdbc:mysql://localhost:3306/jdbc_tech?useSSL=false";
    private static final String QUERY="SELECT * FROM students";
    public static void main(String[] args) {

        try{
            //1. create a connection
            Connection connection = DriverManager.getConnection(CONNECTSTR,"root","123456789");
            //2. create a statement using that above connection object
            Statement stmt = connection.createStatement();
            //3. execute sql query, there are two methods to execute sql query
            ResultSet rs = stmt.executeQuery(QUERY);
            //4.Process the resultset
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                System.out.println(id+","+name+","+email+","+country);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
