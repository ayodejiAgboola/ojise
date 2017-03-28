package com.aretesoft.api;

import com.aretesoft.dao.UserDao;
import com.aretesoft.model.*;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by Ayodeji.Agboola on 3/27/2017.
 */
@RestController
@RequestMapping("/ojise")
public class OjiseApi {
private UserDao userDao;
@Autowired
private JavaMailSender mailSender;
public OjiseApi(UserDao userDao){
    this.userDao=userDao;
}
@PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request){
String username = request.getUsername();
String password = BCrypt.hashpw(request.getPassword(),BCrypt.gensalt());
String email = request.getEmail();
    User user = new User(username,password,email,"0");
    userDao.save(user);
    //sendMail(userDao.findByUsername(username));
    return new RegisterResponse(userDao.findByUsername(username));
}
public void sendMail(User user){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("agboola.ayodeji.j@gmail.com");
            message.setTo(user.getEmail());
            message.setSubject("Test Ojise Mail");
            message.setText("Mail sent successfully");
            mailSender.send(message);
}

    @PostMapping("/logout")
    public void logout(HttpSession session){
        session.invalidate();
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request, HttpSession session){
    String username = request.getUsername();
    String password = request.getPassword();
    User user = userDao.findByUsername(username);
    boolean passwordIsCorrect = BCrypt.checkpw(password,user.getPassword());
    if(passwordIsCorrect){
        session.setAttribute("loginStatus", true);
        session.setAttribute("user",user);
        return new LoginResponse(user);
    }else{
        return null;
    }
    }
}