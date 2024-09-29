package io.zjc.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/foo")
public class FooController {

    @GetMapping("/t1")
    public Map<String, String> t1() {
        return Map.of("foo", "bar");
    }

}
