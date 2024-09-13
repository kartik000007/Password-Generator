package com.password_generator.password.controller;

import com.password_generator.password.Model.paramater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;
@Controller
public class homeContro {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("paramater", new paramater());
        return "index";
    }

    @PostMapping("/generate-password")
    public String generatePassword(@ModelAttribute paramater parm, Model model) {

        int length = parm.getLength();
        int special = parm.getSpecialCharCount();
        int num = parm.getNumberCount();

        // Validation: Ensure length is large enough to accommodate special characters and numbers
        if (length < special + num + 1) {
            model.addAttribute("error", "The total length must be at least the sum of special characters and numbers.");
            return "index";
        }

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        // Pattern: Uppercase -> Special Character -> Number -> Lowercase
        boolean addUppercase = true;
        boolean addSpecial = special > 0;
        boolean addNumber = num > 0;

        while (password.length() < length) {
            if (addUppercase && password.length() < length) {
                // Add an uppercase letter
                char upperCase = (char) (random.nextInt(26) + 'A');
                password.append(upperCase);
                addUppercase = false;
            }
            if (addSpecial && password.length() < length && special > 0) {
                // Add a special character
                char specialChar = (char) (random.nextInt(15) + 33); // Special chars from 33 to 47
                password.append(specialChar);
                special--;
                addSpecial = false;
            }
            if (addNumber && password.length() < length && num > 0) {
                // Add a number
                char number = (char) (random.nextInt(10) + '0'); // Numbers from 48 to 57
                password.append(number);
                num--;
                addNumber = false;
            }
            // Add a lowercase letter
            if (password.length() < length) {
                char lowerCase = (char) (random.nextInt(26) + 'a');
                password.append(lowerCase);
                addUppercase = true;
                addSpecial = special > 0;
                addNumber = num > 0;
            }
        }

        model.addAttribute("generatedPassword", password.toString());
        return "index";
    }
}
