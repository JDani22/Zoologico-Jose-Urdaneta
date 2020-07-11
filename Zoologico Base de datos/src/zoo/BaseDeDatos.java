package zoo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDeDatos extends Thread{

public BaseDeDatos() {
	
};
public void run() {
	try {
		Connection conn =DriverManager.getConnection("jdbc:postgresql://localhost:5432/zoologico","postgres","princho4");
		Statement s= conn.createStatement();
		ResultSet r= s.executeQuery("select * FROM Animales");
		System.out.println("Se ejecuto bien");
		while(r.next()) {
			System.out.println(r.getString("Animales"));
		}
	}catch(SQLException e) {
		e.printStackTrace();
		System.out.println("Se ejecuto mal");
		
	}

}

			
		
	}

