import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class vtn {
    private JPanel vtaa;

    public static void main(String[] args) {
        try {
            //Registra el Driver de MySql
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/nuevosDatos",
                    "root","dariel17");
            //Se crea un statement para realizar la consulta
            Statement s = conexion.createStatement();
            /* Se realiza la consulta, los resultados se guardan en ResultSet rs */
            ResultSet rs = s.executeQuery("select IDEst from estudiantes");
            //Se recorre el ResultSet, mostrando por pantalla los resultados
            while(rs.next()) {
                System.out.println(rs.getInt(1));
            }
            conexion.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
