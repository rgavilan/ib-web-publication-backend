package es.um.asio.service.config;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    /** Mail isDes */
    @Value("${app.mail.isDes}")
    private Boolean isDes;

    /** Mail Host */
    @Value("${app.mail.host}")
    private String host;

    /** Mail Port */
    @Value("${app.mail.port}")
    private int port;

    /** Mail Username */
    @Value("${app.mail.username}")
    private String username;

    /** Mail Password */
    @Value("${app.mail.password}")
    private String password;

    /** Mail smtp auth */
    @Value("${app.mail.properties.mail.smtp.auth}")
    private boolean smtpAuth;

    /** Mail smtp starttls */
    @Value("${app.mail.properties.mail.smtp.starttls.enable}")
    private boolean starttls;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        if (isDes) {
            
            mailSender.setHost(host);
            mailSender.setPort(port);

            mailSender.setUsername(username);
            mailSender.setPassword(password);

            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", smtpAuth);
            props.put("mail.smtp.starttls.enable", starttls);
            props.put("mail.debug", "true");
            
        } else {
            mailSender.setHost(host);
            mailSender.setPort(port);
            mailSender.setProtocol("smtps");
            mailSender.setUsername(username);
            mailSender.setPassword(password);

            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtps");
            props.put("mail.smtps.auth", smtpAuth);
            props.put("mail.smtp.starttls.enable", starttls);
            props.put("mail.smtp.ssl.enable", starttls);
            props.put("mail.debug", "true");
            props.put("mail.smtps.from", username);            
        }
        
        
        return mailSender;
    }

}
