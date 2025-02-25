package com.codegnan.cgecom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codegnan.cgecom.model.User;
import com.codegnan.cgecom.service.iface.UserService;
import com.codegnan.cgecom.service.impl.EmailService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	 @Autowired
	    private EmailService emailService;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Display list of users
    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list"; // JSP page to list users
    }

    // Show user creation form
    @GetMapping("/create")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User()); // For binding form input
        return "user-create"; // JSP page to create a new user
    }

   @PostMapping("/create")
    public String createUser(@ModelAttribute User user, Model model) {
        try {
            // Delegate user creation to the service layer
            userService.createUser(user.getUsername(), user.getPassword(), user.getRole(), user.getPhone_number(), user.getEmail());
            return "redirect:/login"; // Redirect on success
        } catch (RuntimeException e) {
            // Handle the exception gracefully and return to the registration page
            model.addAttribute("error", e.getMessage());
            return "user-create";
        }
    }
    
    

    

    // Show user edit form
    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user); // Populate form with existing user data
        return "user-edit"; // JSP page to edit the user
    }

    // Handle user update form submission
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute User user) {
        userService.updateUser(id, user.getUsername(), user.getPassword(), user.getRole(),user.getPhone_number(),user.getEmail());
        return "redirect:/users"; // After updating, redirect to user list
    }

    // Handle user deletion
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users"; // After deleting, redirect to user list
    }
}
