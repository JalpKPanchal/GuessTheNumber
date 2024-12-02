package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.entity.UserEntity;
import com.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    private Random random = new Random();

    // Displays the login page
//    @GetMapping("/")
//    public String loginPage() {
//        return "login"; // Maps to login.jsp
//    }

    // Handles user login
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            session.setAttribute("loggedUser", user.get());
            return "home"; // Redirects to home page after successful login
        } else {
            model.addAttribute("error", "Invalid email or password!");
            return "login";
        }
    }

    // Displays the signup page
//    @GetMapping("/signup")
//    public String signupPage() {
//        return "signup";
//    }

    // Handles user signup
    @PostMapping("/signup")
    public String signup(
        @RequestParam String firstName,
        @RequestParam String email,
        @RequestParam String password,
        Model model
    ) {
        // Check if the email is already registered
        if (userRepository.findByEmail(email).isPresent()) {
            model.addAttribute("error", "Email already registered!");
            return "signup";
        }

        // Create and save the new user
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreditPoints(500); // Initial credit points
        userRepository.save(user);

        return "login"; // Redirect to login page
    }

    // Displays the home page
    @GetMapping("/home")
    public String homePage(HttpSession session, Model model) {
        UserEntity user = (UserEntity) session.getAttribute("loggedUser");
        if (user == null) {
            return "login"; // Redirect to login if not authenticated
        }
        model.addAttribute("user", user);
        return "home"; // Maps to home.jsp
    }

    // Handles the play game logic
    @PostMapping("/play")
    public String playGame(@RequestParam int guessedNumber, HttpSession session, Model model) {
        UserEntity user = (UserEntity) session.getAttribute("loggedUser");
        if (user == null) {
            return "login"; // Redirect to login if not authenticated
        }

        int randomNumber = random.nextInt(10) + 1; // Generate random number between 1-10

        // Game logic
        if (guessedNumber == randomNumber) {
            user.setCreditPoints(user.getCreditPoints() + 100);
            model.addAttribute("message", "🎉 Congratulations! You guessed it right!");
        } else {
            user.setCreditPoints(user.getCreditPoints() - 10);
            model.addAttribute("message", "❌ Wrong guess! The correct number was " + randomNumber);
        }

        userRepository.save(user); // Update user points
        session.setAttribute("loggedUser", user); // Update session
        model.addAttribute("user", user);
        return "home"; // Return to home.jsp
    }

    // Displays the leaderboard
    @GetMapping("/leaderboard")
    public String leaderboard(Model model) {
        List<UserEntity> users = userRepository.findAll();
        // Sort users by credit points in descending order
        users.sort((u1, u2) -> Integer.compare(u2.getCreditPoints(), u1.getCreditPoints()));
        if (users.isEmpty()) {
            model.addAttribute("error", "No users found in the leaderboard!");
        }
        model.addAttribute("users", users);
        return "leaderboard"; // Maps to leaderboard.jsp
    }
}
