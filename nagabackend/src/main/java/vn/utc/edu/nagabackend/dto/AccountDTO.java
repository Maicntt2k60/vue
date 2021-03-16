package vn.utc.edu.nagabackend.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private String id;
    private String userAccount;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
}
