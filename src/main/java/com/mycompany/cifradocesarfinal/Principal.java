/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cifradocesarfinal;


import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author MateoG
 */
public class Principal {
    
    public static char[] definirAlfabeto(){
        
        char[] arrayAlfabeto;
        arrayAlfabeto = "abcdefghijklmnñopqrstuvwxyz".toCharArray();
        
        return arrayAlfabeto;
    }
    
    public static String encriptarMensaje(String mensajeCadena, int clave){
        
        char[] arrayAlfabeto = definirAlfabeto();
        char[] mensajeCaracteres;
        int indiceArray;
        
        mensajeCaracteres = mensajeCadena.toCharArray();
        mensajeCadena = "";

        for (int x=0; x<mensajeCaracteres.length; x++){
            indiceArray = new String(arrayAlfabeto).indexOf(mensajeCaracteres[x]) + clave;
            if(indiceArray >= arrayAlfabeto.length){
                indiceArray = indiceArray - arrayAlfabeto.length;
            }
            mensajeCaracteres[x] =  arrayAlfabeto[indiceArray]; 
            mensajeCadena = new StringBuilder().append(mensajeCadena).append(mensajeCaracteres[x]).toString();
        }
        
        return mensajeCadena;
    }
    
    public static String desencriptarMensaje(String mensajeCadena, int clave){
        
        char[] arrayAlfabeto = definirAlfabeto();
        char[] mensajeCaracteres;
        int indiceArray;
        
        mensajeCaracteres = mensajeCadena.toCharArray();
        mensajeCadena = "";

        for (int x=0; x<mensajeCaracteres.length; x++){
            indiceArray = new String(arrayAlfabeto).indexOf(mensajeCaracteres[x]) - clave;
            if(indiceArray < 0){
                indiceArray = indiceArray + arrayAlfabeto.length;
            }
            mensajeCaracteres[x] =  arrayAlfabeto[indiceArray]; 
            mensajeCadena = new StringBuilder().append(mensajeCadena).append(mensajeCaracteres[x]).toString();
        }
        
        return mensajeCadena;
    }
    
    public static void main(String[] args) throws IOException {
        
        Scanner entrada = new Scanner(System.in);
        String accion;
        System.out.print("Desea encriptar(e) o desencriptar(d) un mensaje?: "); 
        accion = entrada.nextLine();
        if(accion.equals("e")){
            
            String mensajeCadena;
            int clave;
            
            System.out.print("Escriba el mensaje para encriptar: ");
            mensajeCadena = entrada.nextLine();
            System.out.print("Escriba una clave numérica: ");
            clave = entrada.nextInt();
            
            System.out.println("Mensaje encriptado: " + encriptarMensaje(mensajeCadena,clave));
            
        }else if(accion.equals("d")){
            
            String mensajeCadena;
            int clave;
            
            System.out.print("Escriba el mensaje para desencriptar: ");
            mensajeCadena = entrada.nextLine();
            System.out.print("Escriba una clave numérica: ");
            clave = entrada.nextInt();
            
            System.out.println("Mensaje desencriptado: " + desencriptarMensaje(mensajeCadena,clave));
            
        }else{
            System.out.print("Opción no válida.");
            System.exit(0);
        }
    }
}
