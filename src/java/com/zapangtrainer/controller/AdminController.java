package com.zapangtrainer.controller;



import com.zapangtrainer.model.pojo.Admin;
import com.zapangtrainer.model.pojo.Client;
import com.zapangtrainer.model.pojo.Reply;
import com.zapangtrainer.service.AdminMaintainService;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminController {
@Autowired
AdminMaintainService adminMaintain;


    public AdminController() {
    }
    
    @RequestMapping(value="/logout")
    public ModelAndView redirectLogOut(HttpSession session,HttpServletRequest request,Principal principal) {
      SecurityContextHolder.getContext().setAuthentication(null);
        session.invalidate();
        
        return new ModelAndView("redirect:/adminlogin");
    }
        @RequestMapping(value = "/adminlogin")
	public  ModelAndView adminLogin(HttpServletRequest request,Principal principal) {
              
            return new ModelAndView("adminlogin");
              
	}
        @RequestMapping(value = "/admin")
	public  ModelAndView adminLoginCheck(HttpServletRequest request,Principal principal) {
             
            ModelAndView model= new ModelAndView("adminpage");
            model.addObject("admin",adminMaintain.checkPresence(new Admin(principal.getName())));
            model.addObject("relevance",adminMaintain.getAverage("relevance"));
            model.addObject("materials",adminMaintain.getAverage( "materials"));
            model.addObject("instructions",adminMaintain.getAverage( "instructions"));
            model.addObject("expectations",adminMaintain.getAverage( "expectations"));
            model.addObject("length",adminMaintain.getAverage("length"));
            model.addObject("presentation",adminMaintain.getAverage( "presentation"));
            model.addObject("content",adminMaintain.getAverage( "content"));
           
            model.addObject("relevance_stat",adminMaintain.getAverageOnDate("relevance", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            model.addObject("materials_stat",adminMaintain.getAverageOnDate("materials", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            model.addObject("instructions_stat",adminMaintain.getAverageOnDate("instructions", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            model.addObject("expectations_stat",adminMaintain.getAverageOnDate("expectations", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            model.addObject("length_stat",adminMaintain.getAverageOnDate("length", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            model.addObject("presentation_stat",adminMaintain.getAverageOnDate("presentation", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            model.addObject("content_stat",adminMaintain.getAverageOnDate("content", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            
            
             model.addObject("nps",adminMaintain.getNPS());
              model.addObject("prom",adminMaintain.getProm());
            model.addObject("pass",adminMaintain.getPass());
              model.addObject("det",adminMaintain.getDet());
              
              model.addObject("client", adminMaintain.getData());
             model.addObject("total", adminMaintain.getTodayCount());
            return model;
	}
      
          @RequestMapping(value = "/admin/past/7/{type}")
	public  ModelAndView adminPast7(@PathVariable("type") String type,HttpServletRequest request,Principal principal) {
             
            ModelAndView model= new ModelAndView("adminpast7");
         
                Calendar cal = Calendar.getInstance();
              model.addObject("t0",adminMaintain.getAverageOnDate(type, new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime())) );
              cal.add(Calendar.DATE, -1); 
                 model.addObject("t1",adminMaintain.getAverageOnDate(type,  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime())));
                 cal.add(Calendar.DATE, -1); 
                 model.addObject("t2",adminMaintain.getAverageOnDate(type,  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime())));
                 cal.add(Calendar.DATE, -1); 
                 model.addObject("t3",adminMaintain.getAverageOnDate(type,  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime())));
                 cal.add(Calendar.DATE, -1); 
                 model.addObject("t4",adminMaintain.getAverageOnDate(type,  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime())));
                 cal.add(Calendar.DATE, -1); 
                 model.addObject("t5",adminMaintain.getAverageOnDate(type,  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime())));
                 cal.add(Calendar.DATE, -1); 
                 model.addObject("t6",adminMaintain.getAverageOnDate(type,  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime())));
                 model.addObject("subject",type);
            return model;
	}
     
       
        
        @RequestMapping(value = "/admin/settings")
	public  ModelAndView adminSettings(HttpServletRequest request,Principal principal) {
              
            ModelAndView model= new ModelAndView("adminsettings");
            if(request.getParameter("msg")!=null){
                if(request.getParameter("msg").toString().equals("true")){
                     model.addObject("message","Changed."); 
                } 
                else if(request.getParameter("msg").toString().equals("false")){
                    model.addObject("message","Not changed. Please try again!"); 
                } 
             }
            model.addObject("admin",adminMaintain.checkPresence(new Admin(principal.getName())));
            return model;
	}
        
       @RequestMapping(value = "/admin/settings/change_pswrd")
	public  ModelAndView adminChangePassword(HttpServletRequest request,Principal principal) {
                
                 Admin admin=adminMaintain.checkPresence(new Admin(principal.getName()));
                Md5PasswordEncoder encoder = new Md5PasswordEncoder();
                String temPassword=encoder.encodePassword(request.getParameter("oldpassword"), null);
                 encoder=null;
                 if(admin.getPassword().equals(temPassword)&&request.getParameter("newpassword").equals(request.getParameter("rnewpassword"))){
                     
                     if(request.getParameter("newpassword").length()>=6){
                     if(adminMaintain.setPassword(admin,request.getParameter("newpassword"))){
                         admin=null;
                            return new ModelAndView("redirect:/admin/settings?msg=true"); 
                     }
                     }
                 }
                 admin=null;
            return new ModelAndView("redirect:/admin/settings?msg=false"); 
            
          
             
           
	}
       
     
     @RequestMapping(value = "/admin/assign_admin", method = RequestMethod.POST)
    public ModelAndView assignAdmin(Principal principal,HttpServletRequest request) {
 Admin admin =adminMaintain.checkPresence(new Admin(principal.getName()));
                 if(adminMaintain.buildEmployee(request.getParameter("username"),request.getParameter("name"),request.getParameter("work"),principal.getName())){
                  
                     return new ModelAndView("redirect:/admin/hr?msg=true"); 
                     
                 }
                 
            return new ModelAndView("redirect:/admin/hr?msg=false"); 
              
         
    }
    
    
    @RequestMapping(value = "/admin/hr/delete/{username}", method = RequestMethod.GET)
    public ModelAndView deleteAdmin(@PathVariable("username") String username,Principal principal,HttpServletRequest request) {
 Admin destructor =adminMaintain.checkPresence(new Admin(principal.getName()));
     
              if(adminMaintain.checkPresence(new Admin(username.replace("$", "."))).getPower()>destructor.getPower()){
                    destructor=null;
                    
                 if(adminMaintain.deleteEmployee(new Admin(username.replace("$", ".")))){
                  return new ModelAndView("redirect:/admin/hr?msg=true"); 
                     
                 }
                 
                return new ModelAndView("redirect:/admin/hr?msg=false"); 
               }
             else{
                return new ModelAndView("redirect:/admin"); 

            }
         
    }
    @RequestMapping(value = "/admin/hr")
	public  ModelAndView adminHr(HttpServletRequest request,Principal principal) {
              Admin admin =adminMaintain.checkPresence(new Admin(principal.getName()));
                 
            ModelAndView model= new ModelAndView("adminhr");
             if(request.getParameter("msg")!=null){
                if(request.getParameter("msg").equals("true")){
                     model.addObject("message","Processed."); 
                } 
                else if(request.getParameter("msg").equals("false")){
                    model.addObject("message","Not processed. Please try again!"); 
                } 
             }
            model.addObject("admin_list",adminMaintain.getHrList(admin.getPower()));
            model.addObject("admin",admin);
             admin=null; 
            return model;
             
	}
     
    
}
