package vn.utc.edu.nagabackend.common;

import vn.utc.edu.nagabackend.dto.AccountDTO;
import vn.utc.edu.nagabackend.entity.AccountEntity;

public class AccountEntityToDTO {
    public static AccountDTO toDTO(AccountEntity entity){
        AccountDTO dto = new AccountDTO();
        dto.setId(entity.getId());
        dto.setUserAccount(entity.getUserAccount());
        dto.setUserFirstName(entity.getUserFirstName());
        dto.setUserLastName(entity.getUserLastName());
        dto.setUserPassword(entity.getUserPassword());
        return dto;
    }
}
