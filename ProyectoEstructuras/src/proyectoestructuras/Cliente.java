/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;

import javax.swing.JOptionPane;

/**
 *
 * @author indir
 */
public class Cliente {
    public String correoDado(String correo){
        String correoDado;
        do{   
        correoDado=JOptionPane.showInputDialog("Ingrese su correo: ");
            if(correoDado.contains("@")){
            switch (correoDado.substring(correoDado.indexOf("@"))) {
                case "@gmail.com" -> correo=correoDado;
                case "@hotmail.com" -> correo=correoDado;
                default -> JOptionPane.showMessageDialog(null,"Error: correo no valido"+
                            " debe ser una cuenta valida" , "Error", 0);
            }
            }else{
               JOptionPane.showMessageDialog(null, "Error: correo no valido"+
                    " debe contener @", "Alerta", 0);
            }
        }while(correo==null ||correo.equals(""));
        return correoDado;
     }
  
    
   
     public  Customer CrearCliente() {
         String correo="";
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre : ");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad  :"));
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de identificacion :"));
            int numeroTel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero telefono:"));
            correo=correoDado(correo);
              return new Customer(nombre,edad,id,numeroTel,correo);
            } 
  
}
