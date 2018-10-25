/**
 * 
 */
package com.natuan.demo.repositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.natuan.demo.entity.Account;
import com.natuan.demo.repository.AccountRepository;

/**
 * @author User
 * @creatdate Oct 24, 2018
 * @modifieddate Oct 24, 2018
 * @content ...
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {
        
        @Autowired
        private EntityManager entityManager;
        
        @Autowired
        private EntityManagerFactory entityMangerFactory;
        /* (non-Javadoc)
         * @see com.natuan.demo.repository.AccountRepository#getListAllAccount()
         */
        
        @Override
        public List<Account> getListAllAccount() {
                String sql = "select a from Account a";
                Query query = entityManager.createQuery(sql);
                
                return query.getResultList();
        }

        @Override
        public Account findAccountByEmailPwd(Account account) {
                String sql = "select a from Account a where a.email = :email and a.pwd = :pwd";
                Query query = entityManager.createQuery(sql);
                query.setParameter("email", account.getEmail());
                String hashPwd = DigestUtils.sha256Hex(account.getPwd());
                query.setParameter("pwd", hashPwd);
                Account accountFiltered = null;
                try {
                         accountFiltered = (Account) query.getSingleResult();
                } catch (NoResultException e) {
                        
                }

                return accountFiltered;
        }

        @Override
        @Transactional
        public int insertAccount(Account account) {
                String hashPwd = DigestUtils.sha256Hex(account.getPwd());
                EntityManager em = entityMangerFactory.createEntityManager();
                em.getTransaction().begin();
                account.setPwd(hashPwd);
                em.persist(account);
                em.getTransaction().commit();
                return account.getAccountID();
        }

        @Override
        @Transactional
        public int updateAccount(Account account) {
                String sql = "update  Account  set  email = :email, full_name = :full_name, "
                                + "pwd = :pwd, telephone_number = :telephone_number where accountid = :accountid";
                Query query = entityManager.createQuery(sql);
                query.setParameter("email", account.getEmail());
                query.setParameter("full_name", account.getFullName());
                String hashPwd = DigestUtils.sha256Hex(account.getPwd());
                query.setParameter("pwd", hashPwd);
                query.setParameter("telephone_number", account.getTelephoneNumber());
                query.setParameter("accountid", account.getAccountID());
                int rowUpdated = query.executeUpdate();
                return rowUpdated;
        }

        @Override
        @Transactional
        public int deleteAccount(int accountID) {
                String sql = "delete from Account where accountid = :accountid";
                Query query = entityManager.createQuery(sql);
                query.setParameter("accountid", accountID);
                int rowDeleted = query.executeUpdate();
                return rowDeleted;
        }

}
