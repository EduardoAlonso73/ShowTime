package time.controlador;

import javax.swing.JLabel;
import time.modelo.AccesoDatos;
import time.modelo.MdlStyle;

public class Service {
    
    static int  selectStyleApper;
    AccesoDatos accesoData = new AccesoDatos();

    public Service() {

    }

    public void agragarPeliculas(String font, int fontStyle, int size,int styleApper) {
        MdlStyle mdlStyle = new MdlStyle(font, fontStyle, size,styleApper);

        String nameFile = "FontsSetting.txt";
        try {
            accesoData.exite(nameFile);
            accesoData.crear(nameFile);
            accesoData.escribir(mdlStyle, nameFile);
        } catch (Exception ex) {
            System.out.println("Error el acceso de datos");
        }

    }

    public void changeStyle( JLabel showTime) {
        try {
            var Fomato = this.accesoData.listar("FontsSetting.txt");

            String stringFonts = "";
            for (int i = 0; i < Fomato.size(); i++) {
                stringFonts = stringFonts + Fomato.get(i);
            }
            String[] parts = stringFonts.split(",");

           selectStyleApper=Integer.parseInt(parts[3]);
            
              showTime.setFont(new java.awt.Font(parts[0], Integer.parseInt(parts[1]),Integer.parseInt(parts[2])));
        } catch (NumberFormatException ex) {
            System.out.println("Error de acceso datos ");
            ex.printStackTrace(System.out);
        }

    }


      public int selectStyle()
    {
              var Fomato = this.accesoData.listar("FontsSetting.txt");

        String stringFonts = "";
        for (int i = 0; i < Fomato.size(); i++) {
            stringFonts = stringFonts + Fomato.get(i);
        }
        String[] parts = stringFonts.split(",");
        
        return Integer.parseInt(parts[3]);
    }


//    public int getSelectStyleApper() {
//        return selectStyleApper;
//    }
//
//    public void setSelectStyleApper(int selectStyleApper) {
//        this.selectStyleApper = selectStyleApper;
//    }
//    
    
    

}
