package time.controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import time.modelo.AccesoDatos;
import time.vista.Setting;
import time.vista.Start;
public final class CtdSetting implements ActionListener {

    AccesoDatos accesoData = new AccesoDatos();
    Setting jdlSetting;
    Service service = new Service();
    Start dlgStart;
    int opcAppearance;

    

    public CtdSetting(Setting jdlSetting, Start dlgStart) {
        this.jdlSetting = jdlSetting;
        this.dlgStart = dlgStart;
        this.jdlSetting.BtnSavaChange.addActionListener(this);
        this.jdlSetting.rb_opcio1.addActionListener(this);
        this.jdlSetting.rb_opcio2.addActionListener(this);
        this.fontCurrently();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jdlSetting.BtnSavaChange) {
            String font, fontStyle, size;
            font = this.jdlSetting.jCBFont.getSelectedItem().toString();
            fontStyle = this.jdlSetting.jCBFontStyle.getSelectedItem().toString();
            size = this.jdlSetting.jCBSize.getSelectedItem().toString();
            int optFontStl;
            if (null == fontStyle) {
                optFontStl = 3;
            } else optFontStl = switch (fontStyle) {
                case "Plain" -> 0;
                case "Bold" -> 1;
                case "Italic" -> 2;
                case "Bold Italic" ->3 ;
                default -> 3;
            };

            service.agragarPeliculas(font, optFontStl, Integer.parseInt(size),this.getOpcAppearance());
            service.changeStyle(this.dlgStart.lblShowTime);
            this.jdlSetting.dispose();
        }
        
        
        if(e.getSource()== this.jdlSetting.rb_opcio1)
        {
          if(this.jdlSetting.rb_opcio1.isSelected()==true)
          {
               this.setOpcAppearance(1);
               
          }
        }
        
         if(e.getSource()== this.jdlSetting.rb_opcio2)
        {
          if(this.jdlSetting.rb_opcio2.isSelected())
          {
                 this.setOpcAppearance(2);
          }
        }
         
    }

    public void fontCurrently() {
        var Fomato = this.accesoData.listar("FontsSetting.txt");

        String stringFonts = "";
        for (int i = 0; i < Fomato.size(); i++) {
            stringFonts = stringFonts + Fomato.get(i);
        }

        String[] parts = stringFonts.split(",");
        this.jdlSetting.jCBFont.setSelectedItem(parts[0]);
        String optFontStl = "";
        
        switch (Integer.parseInt(parts[1])) {
            case 0 -> optFontStl = "Plain";
            case 1 -> optFontStl = "Bold";
            case 2 -> optFontStl = "Italic";
            case 3 -> optFontStl = "Bold Italic";
        }
        
        switch (Integer.parseInt(parts[3])) {
            case 1->{
                this.jdlSetting.rb_opcio1.setSelected(true);
                 this.setOpcAppearance(1);
            }
            default-> {
                this.jdlSetting.rb_opcio2.setSelected(true);
                 this.setOpcAppearance(2);
            }
         
        }
        
           System.out.println("-*********-*-*-**-  0"+ optFontStl);
        this.jdlSetting.jCBFontStyle.setSelectedItem(optFontStl);
        this.jdlSetting.jCBSize.setSelectedItem(parts[2]);
    }
    
    
    public int getOpcAppearance() {
        return opcAppearance;
    }

    public void setOpcAppearance(int opcAppearance) {
        this.opcAppearance = opcAppearance;
    }
  
        
        
    
}
