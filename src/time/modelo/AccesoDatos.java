package time.modelo;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AccesoDatos {

    public void crear(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        try {
            if (this.exite(nombreRecurso)) {
          
            } else {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se a ceado el archvo");
            }

        } catch (IOException ex) {
            System.out.println("Message Error -→" + ex.getMessage());
        }
    }

    public void escribir(MdlStyle mdlStyle, String nombreRecuros) {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreRecuros);
            salida = new PrintWriter(new FileWriter(archivo, false));
            salida.println(mdlStyle.toString());
            System.out.println("Se a escrito la informacion" + mdlStyle);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Excepcion a lista peliculas:" + ex.getMessage());
        } finally {
            salida.close();
        }
    }

    public ArrayList listar(String nombreRecurso){
        File archivo = new File(nombreRecurso);
        ArrayList peliculas = new ArrayList();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String line = null;
            line = entrada.readLine();// lemos la linea
            while (line != null) {
             
                peliculas.add(line);
                line = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println(""+ ex.getMessage());
        } catch (IOException ex) {

            System.out.println("Excepcion a lista peliculas:" + ex.getMessage());
        }
        return peliculas;
    }

    public boolean exite(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

}
