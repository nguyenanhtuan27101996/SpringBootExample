package com.natuan.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natuan.demo.entity.Account;
import com.natuan.demo.repository.AccountRepository;
import com.natuan.demo.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

        @Autowired
        private AccountRepository accountRepository;
        @Override
        public List<Account> getListAllAccount() {
                return accountRepository.getListAllAccount();
        }
        @Override
        public boolean loginAccount(Account account) {
                Account acountFiltered = accountRepository.findAccountByEmailPwd(account);
                if (acountFiltered != null) {
                        return true;
                }
                return false;
        }
        @Override
        public int insertAccount(Account account) {
                return accountRepository.insertAccount(account);
        }
        @Override
        public boolean updateAccount(Account account) {
                int rowUpdated = accountRepository.updateAccount(account);
                if (rowUpdated == 1) {
                        return true;
                }
                return false;
        }
        @Override
        public boolean deleteAccount(int accountID) {
                int rowDeleted = accountRepository.deleteAccount(accountID);
                if (rowDeleted == 1) {
                        return true;
                }
                return false;
        }

}
