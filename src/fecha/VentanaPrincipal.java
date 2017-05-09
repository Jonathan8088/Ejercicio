/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jonathan
 */
public class VentanaPrincipal {
    
    public Date fecha;
    
    private static SimpleDateFormat formato;
    
    private static SimpleDateFormat formatoh;

    public String fechaString;
    
    public String horaString;
    
    File archivo = null;
    
    FileReader fr=null;
    
    BufferedReader br = null;
    
    String fec="14/02/2014";
    
    public VentanaPrincipal()  {
        
        
        try {
            archivo = new File("C:\\Users\\Jonathan\\Documents\\NetBeansProjects\\Fecha\\archivo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            fecha= new Date();
            
        
            formato = new SimpleDateFormat("dd/MM/YYYY");
            formatoh = new SimpleDateFormat("hh:mm:ss");
            fechaString = formatoh.format(fecha);
            
            horaString = formatoh.format(fecha);
            System.out.println(horaString);
            
            Date fech=DeStringADate(fec);
            System.out.println(fech);
            Escribir(fech);
            String linea;
            
            while ((linea=br.readLine())!=null) {                
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }//catch
        
    }
    
    public void Escribir(Date fecha1){
        FileWriter fichero = null;
    
        Date fecha2 = fecha1;
        
        PrintWriter pw = null;
        
        try {
            fichero = new FileWriter("C:\\Users\\Jonathan\\Documents\\NetBeansProjects\\Fecha\\archivo.txt");
            pw = new PrintWriter(fichero);
            
            pw.println("Fecha: "+fecha2);
            pw.println("Fecha string: "+fechaString );
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (null != fichero) {
                fichero.close();
                }//if
            } catch (Exception e) {
                e.printStackTrace();
            }//catch

        }//finally
    
    }//Escribir
    
    public Date DeStringADate(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = fecha;
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(strFecha);
                        System.out.println(fechaDate.toString());
            return fechaDate;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return fechaDate;
        }
    }
    
}//VentanaPrincipal
