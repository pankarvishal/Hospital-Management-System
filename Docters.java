import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.Scanner;
public class Docters {
    private Connection connection;
    private Scanner scanner;

    public Docters(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }
public void viewDocter(){
    String query = "select * from Docters";

    try{
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println( "Docter_Id |  Name          |  contact");

while(resultSet.next()){
    int id = resultSet.getInt("id");
    String name = resultSet.getString("name");
    int contact = resultSet.getInt("contact"); 
    System.out.println(id+"        "+name+"         "+contact);
}
System.out.println();


    }catch (SQLException e){
        e.printStackTrace();
    }
}

}