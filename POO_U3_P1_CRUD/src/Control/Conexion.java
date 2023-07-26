package Control;

import com.mysql.jdbc.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

public class Conexion {
    private static final String drive="com.mysql.jdbc";
    private static final String user="root";
    private static final String pass="";
    private static final String url="jdbc:mysql://localhost:3306/Estudiantes";
    Connection conectar=null;
    public Connection conexion(){
    try{
    Class.forName(drive);
    conectar=(Connection) DriverManager.getConnection(url,user,pass);
    
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null,"Error de conexion");
    }
    return conectar;}
}
