/**
 * 
 */
package com.natuan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.natuan.demo.entity.Account;
import com.natuan.demo.service.AccountService;

/**
 * @author User
 * @creatdate Oct 24, 2018
 * @modifieddate Oct 24, 2018
 * @content ...
 */
@Controller
public class MainController {
        @Autowired
        private AccountService accountService;
        
        @GetMapping("/")
        public String index(ModelMap modelMap) {
                return "Index";
        }
        
        @PostMapping("/register")
        @ResponseBody
        public String registerAccount(@RequestParam String email, @RequestParam String full_name, 
                        @RequestParam String pwd, @RequestParam String telephone_number) {
                Account account = new Account();
                account.setEmail(email);
                account.setFullName(full_name);
                account.setPwd(pwd);
                account.setTelephoneNumber(telephone_number);
                int rowInserted = accountService.insertAccount(account);
                return ""+rowInserted;
        }
        
}
