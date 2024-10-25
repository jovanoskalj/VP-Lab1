package mk.finki.ukim.lab;

import mk.finki.ukim.lab.web.EventBookingServlet;
import mk.finki.ukim.lab.web.EventListServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class Lab1AApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab1AApplication.class, args);
    }

}
