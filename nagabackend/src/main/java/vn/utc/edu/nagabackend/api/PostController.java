package vn.utc.edu.nagabackend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.utc.edu.nagabackend.dto.PostDTO;
import vn.utc.edu.nagabackend.service.PostServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@CrossOrigin("*")
public class PostController {
    @Autowired
    private PostServiceImpl service;

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> insertData(@RequestBody PostDTO dto) {
        String value = service.insertData(dto);
        return ResponseEntity.ok().body(value);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<PostDTO>> getAllByPage(@RequestParam(name = "page", required = false) Integer page) {
        if (page == null || page < 0) {
            return ResponseEntity.ok().body(service.getAllByPage(0));
        } else {
            return ResponseEntity.ok().body(service.getAllByPage(page - 1));
        }

    }
}
