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
 * @version 19/02/2019/A
 */
public class Principal {
    /**
    * Método para definir el alfabeto
    */
    public static char[] definirAlfabeto(){
        /**
         * @param arrayAlfabeto El parámetro arrayAlfabeto define los caracteres que puede tener un mensaje
         */
        char[] arrayAlfabeto;
        arrayAlfabeto = " !\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();
        
        return arrayAlfabeto;
    }//Fin Método definirAlfabeto
    /**
    * Método que recibe el mensaje y la clave para encriptar
    */
    public static String encriptarMensaje(String mensajeCadena, int clave){
        /**
         * @param mensajeCadena El parámetro mensajeCadena recibe el mensaje ingresado por el usuario
         * @param clave El parámetro clave recibe el código para encriptar ingresado por el usuario
         * @param arrayAlfabeto El parámetro arrayAlfabeto llama al método definirAlfabeto y guarda el alfabeto en un array tipo char
         * @param mensajeCaracteres El parámetro mensajeCaracteres divide el mensaje del usuario en caracteres individuales
         * @param indiceArray El parámetro indiceArray es de tipo entero y almacenará la posición del caracter
         */
        char[] arrayAlfabeto = definirAlfabeto();
        char[] mensajeCaracteres;
        int indiceArray;
        
        mensajeCaracteres = mensajeCadena.toCharArray();
        mensajeCadena = "";
        //Se valida si la clave es negativa o mayor a la longitud del alfabeto
        if(clave < 0){
            clave = clave*-1;
        }
        if(clave > arrayAlfabeto.length){
            clave = clave%arrayAlfabeto.length;
        }
        
        for (int x=0; x<mensajeCaracteres.length; x++){
            indiceArray = new String(arrayAlfabeto).indexOf(mensajeCaracteres[x]) + clave; //Se obtiene la posición del caracter en el array del alfabeto y se le suma la clave
            if(indiceArray >= arrayAlfabeto.length){ 
                indiceArray = indiceArray - arrayAlfabeto.length;//Vuelve a recorrer posiciones
            }
            mensajeCaracteres[x] =  arrayAlfabeto[indiceArray]; //Se reemplaza por el caracter encriptado
            mensajeCadena = new StringBuilder().append(mensajeCadena).append(mensajeCaracteres[x]).toString(); //Concatenación del mensaje final
        }
        /**
         * @return mensajeCadena Devuelve el mensaje encriptado
         */
        return mensajeCadena;
    }//Fin Método encriptarMensaje
    /**
    * Método que recibe el mensaje y la clave para desencriptar
    */
    public static String desencriptarMensaje(String mensajeCadena, int clave){
        /**
         * @param mensajeCadena El parámetro mensajeCadena recibe el mensaje ingresado por el usuario
         * @param clave El parámetro clave recibe el código para desencriptar ingresado por el usuario
         * @param arrayAlfabeto El parámetro arrayAlfabeto llama al método definirAlfabeto y guarda el alfabeto en un array tipo char
         * @param mensajeCaracteres El parámetro mensajeCaracteres divide el mensaje del usuario en caracteres individuales
         * @param indiceArray El parámetro indiceArray es de tipo entero y almacenará la posición del caracter
         */
        char[] arrayAlfabeto = definirAlfabeto();
        char[] mensajeCaracteres;
        int indiceArray;
        
        mensajeCaracteres = mensajeCadena.toCharArray();
        mensajeCadena = "";
        //Se valida si la clave es negativa o mayor a la longitud del alfabeto
        if(clave < 0){
            clave = clave*-1;
        }
        if(clave > arrayAlfabeto.length){
            clave = clave%arrayAlfabeto.length;
        }

        for (int x=0; x<mensajeCaracteres.length; x++){
            indiceArray = new String(arrayAlfabeto).indexOf(mensajeCaracteres[x]) - clave; //Se obtiene la posición del caracter en el array del alfabeto y se le resta la clave
            if(indiceArray < 0){
                indiceArray = indiceArray + arrayAlfabeto.length;//Vuelve a recorrer posiciones
            }
            mensajeCaracteres[x] =  arrayAlfabeto[indiceArray]; //Se reemplaza por el caracter encriptado
            mensajeCadena = new StringBuilder().append(mensajeCadena).append(mensajeCaracteres[x]).toString(); //Concatenación del mensaje final
        }
        /**
         * @return mensajeCadena Devuelve el mensaje desencriptado
         */
        return mensajeCadena;
    }//Fin Método desencriptarMensaje
    
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
