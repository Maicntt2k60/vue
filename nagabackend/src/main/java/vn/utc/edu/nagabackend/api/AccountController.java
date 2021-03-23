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

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok().body("Hello");
    }

    @RequestMapping(path = "/truc", method = RequestMethod.GET)
    public ResponseEntity<String> giaiPT(@RequestParam(name = "a") Integer a,
                                         @RequestParam(name = "b") Integer b, @RequestParam(name = "c") Integer c) {

        return ResponseEntity.ok().body(getPram(a, b, c));
    }

    public String getPram(Integer a, Integer b, Integer c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0)
                    return "Vo so nghiem";
                else return "Vo nghiem";
            } else {
                double nghiem;
                nghiem = c / b;
                return "nghiem kep " + nghiem;
            }
        } else {
            double delta;
            delta = b * b - a * c;
            if (delta < 0)
                return "vo nghiem";
            else if (delta == 0) {
                double nghiem = b / (2 * a);
                return nghiem + " ";
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                return "nghiem 1 " + x1 + "nghiem 2 " + x2;
            }
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Boolean> getDataPost(@RequestParam(name = "userName") String userName,
                                               @RequestParam(name = "password") String password) {
        if (userName.equals("admin1") && password.equals("1234561")) {
            return ResponseEntity.ok().body(Boolean.TRUE);
        }
        return ResponseEntity.ok().body(Boolean.FALSE);

    }
}
