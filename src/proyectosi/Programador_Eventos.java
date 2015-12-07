/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosi;

import Arbol.*;
import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import javax.swing.JFileChooser;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author jefersson
 */
public class Programador_Eventos extends javax.swing.JFrame {

    /**
     * Creates new form Programador_Eventos
     */
    public double temperatura, humedad, viento, precipitacion, clo;
    public String date, decision, PetDescription;
    public int Pet;
    public LocalDateTime fecha;
    
    public Programador_Eventos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Date jDateChooser2 = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel(jDateChooser2, null, null, Calendar.HOUR_OF_DAY);
        jSpinner2 = new javax.swing.JSpinner(sm);
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bienvenidos al programador de eventos. ");

        jLabel3.setText("Fecha y Hora del Evento");

        JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner2, "HH:mm:ss");
        jSpinner2.setEditor(de);
        jSpinner2.setToolTipText("00:00:00");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jButton1.setText("Evaluar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        temperatura = 0.0; viento = 0.0; humedad = 0.0; precipitacion = 0.0;
        int dia = jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH);
        int  mes = jDateChooser1.getCalendar().get(Calendar.MONTH)+1;
        int año = jDateChooser1.getCalendar().get(Calendar.YEAR);
        Format formatter = new SimpleDateFormat("HH:mm:ss");
        String hour  = formatter.format(jSpinner2.getValue());
        String[] s = hour.split(":");
        int hora = Integer.parseInt(s[0]);
        int minuto = Integer.parseInt(s[1]);
        fecha = LocalDateTime.of(año, mes, dia, hora, minuto);
        File f = new File("Datos climaticos.xlsx");
        recorrerArchivo ra = new recorrerArchivo();
        ra.recorrer(f, fecha);
        temperatura = ra.totalTemperatura / ra.numRegistrosLeidos;
        humedad = ra.totalHumedad / ra.numRegistrosLeidos;
        viento = ra.totalViento / ra.numRegistrosLeidos;
        precipitacion = ra.totalPrecipitacion / ra.numRegistrosLeidos;
        System.out.println(temperatura);
        System.out.println(humedad);
        System.out.println(viento);
        System.out.println(precipitacion);
        ArbolNario arbol = new ArbolNario();
        crearArbol(arbol);
        //arbol.imprimirArbol(arbol);
        decision = setDecision();
        PetDescription = ((Nodo)arbol.raiz.nodosHijos.get(Pet-1)).getLabel();
        System.out.println(PetDescription);
        mostrarResultados();
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Programador_Eventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Programador_Eventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Programador_Eventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Programador_Eventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Programador_Eventos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner jSpinner2;
    // End of variables declaration//GEN-END:variables

    public void crearArbol(ArbolNario arbol) {
        arbol.insertarHijo("", "PET", "");
        arbol.insertarHijo("PET", "Muy Frío", "1");
        arbol.insertarHijo("PET", "Frío", "2");
        arbol.insertarHijo("PET", "Fresco", "3");
        arbol.insertarHijo("PET", "Ligeramente Fresco", "4");
        arbol.insertarHijo("PET", "Confortable", "5");
        arbol.insertarHijo("PET", "Ligeramente Cálido", "6");
        arbol.insertarHijo("PET", "Cálido", "7");
        arbol.insertarHijo("PET", "Caluroso", "8");
        arbol.insertarHijo("PET", "Muy Caluroso", "9");
        arbol.insertarHijo("Muy Frío", "NO", "");
        arbol.insertarHijo("Frío", "NO", "");
        arbol.insertarHijo("Fresco", "Humedad3", "");
        arbol.insertarHijo("Ligeramente Fresco", "Humedad4", "");
        arbol.insertarHijo("Confortable", "Precipitacion5", "");
        arbol.insertarHijo("Ligeramente Cálido", "Humedad6", "");
        arbol.insertarHijo("Cálido", "Humedad7", "");
        arbol.insertarHijo("Calurso", "NO", "");
        arbol.insertarHijo("Muy Caluroso", "NO", "");
        arbol.insertarHijo("Humedad3", "Precipitacion3", "");
        arbol.insertarHijo("Humedad3", "NO", "");
        arbol.insertarHijo("Humedad4", "Precipitacion4", "");
        arbol.insertarHijo("Humedad4", "NO", "");
        arbol.insertarHijo("Precipitacion5", "Viento5", "");
        arbol.insertarHijo("Precipitacion5", "NO", "");
        arbol.insertarHijo("Humedad6", "NO", "");
        arbol.insertarHijo("Humedad6", "Precipitacion6", "");
        arbol.insertarHijo("Humedad7", "NO", "");
        arbol.insertarHijo("Humedad7", "Precipitacion7", "");
        arbol.insertarHijo("Precipitacion3", "Viento3", "");
        arbol.insertarHijo("Precipitacion3", "NO", "");
        arbol.insertarHijo("Precipitacion4", "Viento4", "");
        arbol.insertarHijo("Precipitacion4", "NO", "");
        arbol.insertarHijo("Viento5", "SI", "");
        arbol.insertarHijo("Viento5", "NO", "");
        arbol.insertarHijo("Precipitacion6", "Viento6", "");
        arbol.insertarHijo("Precipitacion6", "NO", "");
        arbol.insertarHijo("Precipitacion7", "Viento7", "");
        arbol.insertarHijo("Precipitacion7", "NO", "");
        arbol.insertarHijo("Viento3", "SI", "");
        arbol.insertarHijo("Viento3", "NO", "");
        arbol.insertarHijo("Viento4", "SI", "");
        arbol.insertarHijo("Viento4", "NO", "");
        arbol.insertarHijo("Viento6", "SI", "");
        arbol.insertarHijo("Viento6", "NO", "");
        arbol.insertarHijo("Viento7", "SI", "");
        arbol.insertarHijo("Viento7", "NO", "");
    }
    
    public String setDecision() {
        if(temperatura <= 32 ){ 
            Pet = 1; return "NO"; 
        }
        if (temperatura > 32 && temperatura <= 53.6) {
            Pet = 2 ; return "NO";
        }
        if(temperatura > 53.6 && temperatura <= 60.8)  {
            Pet = 3; 
            if(humedad < 65 && precipitacion < 70 && viento < 30 ) return "SI";
        }
        if(temperatura > 60.8 && temperatura <= 66.2) {
            Pet = 4; 
            if(humedad < 65 && precipitacion < 70 && viento < 30 )  return "SI";
        }
        if(temperatura > 66.2 && temperatura <= 75.2) {
            Pet = 5; 
            if(precipitacion < 70 && viento < 30 )  return "SI";
        }
        if(temperatura > 75.2 && temperatura <= 78.8) {
            Pet = 6; 
            if(humedad > 65 && precipitacion < 70 && viento < 30 )  return "SI";
        }
        if(temperatura > 78.8 && temperatura <= 89.6) {
            Pet = 7; 
            if(humedad > 65 && precipitacion < 70 && viento < 30 )  return "SI";
        }
        if((temperatura > 89.6 && temperatura <= 104)) {
            Pet = 8; return "NO";
        }
        if(temperatura > 104 ) {
            Pet = 9; return "NO";
        }
        return "NO";
    }
    
    public void mostrarResultados() {
        String Reason = "";
        Resultados r = new Resultados();
        r.jLabel1.setText("Fecha y Hora del Evento: " + fecha.toLocalDate().toString()
            + " a las "+ fecha.toLocalTime().toString() );
        if(decision == "NO") {
            if(Pet == 1 || Pet == 2) {
                Reason = "Por temperaturas muy bajas.";
            } else if (Pet == 8 || Pet == 9) {
                Reason = "Por temperaturas muy altas.";
            } else if(Pet == 3 || Pet == 4) {
                if( humedad >= 65) {
                    Reason = "Por alta humedad ";
                } else if (precipitacion >= 0.7) {
                    Reason = "Por alta precipitacion ";
                } else if(viento >= 30) {
                    Reason = "Por altos vientos ";
                }
                Reason += "a temperaturas bajas";
            } else if(Pet == 6 || Pet == 7) {
                if( humedad < 65) {
                    Reason = "Por baja humedad ";
                } else if (precipitacion >= 0.7) {
                    Reason = "Por alta precipitacion ";
                } else if(viento >= 30) {
                    Reason = "Por altos vientos ";
                }
                Reason += "a temperaturas altas";
            } else if(Pet == 5) {
                if (precipitacion >= 0.7) {
                    Reason = "Por alta precipitacion ";
                } else if(viento >= 30) {
                    Reason = "Por altos vientos ";
                }
                Reason += " a temperaturas medias";
            }
        }
        r.jLabel2.setText("La decision tomada es "+decision + " " + Reason);
        r.setVisible(true);
    }
}
