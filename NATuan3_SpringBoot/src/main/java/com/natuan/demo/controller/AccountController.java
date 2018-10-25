/**
 * 
 */
package com.natuan.demo.controller;

import java.util.List;

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
public class AccountController {

        @Autowired
        private AccountService accountService;

        @GetMapping("/account")
        public String index(ModelMap modelMap) {
                List<Account> listAccount = accountService.getListAllAccount();
                modelMap.addAttribute("listAccount", listAccount);
                return "AccountPage";
        }
        
        @PostMapping("/account/update")
        @ResponseBody
        public String updateAccount(@RequestParam int accountID, @RequestParam String fullName,
                        @RequestParam String telephoneNumber, @RequestParam String email, @RequestParam String pwd) {
                Account account = new Account();
                account.setAccountID(accountID);
                account.setEmail(email);
                account.setFullName(fullName);
                account.setTelephoneNumber(telephoneNumber);
                account.setPwd(pwd);
                boolean isUpdated = accountService.updateAccount(account);
                return ""+isUpdated;
        }
        
        @PostMapping("/account/insert")
        @ResponseBody
        public String insertAccount(@RequestParam String fullName,
                        @RequestParam String telephoneNumber, @RequestParam String email, @RequestParam String pwd) {
                Account account = new Account();
                account.setEmail(email);
                account.setFullName(fullName);
                account.setTelephoneNumber(telephoneNumber);
                account.setPwd(pwd);
                int rowInserted = accountService.insertAccount(account);
                return ""+rowInserted;
        }
        
        @PostMapping("/account/delete")
        @ResponseBody
        public String deleteAccount(@RequestParam int accountID) {
                boolean isDeleted = accountService.deleteAccount(accountID);
                return "" + isDeleted;
        }
        
}
