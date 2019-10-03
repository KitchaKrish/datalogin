package com.datalogin.datalogin.controller;


import com.datalogin.datalogin.database.repro.reprodata;
import com.datalogin.datalogin.database.user;
import org.apache.catalina.User;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Id;
import javax.script.ScriptContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class logincontroller {
    @Autowired
    reprodata reprodata;








    @RequestMapping("/login")
            public String login(HttpServletRequest request, HttpServletResponse response) {

        if(request.getParameter("user")!=null && request.getParameter("pass")!=null)
        {
            String username=(request.getParameter("user"));
            String password=(request.getParameter("pass"));

            List<user> user = reprodata.login(username,password);
            if(user.size()!=0)
            {
                setTabToSession(request,user.get(0));
                return "search";
            }


        }
return "login";


    }

    private static final String ID="id";
    private static final String NAME="name";
    private static final String PASS="pass";
    private void setTabToSession(HttpServletRequest request,user user){
        HttpSession session=request.getSession();
        session.setAttribute(ID,user.getId());
        session.setAttribute(NAME,user.getName());
        session.setAttribute(PASS,user.getPass());
    }

    private boolean isUserDataInSession(HttpServletRequest request){
        HttpSession session=request.getSession();
        return !session.getAttribute(ID).toString().isEmpty() && !session.getAttribute(NAME).toString().isEmpty() && !session.getAttribute(PASS).toString().isEmpty();
    }

    private user getUserDataFromSession(HttpServletRequest request){

        if(isUserDataInSession(request)){
            HttpSession session=request.getSession();
            user user=new user();
            user.setId(Integer.parseInt(session.getAttribute(ID).toString()));
            user.setName(session.getAttribute(NAME).toString());
            user.setPass(session.getAttribute(PASS).toString());
            return user;
        }else{
            return null;
        }
    }





    @RequestMapping("/search")
    public String search(HttpServletRequest request)
    {
            if(request.getParameter("id")!=null)
            {
                String id=(request.getParameter("id"));
                List<user> user = reprodata.search(id);
                if(user.size()!=0) {
                    return "search";
                }
            }

        return "search";
    }
    @RequestMapping("/view")
           public String view(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) throws IOException {

                user user=getUserDataFromSession(request);
                if (user!=null) {
                    modelMap.put(ID,user.getId());
                    modelMap.put(NAME,user.getName());
                    modelMap.put(PASS,user.getPass());
                    return "view";
                }

                response.sendRedirect("/login");

                return null;
            }



}
