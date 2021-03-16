package vn.utc.edu.nagabackend.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("account")
@Data
public class AccountEntity {
    @Id
    private String id;
    @Field("user_account")
    private String userAccount;
    @Field("user_password")
    private String userPassword;
    @Field("user_first_name")
    private String userFirstName;
    @Field("user_last_name")
    private String userLastName;
}
