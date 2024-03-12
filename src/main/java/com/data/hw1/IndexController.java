package com.data.hw1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



 
@Controller
public class IndexController {
    /* 
    @GetMapping("/index")
    public String index() {
        return  "index";
    }
    
    @PostMapping("/register")
    public String userInput(@ModelAttribute ReplaceCharactersRequest request){
        System.out.println(request.toString());
        return "index";
    }*/
   
    
   @GetMapping("/index")
   public String viewForm(Model model) {
       model.addAttribute("request", new ReplaceCharactersRequest());
       return "index";
   }
   
    
   @PostMapping("/result")
   public String processForm(@ModelAttribute ReplaceCharactersRequest request, BindingResult result, Model model) {
        model.addAttribute("request", request);
       
       return "result";
   }
   

}
