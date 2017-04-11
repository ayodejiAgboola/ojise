package com.aretesoft.api;

import com.aretesoft.dao.BidDao;
import com.aretesoft.dao.JobDao;
import com.aretesoft.dao.UserDao;
import com.aretesoft.model.*;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Ayodeji.Agboola on 3/27/2017.
 */
@RestController
@RequestMapping("/ojise")
public class OjiseApi {
private UserDao userDao;
private JobDao jobDao;
private BidDao bidDao;
@Autowired
private JavaMailSender mailSender;
public OjiseApi(UserDao userDao, JobDao jobDao, BidDao bidDao){
    this.userDao=userDao;
    this.jobDao=jobDao;
    this.bidDao=bidDao;
}
@PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request){
String username = request.getUsername();
String password = BCrypt.hashpw(request.getPassword(),BCrypt.gensalt());
String email = request.getEmail();
String userType = request.getUserType();
    User user = new User(username,password,email,"0",userType);
    userDao.save(user);
    sendMail(userDao.findByUsername(username),"Your account has been verified");
    return new RegisterResponse(userDao.findByUsername(username));
}
public void sendMail(User user, String content){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("agboola.ayodeji.j@gmail.com");
            message.setTo(user.getEmail());
            message.setSubject("Test Ojise Mail");
            message.setText(content);
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
        session.setAttribute("user",user.getId());
        return new LoginResponse(user);
    }else{
        return null;
    }
    }
    @PostMapping("/jobs")
    public List<Job> listJobs(){
        return (List<Job>) jobDao.findAll();
    }
    @PostMapping("/jobs/{category}")
    public List<Job> listJobsbyCategory(@PathVariable String category){
        return (List<Job>) jobDao.findByCategory(category);
    }
    @PostMapping("jobs/{client}")
    public List<Job> listJobsbyClient(@PathVariable String client){
        return (List<Job>)jobDao.findByClient(client);
    }
    @PostMapping("/postjob")
    public PostJobResponse postJob(@RequestBody PostJobRequest request, HttpSession session){
        Job job = new Job(request.getTitle(),request.getDescription(),session.getAttribute("user").toString(),new Date().toString(),request.getExpectedCompleteDate(),request.getExpectedPrice(),request.getCategory());
        jobDao.save(job);
        return new PostJobResponse(job);
           }
     @PostMapping("/makebid")
    public MakeBidResponse makeBid(@RequestBody MakeBidRequest makeBidRequest, HttpSession session){
        Job job = jobDao.findById(makeBidRequest.getJobId());
        if (!job.getId().isEmpty()){
            Bid bid = new Bid(makeBidRequest.getJobId(),session.getAttribute("user").toString(),makeBidRequest.getBidDate(),makeBidRequest.getBidAmount(),makeBidRequest.getBidCompleteDate());
            bidDao.save(bid);
            sendMail(userDao.findById(job.getClient()),"Your job has been bidded for");
            return new MakeBidResponse(bid);
        }else {
            return null;
        }
    }
    @PostMapping("/listbids/{jobid}")
    public List<Bid> listBidsByJobId(@PathVariable String jobId){
        return bidDao.findByJobId(jobId);
    }
    @PostMapping("confirmbid/{bidid}")
    public Job confirmBid(@PathVariable String bidid){
        Bid bid  = bidDao.findById(bidid);
        Job job = jobDao.findById(bid.getJobId());
        if (!job.getId().isEmpty()){
            job.setFreelancer(bid.getBidderId());
            job.setAssignedDate(new Date().toString());
            job.setPrice(bid.getBidAmount());
            jobDao.save(job);
            sendMail(userDao.findById(bid.getBidderId()),"Your bid has been approved");
        }
        return job;
    }
    @PostMapping("confirm/{userid}")
    public User confirmUser(@PathVariable String userId){
        User user=userDao.findById(userId);
        user.setActive("1");
        return user;
    }
    /*@PostMapping("editUser")
    public User editUser(@RequestBody EditUserRequest request){}*/
}
