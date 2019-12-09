package honestit.akwilina.promises;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // DataSource z konfiguracji application.properties. DataSource możemy sobie wstrzykiwać
    private final DataSource dataSource;

    public SecurityConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // ziarno dla hasłowania - metoda passwordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // Ustawienia baz
   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)                 // z bazy danych MySQL
                .passwordEncoder(passwordEncoder())    // konfiguracja hasła -> wystawiamy Beana powyżej i mamy passwordEncoder
                .usersByUsernameQuery("SELECT username, password, active FROM users WHERE username = ?")      // pobierz nazwę, hasło, rolę/active poprzez nazwę użytkownika
                .authoritiesByUsernameQuery("SELECT u.username r.name FROM users u " +
                        "JOIN user_roles ur ON u.id = ur.user_id " +
                        "JOIN roles r ON ur.roles_id = r.id " +
                        "WHERE u.username = ?");
    }*/

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.jdbcAuthentication()
               .dataSource(dataSource)
               .passwordEncoder(passwordEncoder())
               .usersByUsernameQuery("SELECT username, password, active FROM users WHERE username = ?")
               .authoritiesByUsernameQuery("SELECT u.username, r.name FROM users u JOIN users_roles ur ON u.id = ur.user_id JOIN roles r ON ur.roles_id = r.id WHERE u.username = ?");
   }
}
