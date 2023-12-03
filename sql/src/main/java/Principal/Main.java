package Principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import org.xml.sax.SAXException;
import Vista.Ventana1;
import javax.swing.JOptionPane;

/**
 *
 * @author MonkeeBoi
 */
public class Main {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, NotSerializableException, SAXException{
        
        try{
            Ventana1 ventana = new Ventana1();
            ventana.setVisible(true);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Error inesperado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
            
    }
}
