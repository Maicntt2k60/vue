package vn.utc.edu.nagabackend.common;

import vn.utc.edu.nagabackend.dto.AccountDTO;
import vn.utc.edu.nagabackend.entity.AccountEntity;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AccountEntityToDTO {
    public static AccountDTO toDTO(AccountEntity entity){
        AccountDTO dto = new AccountDTO();
        dto.setId(entity.getId());
        dto.setUserAccount(entity.getUserAccount());
        dto.setUserFirstName(entity.getUserFirstName());
        dto.setUserLastName(entity.getUserLastName());
        dto.setUserPassword(entity.getUserPassword());
        Calendar calendar = new GregorianCalendar();
        calendar.set(2020, 1,1);
        Date date = calendar.getTime();
        return dto;
    }
}
