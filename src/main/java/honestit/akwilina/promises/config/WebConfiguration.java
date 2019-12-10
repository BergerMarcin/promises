package honestit.akwilina.promises.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfiguration implements WebMvcConfigurer {

    // Fakultatywne przekieranie ścieżki "/login" na "login.jsp" (zastępuje w całości LoginController.java, bo jest tam
    // tylko 1 metoda przekierowująca przez GET na formularz; natomiast POST z formularza jest obsługiwana przez
    // Security zgodnie z SecurityConfiguration.java metodą void configure(HttpSecurity http) i
    // http.authorizeRequests().....formLogin())
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
    }
}
