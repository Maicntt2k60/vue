package vn.utc.edu.nagabackend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AccountDTO {
    private String id;
    private String userAccount;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
    private Date birth;
    private String email;
}
