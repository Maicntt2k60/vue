package vn.utc.edu.nagabackend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.utc.edu.nagabackend.dto.PostDTO;
import vn.utc.edu.nagabackend.service.PostServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostServiceImpl service;
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> insertData(@RequestBody PostDTO dto){
        String value = service.insertData(dto);
        return ResponseEntity.ok().body(value);
    }
}
