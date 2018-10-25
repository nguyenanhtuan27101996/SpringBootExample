/**
 * 
 */
package com.natuan.demo.service;

import java.util.List;

import com.natuan.demo.entity.Account;

/**
 * @author User
 * @creatdate Oct 24, 2018
 * @modifieddate Oct 24, 2018
 * @content ...
 */
public interface AccountService {
        List<Account> getListAllAccount();
        
        boolean loginAccount(Account account);
        
        int insertAccount(Account account);
        
        boolean updateAccount(Account account);
        
        boolean deleteAccount(int accountID);
}
