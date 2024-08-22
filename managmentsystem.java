import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.Scanner;
public class managmentsystem {


    private static final String url = "jdbc:mysql://localhost:3306/hospital";
       private static final String username = "root";
        private static final String password = "Vishal@143";
    public static void main(String[] args) {
       try{
        Class.forName("com.mysql.cj.jdbc.Driver");
       }catch(ClassNotFoundException e){
        e.printStackTrace(); 
       }
       Scanner scanner = new Scanner(System.in);
       try{
            Connection connection = DriverManager.getConnection(url,username,password);
            patient p = new patient(connection , scanner);
            Docters d = new Docters(connection, scanner);
            while(true){
                System.out.println("Hospital Managment system");
                System.out.println("1 Add patient");
                System.out.println("2 view patient");
                System.out.println("3 Check Patient id");
                System.out.println("4 Check Available Docters :");
                System.out.println();


                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        p.addpatient();
                        break;
                    case 2:
                        p.viewpatient();
                        break;
                    case 3:
                        System.out.println("Enter Patient Id");
                        int id = scanner.nextInt();
                        p.getPatientid(id);
                        break;
                    case 4:
                        d.viewDocter();
                        break;
                    default:
                        System.out.println("Enter valid Choice");
                        break;
                }
            }


       }catch(SQLException e){
            e.printStackTrace();
       }
     }
}
