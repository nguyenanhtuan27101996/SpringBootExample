/**
 * 
 */
package com.natuan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class LoginController {

        @Autowired
        private AccountService accountService;
        
        @GetMapping("/login")
        public String index() {
                return "Login";
        }
        
        @PostMapping("/login")
        @ResponseBody
        public String login(@RequestParam String email, @RequestParam String pwd) {
                Account account = new Account();
                account.setEmail(email);
                account.setPwd(pwd);
                boolean isChecked = accountService.loginAccount(account);
                return "" + isChecked;
        }
}
