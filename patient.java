import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.Scanner;
public class patient {
    private Connection connection;
    private Scanner scanner;

    public patient(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addpatient(){
        System.out.println("Enter patient name :");
        String name = scanner.next();
        System.out.println("Enter patient age :");
        int age = scanner.nextInt();
        System.out.println("enter patient gender :");
        String gender = scanner.next();

        try{
            String query = "INSERT INTO  patients(name , age , gender) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);

            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows>0){
                System.out.println("Patient added successfully :");
            }else{
                System.out.println("Failed to add patient!! :");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void viewpatient(){
        // System.out.println("Enter patient id to search:");
        // String name = scanner.next();
        String query = "SELECT * FROM patients";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("+----------+---------------+------+-------+");
            System.out.println("|Patient_id| Name          | Age  | Gender|");
            System.out.println("+----------+---------------+------+-------+");
            
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String Name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                System.out.println("|  "+id +"          "+"|"+ Name+"      " + "|"+age+"        " +"|"+ gender);
                
            }
            


        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public boolean getPatientid(int id){
        String query = "select * from patients where id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("Id is present");

                String query1 = "select * from patient where id = id";
                PreparedStatement preparedStatement2 = connection.prepareStatement(query1);
                ResultSet resultSet1 = preparedStatement.executeQuery();
                System.out.println("+----------+---------------+------+-------+");
                System.out.println("|Patient_id| Name          | Age  | Gender|");
                System.out.println("+----------+---------------+------+-------+");
                
                while(resultSet1.next()){
                id = resultSet1.getInt("id");
                String Name = resultSet1.getString("name");
                int age = resultSet1.getInt("age");
                String gender = resultSet1.getString("gender");
                System.out.println("|  "+id +"          "+"|"+ Name+"      " + "|"+age+"        " +"|"+ gender);
                
                }

                return true;
            }else{
                System.out.println("id not present");
                return false;
            }



        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}   