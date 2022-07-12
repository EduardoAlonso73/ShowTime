package time.controlador;


import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import time.modelo.AccesoDatos;
import time.vista.Setting;

import time.vista.Start;

public class CtdStart implements ActionListener, Runnable {

    Start dlgStart;
        AccesoDatos accesoData = new AccesoDatos();
    private ImageIcon _imagenIcon;
    private TrayIcon _trayIcon;
    private SystemTray _systemTray;
    LocalDateTime locaDate = LocalDateTime.now();

    Calendar calendario;
    String ampm, valiMinute;
    int hours, minutes, seconds;
    Thread h1;
    Service service = new Service();
   
  
    public CtdStart(Start dlgStart) {

        h1 = new Thread(this);
        h1.start();
        this.dlgStart = dlgStart;
        _imagenIcon = new ImageIcon(this.getClass().getResource("/Image/clock.png"));
        service.changeStyle(this.dlgStart.lblShowTime);
        this.dlgStart.MNIRefresc.addActionListener(this);
        this.dlgStart.MNISetting.addActionListener(this);
        this.dlgStart.setIconImage(_imagenIcon.getImage());
        this.startTray();
        this.startApplication();
         //  System.out.println("::::::::::>  "+ this.opcionAppare+ "  <:::::::::::::::");
     

    }

    private void startTray() {
        _trayIcon = new TrayIcon(_imagenIcon.getImage(), "Title", this.dlgStart.popupMenu1);
        _trayIcon.setImageAutoSize(true);
        _systemTray = SystemTray.getSystemTray();
        this.dlgStart.menuItem1.addActionListener(this);
//        this.dlgStart.lblShowTime.addMouseListener(this);
    }

    private void showDate() {
        //Fecha actual desglosada:
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
        String[] month = new String[]{"En", "Feb", "Mzo", "Abr", "My", "Jun", "Jul", "Agt", "sept", "Oct", "Novi", "Dic"};
        this.dlgStart.lblShowDate.setText(dia + ", de " + month[mes-1] + " de " + año);
    }

    public void calcula() {
        LocalDateTime locaDate = LocalDateTime.now();
        hours = locaDate.getHour();
        minutes = locaDate.getMinute();
        valiMinute = (minutes > 1 && minutes <= 9) ? "0" + minutes : "" + minutes;
        seconds = locaDate.getSecond();
        ampm = (hours > 11 && hours <= 24) ? "p.m" : "a.m";

    }

    private void startApplication() {
        try {
            if (SystemTray.isSupported()) {
                _systemTray.add(_trayIcon);
                this.run();
                this.showDate();
                this.dlgStart.setVisible(true);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.dlgStart.menuItem1) {

            _systemTray.remove(_trayIcon);
            System.exit(0);
        }
        if (e.getSource() == this.dlgStart.MNIRefresc) {
            this.dlgStart.dispose();
            this.dlgStart.setVisible(true);
        }
        if (e.getSource() == this.dlgStart.MNISetting) {
            Setting jdlSetting = new Setting(new javax.swing.JFrame(), true);
            CtdSetting ctdSetting = new CtdSetting(jdlSetting, this.dlgStart);
            jdlSetting.setVisible(true);
        }

    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            
            switch(service.selectStyle())
            {
                case 1 -> {     
            calcula();
            this.dlgStart.lblShowTime.setText(hours + ":" + valiMinute + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
                }
            default ->{
                   calcula();
            this.dlgStart.lblShowTime.setText(hours + ":" + valiMinute + ":" + seconds + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
                
                
                }
            
            }
         
        }

    }
    
    
  
}
