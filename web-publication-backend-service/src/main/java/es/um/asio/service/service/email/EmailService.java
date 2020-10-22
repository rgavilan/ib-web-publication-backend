package es.um.asio.service.service.email;

public interface EmailService {

    public void sendSimpleMessage (String from, String to, String subject, String text);
    
    public void checkEmail(String from, String email, String subject, String text);
}
