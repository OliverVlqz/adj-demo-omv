package mx.edu.utez.server.modules.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/adj-api/test")
public class TestController {
    @GetMapping("")
    public ResponseEntity<?>getResponse(){
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "Api funcionando");
        response.put ("data", "OK");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

