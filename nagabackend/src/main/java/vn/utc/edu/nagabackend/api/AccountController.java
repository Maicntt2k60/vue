package vn.utc.edu.nagabackend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.utc.edu.nagabackend.dto.AccountDTO;
import vn.utc.edu.nagabackend.service.AccountServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@CrossOrigin("*")
public class AccountController {
    @Autowired
    private AccountServiceImpl service;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<AccountDTO>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Boolean> getDataPost(@RequestParam(name = "userName") String userName,
                                              @RequestParam(name = "password") String password) {
        if (userName.equals("admin1") && password.equals("1234561")){
            return ResponseEntity.ok().body(Boolean.TRUE);
        }
        return ResponseEntity.ok().body(Boolean.FALSE);

    }
}
