/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evalprocorreo;

import java.util.Properties;
import javax.mail.Session;

/**
 *
 * @author Luis Daniel
 */
public class Correo {

    private Usuario usuario;
    private ServidorSmtp servidor;
    
    public Correo(Usuario usuario) {
    
        this.usuario = usuario;
        this.servidor = new ServidorSmtp(usuario.getCorreo(), 1); // Simple Mail Transfer Protocol (SMTP)
    }

    public void enviarMensaje(String[] para, String asunto, String textoMensaje) {
        
        Properties props = new Properties(); //HashTable        
        Properties props2 = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", servidor.getNombre());
        props.put("mail.smtp.port", servidor.getPuerto());

        Session sesion = Session.getInstance(props, usuario);

        Mensaje m = new Mensaje(sesion);
        m.enviar(usuario.getCorreo(), para, asunto, textoMensaje);
    }

    public static void main(String[] args) {
        Usuario admi = new Usuario("evalpro.itver@gmail.com", "contraseña");
        Correo c = new Correo(admi);
        String[] arregloDestinarios = {"androidfenix555@gmail.com","vrebo.deg@gmail.com","daniel_big3@hotmail.com"};
        c.enviarMensaje(arregloDestinarios, "Remitente", "Esto es un prueba");
    }
}
