package vn.utc.edu.nagabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.utc.edu.nagabackend.common.AccountEntityToDTO;
import vn.utc.edu.nagabackend.dto.AccountDTO;
import vn.utc.edu.nagabackend.entity.AccountEntity;
import vn.utc.edu.nagabackend.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Service("accountServiceImpl")
public class AccountServiceImpl {
    @Autowired
    private AccountRepository repository;

    public List<AccountDTO> getAll() {
        List<AccountDTO> dtoList = new ArrayList<>();
        List<AccountEntity> all = repository.findAll();
        for (AccountEntity entity : all) {
            dtoList.add(AccountEntityToDTO.toDTO(entity));
        }
        return dtoList;
    }
}
