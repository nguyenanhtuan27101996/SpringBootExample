/**
 * 
 */
package com.natuan.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author User
 * @creatdate Oct 24, 2018
 * @modifieddate Oct 24, 2018
 * @content ...
 */
@Entity
@Table(name="Account")
public class Account {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="AccountID")
        private int accountID;
        
        @Column(name="full_name")
        private String fullName;
        
        @Column(name="telephone_number")
        private String telephoneNumber;
        
        
        @Column(name="Email", unique=true)
        private String email;
        
        @Column(name="Pwd")
        private String pwd;

        public Account(int accountID, String fullName, String telephoneNumber, String email, String pwd) {
                super();
                this.accountID = accountID;
                this.fullName = fullName;
                this.telephoneNumber = telephoneNumber;
                this.email = email;
                this.pwd = pwd;
        }

        public Account() {
                super();
        }

        public int getAccountID() {
                return accountID;
        }

        public void setAccountID(int accountID) {
                this.accountID = accountID;
        }

        public String getFullName() {
                return fullName;
        }

        public void setFullName(String fullName) {
                this.fullName = fullName;
        }

        public String getTelephoneNumber() {
                return telephoneNumber;
        }

        public void setTelephoneNumber(String telephoneNumber) {
                this.telephoneNumber = telephoneNumber;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPwd() {
                return pwd;
        }

        public void setPwd(String pwd) {
                this.pwd = pwd;
        }
        
        
}
