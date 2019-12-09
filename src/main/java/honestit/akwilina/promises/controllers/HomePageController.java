package honestit.akwilina.promises.controllers;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "", "/home", "/index"})
public class HomePageController {

    @GetMapping
    public String getHomePage() {
        return "index";
    }
}
