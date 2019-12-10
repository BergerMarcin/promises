package honestit.akwilina.promises.controllers;

import honestit.akwilina.promises.dtos.RegistrationDataDTO;
import honestit.akwilina.promises.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String getRegistrationPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDataDTO());
        return "register/form";
    }
    @PostMapping
    public String postRegistrationPage(@ModelAttribute("registrationData")
                                          @Valid RegistrationDataDTO registrationData,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "register/form";
        }
        // Zaimplementować zapis użytkownika
        registrationService.register(registrationData);
        return "redirect:/";
    }

}
