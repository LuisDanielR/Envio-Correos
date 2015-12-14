/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evalprocorreo;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Luis Daniel
 */
public class Mensaje extends MimeMessage {

    public Mensaje(Session session) {
        super(session);
    }

    public void enviar(String correo, String destinatarios[], String asunto, String textoMsj) {
        try {            
            setFrom(new InternetAddress(correo));
            setSubject(asunto);
            setText(textoMsj);
            Address[] destinos = new Address[destinatarios.length];
            for (int i = 0; i < destinos.length; i++) {
                destinos[i] = new InternetAddress(destinatarios[i].trim());
            }
            addRecipients(Message.RecipientType.TO, destinos);
            Transport.send(this);
        } catch (MessagingException e) {
            System.out.println("Error en el mensaje");
            e.printStackTrace();
        }
    }
}
