/**
 * 
 */
package com.natuan.demo.repository;

import java.util.List;

import com.natuan.demo.entity.Account;

/**
 * @author User
 * @creatdate Oct 24, 2018
 * @modifieddate Oct 24, 2018
 * @content ...
 */
public interface AccountRepository {

        List<Account> getListAllAccount();
        
        Account findAccountByEmailPwd(Account account);
        
        int insertAccount(Account account);
        
        int updateAccount(Account account);
        
        int deleteAccount(int accountID);
}
