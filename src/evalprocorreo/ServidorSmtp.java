/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evalprocorreo;

/**
 *
 * @author Luis Daniel
 */
public class ServidorSmtp {

    private String nombre;
    private String puerto;

    public ServidorSmtp(String correo, int numero) {
        tipoNombre(correo);
        tipoPuerto(numero);
    }
    
    private void tipoNombre(String correo) {
        String[] arreglo = correo.split("@");        
        switch (arreglo[1]) {
            case "gmail.com":
                this.nombre = "smtp.gmail.com";
                break;
            case "hotmail.com":
                this.nombre = "smtp.live.com";
                break;
            case "yahoo.com":
                this.nombre = "smtp.mail.yahoo.com";
        }
    }

    private void tipoPuerto(int numero) {
        switch (numero) {
            case 1:
                this.puerto = "587";
                break;
            case 2:
                this.puerto = "465";
                break;
            case 3:
                this.puerto = "25";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuerto() {
        return puerto;
    }
    public static void main(String[] args) {
        ServidorSmtp servidor = new ServidorSmtp("hotmail.com", 1);
        System.out.println(servidor.nombre);
    }
   
}
