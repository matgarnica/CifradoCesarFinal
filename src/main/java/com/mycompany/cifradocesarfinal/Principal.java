/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cifradocesarfinal;


import java.io.IOException;
import java.util.Scanner;

/**
 * Clase principal del cifrado César con métodos para definir alfabeto, encriptar y desencriptar mensajes
 * @author MateoG
 * @version 1.5
 */
public class Principal {
    /**
     * Variable que guarda los caracteres que puede tener un mensaje
     */
    protected static char[] arrayAlfabeto;
    /**
     * Variable que guarda el mensaje ingresado por el usuario
     */
    protected static String mensajeCadena;
    /**
     * Variable que guarda el código ingresado por el usuario
     */
    protected static int clave;
    /**
     * Variable que divide el mensaje del usuario en caracteres individuales
     */
    protected static char[] mensajeCaracteres;
    /**
     * Variable que guarda la posición del caracter en arrayAlfabeto
     */
    protected static int indiceArray;
    
    /**
     * Método para mostrar en consola un menú de opciones
     */
    public static void menuOpciones(){
        while(1==1){
            /**
             * Variable tipo Scanner para detectar la entrada de teclado
             */
            Scanner entrada = new Scanner(System.in);
            /**
             * Variable que guarda la opción elegida por el usuario
             */
            String accion;
            System.out.print("\nCifrado César - Elija una opción:\nEncriptar(e), Desencriptar(d), Salir(s): "); 
            accion = entrada.nextLine();
            if(accion.equals("e")){
                System.out.print("Escriba el mensaje para encriptar: ");
                mensajeCadena = entrada.nextLine();
                System.out.print("Escriba una clave numérica: ");
                clave = entrada.nextInt();
                System.out.println("Mensaje encriptado: " + encriptarMensaje(mensajeCadena,clave));
            }else if(accion.equals("d")){
                System.out.print("Escriba el mensaje para desencriptar: ");
                mensajeCadena = entrada.nextLine();
                System.out.print("Escriba una clave numérica: ");
                clave = entrada.nextInt();
                System.out.println("Mensaje desencriptado: " + desencriptarMensaje(mensajeCadena,clave));
            }else if(accion.equals("s")){
                System.exit(0);
            }else{
                System.out.print("Opción no válida.\n");
            }
        }
    }//Fin Método menuOpciones
    
    /**
    * Método para definir el alfabeto
    * @return arrayAlfabeto Devuelve el array con los caracteres del alfabeto
    */
    public static char[] definirAlfabeto(){
        arrayAlfabeto = " !\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();
        return arrayAlfabeto;
    }//Fin Método definirAlfabeto
    /**
    * Método que recibe el mensaje y la clave para encriptar
    * @param mensajeCadena El parámetro mensajeCadena recibe el mensaje ingresado por el usuario
    * @param clave El parámetro clave recibe el código para encriptar ingresado por el usuario
    * @return mensajeCadena Devuelve el mensaje encriptado
    */
    public static String encriptarMensaje(String mensajeCadena, int clave){
        arrayAlfabeto = definirAlfabeto();
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
        return mensajeCadena;
    }//Fin Método encriptarMensaje
    /**
    * Método que recibe el mensaje y la clave para desencriptar
    * @param mensajeCadena El parámetro mensajeCadena recibe el mensaje ingresado por el usuario
    * @param clave El parámetro clave recibe el código para desencriptar ingresado por el usuario
    * @return mensajeCadena Devuelve el mensaje encriptado
    */
    public static String desencriptarMensaje(String mensajeCadena, int clave){
        arrayAlfabeto = definirAlfabeto();
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
        return mensajeCadena;
    }//Fin Método desencriptarMensaje
    /**
    * Método principal main
    */
    public static void main(String[] args) throws IOException {
        
        menuOpciones();
        
    }
}
