// import java.sql.Connection;
// import java.sql.Driver;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class connectiontosql {
//     public static void main(String[] args) {
//         String url = "jdbc:mysql://localhost:3306/hospital";

//         String username = "root";
//         String password = "Vishal@143";

//         try(Connection connection = DriverManager.getConnection(url, username, password)){
//             System.out.println("Connected to the database");
//         } catch (SQLException e){
//             System.err.println("Connection failed" + e.getMessage());
//         }
//     }
    
// }