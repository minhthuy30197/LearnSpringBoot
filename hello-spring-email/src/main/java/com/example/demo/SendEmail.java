package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
public class SendEmail {
    @Autowired
    public JavaMailSender emailSender;

    @GetMapping("/send-simple-email")
    public String sendSimpleEmail() {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("abc@gmail.com");
        message.setSubject("Test Simple Email");
        message.setText("Hello World");

        // Send Message!
        emailSender.send(message);

        return "Email Sent!";
    }

    @GetMapping("/send-attachment-email")
    public String sendAttachmentEmail() throws MessagingException {
        // Create a Mime MailMessage.
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("abc@gmail.com");
        helper.setSubject("Test Attachment Email");
        helper.setText("Hello World");

        // Add attachment
        FileSystemResource file = new FileSystemResource(new File( System.getProperty("user.dir") + "\\src\\main\\resources\\static\\avatar.png"));
        helper.addAttachment(file.getFilename(), file);

        // Send Message!
        emailSender.send(message);

        return "Email Sent!";
    }

    @GetMapping("/send-html-email")
    public String sendHtmlEmail() throws MessagingException {
        // Create a Mime MailMessage.
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("abc@gmail.com");
        helper.setSubject("Test Html Email");

        // Add html content
        String htmlMsg = "<h1 style=\"color:green\">Hello World</h1> <img src='http://www.apache.org/images/asf_logo_wide.gif'>";
        message.setContent(htmlMsg, "text/html");

        // Send Message!
        emailSender.send(message);

        return "Email Sent!";
    }

    @GetMapping("/send-template-email")
    public String sendTemplateEmail() throws MessagingException {
        // Create a Mime MailMessage.
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("abc@gmail.com");
        helper.setSubject("Test Template Email");

        // Prepare the evaluation context
        final Context context = new Context();
        context.setVariable("name", "Bui Nhu Lac");
        context.setVariable("project_name", "spring-email-with-thymeleaf Demo");

        // Create the HTML body using Thymeleaf
        final String htmlContent = SpringMailConfig.getTemplateEngine().process("mail-template.html", context);
        message.setContent(htmlContent, "text/html");

        // Send Message!
        emailSender.send(message);

        return "Email Sent!";
    }

}
