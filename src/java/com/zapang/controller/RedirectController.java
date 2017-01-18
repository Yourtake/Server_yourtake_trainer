package com.zapang.controller;



import com.zapang.backend.EmailService;
import com.zapang.model.pojo.Client;
import com.zapang.model.pojo.Reply;
import com.zapang.service.AdminMaintainService;
import com.zapang.test.AdvancedTest;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class RedirectController {
    private String ownerEmailId="support@zapang.com";
@Autowired
AdminMaintainService adminMaintain;


    public RedirectController() {
    }
    
      @RequestMapping(value="/feedback/response",method=RequestMethod.POST)
        public ModelAndView response(HttpServletRequest request ,HttpServletResponse response) {
           
            ModelAndView model=null;
//            Cookie[] cookieList = request.getCookies();
            boolean alreadyVisited=false;
//            for(Cookie cookie:cookieList){
//                if(cookie.getName().equals("val")&&cookie.getValue().equals(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))){
//                    alreadyVisited=true;
//                }
//            }

            List<Client> clientList=adminMaintain.getSpecificData(request.getParameter("name"), request.getParameter("number"),request.getParameter("email"), request.getParameter("date"),request.getParameter("ipaddress"));
            if(clientList!=null&&!clientList.isEmpty()){
                    alreadyVisited=true;
            }

          System.out.println("Got a request");
          
          
          
            if(!alreadyVisited){
            Client client = new Client();
            client.setEmailId(request.getParameter("email"));
            client.setName(request.getParameter("name"));
            client.setPhoneNumber(request.getParameter("number"));
            if(request.getParameter("ipaddress")!=null){
                client.setIpAddress(request.getParameter("ipaddress"));
            }
            else{
                
                client.setIpAddress(request.getRemoteAddr());
            }
//            client.setIpAddress(request.getRemoteAddr());
            List<Reply> replyList = new ArrayList<>();
            replyList.add(new Reply("rating","relevance",request.getParameter("relevance"),client));
            replyList.add(new Reply("rating","materials",request.getParameter("materials"),client));
            replyList.add(new Reply("rating","instructions",request.getParameter("instructions"),client));
            replyList.add(new Reply("rating","expectations",request.getParameter("expectations"),client));
            replyList.add(new Reply("rating","length",request.getParameter("length"),client));
            replyList.add(new Reply("rating","presentation",request.getParameter("presentation"),client));
            replyList.add(new Reply("rating","content",request.getParameter("content"),client));
            replyList.add(new Reply("descriptive","enjoy",request.getParameter("enjoy"),client));
            replyList.add(new Reply("descriptive","learn",request.getParameter("learn"),client));
            replyList.add(new Reply("descriptive","implement",request.getParameter("implement"),client));
            if(request.getParameter("date")!=null){
                client.setDate(request.getParameter("date"));
            }
            else{
                client.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            }
                client.setReply(replyList);
              System.out.println("Save client");
            if(adminMaintain.makeClient(client)!=null){
                Float relevance= Float.parseFloat(request.getParameter("relevance"));
                Float materials= Float.parseFloat(request.getParameter("materials"));
                Float instructions= Float.parseFloat(request.getParameter("instructions"));
                Float expectations= Float.parseFloat(request.getParameter("expectations"));
                Float length= Float.parseFloat(request.getParameter("length"));
                Float presentation= Float.parseFloat(request.getParameter("presentation"));
                Float content= Float.parseFloat(request.getParameter("content"));
                boolean bad=false;
                boolean awesome=false;
                if((relevance+materials+instructions+expectations+length+presentation+content)<=18){
                    bad=true;
                }
                if((relevance+materials+instructions+expectations+length+presentation+content)>=28){
                    awesome=true;
                }
                if(bad){
                        adminMaintain.sendBadClientEmailAndSMSUpdate(request.getParameter("email"),request.getParameter("number"),request.getParameter("name"));
                   // adminMaintain.sendEmployeeEmailUpdate(request.getParameter("email"), "Name : "+request.getParameter("name")+", Email Id : "+request.getParameter("email")+", Number : "+request.getParameter("number"));
                }
                else if(awesome){
                      adminMaintain.sendGoodClientEmailAndSMSUpdate(request.getParameter("email"),request.getParameter("number"),request.getParameter("name"));
              
                }
                else{
                          adminMaintain.sendOkayClientEmailAndSMSUpdate(request.getParameter("email"),request.getParameter("number"),request.getParameter("name"));
              
                  }
//                  Cookie myCookie =new Cookie("val", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//                  response.addCookie(myCookie);
                        model= new ModelAndView("thankyou");
                        model.addObject("message", "Thank You");
                    }
            else{
                 model= new ModelAndView("feedback");
                 model.addObject("message", "Our people seems to be busy can you try again?");
            }
            }
            else{
                  model= new ModelAndView("thankyou");
                        model.addObject("message", "Thank You");
            }
            return model;
        }
    
  
  @RequestMapping(value="/")
    public ModelAndView init(HttpSession session,HttpServletRequest request){
    return new ModelAndView("home");
    }
      
  @RequestMapping(value="/index.htm")
    public ModelAndView initAlias(HttpSession session,HttpServletRequest request) {
    return new ModelAndView("home");
    }
   @RequestMapping(value="/feedback")
    public ModelAndView feedback(HttpSession session,HttpServletRequest request) {
        ModelAndView model= new ModelAndView("feedback");
//        Cookie[] cookieList = request.getCookies();
//            boolean alreadyVisited=false;
//            for(Cookie cookie:cookieList){
//                if(cookie.getName().equals("val")&&cookie.getValue().equals(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))){
//                    alreadyVisited=true;
//                }
//            }
//            if(alreadyVisited){
//           model= new ModelAndView("thankyou");
//                        model.addObject("message", "Thank You");
//            }
    return model;
    } 
     @RequestMapping(value="/menu")
    public ModelAndView menu(HttpSession session,HttpServletRequest request) {
    return new ModelAndView("menu");
    } 
     @RequestMapping(value="/new")
    public ModelAndView newDisplay(HttpSession session,HttpServletRequest request) {
    return new ModelAndView("new");
    } 
     @RequestMapping(value="/facts")
    public ModelAndView facts(HttpSession session,HttpServletRequest request) {
    return new ModelAndView("facts");
    } 
      @PostConstruct
    public void init() {
        AdvancedTest.main(null);
    }
}
