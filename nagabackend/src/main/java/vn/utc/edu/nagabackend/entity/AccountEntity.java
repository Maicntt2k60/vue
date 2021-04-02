package vn.utc.edu.nagabackend.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

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
    @Field("email")
    private String email;
    @Field("birth")
    private Date birth;
    @Field("user_permission")
    private Integer userPermission;
}
