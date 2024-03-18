package com.guner.controller;

import com.guner.entity.Product;
import com.guner.entity.UuidTest;
import com.guner.service.ProductService;
import com.guner.service.UuidTestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/uuid")
public class UuidTestController {

    private UuidTestService uuidTestService;

    // http://localhost:8080/api/uuid/1
    @GetMapping("{id}")
    public ResponseEntity<UuidTest> getUuidById(@PathVariable("id") UUID uuid){
        UuidTest uuidTest = uuidTestService.getUuidById(uuid);
        return new ResponseEntity<>(uuidTest, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<UuidTest> getUuidByDetailId(@PathVariable("id") UUID uuid){
        UuidTest uuidTest = uuidTestService.getUuidByDetailId(uuid);
        return new ResponseEntity<>(uuidTest, HttpStatus.OK);
    }

    @GetMapping("/detailString/{id}")
    public ResponseEntity<UuidTest> findByDetailByStringDetailId(@PathVariable("id") String uuidString){
        UuidTest uuidTest = uuidTestService.findByDetailByStringDetailId(uuidString);
        return new ResponseEntity<>(uuidTest, HttpStatus.OK);
    }

    // http://localhost:8080/api/products
    @GetMapping
    public ResponseEntity<List<UuidTest>> getAllUuids(){
        List<UuidTest> uuidTests = uuidTestService.getAllUuids();
        return new ResponseEntity<>(uuidTests, HttpStatus.OK);
    }

    @GetMapping("findByDetailByUuidNotUuidNill")
    public ResponseEntity<List<UuidTest>> findByDetailByUuidNotUuidNill(){
        List<UuidTest> uuidTests = uuidTestService.findByDetailByUuidNotUuidNill();
        return new ResponseEntity<>(uuidTests, HttpStatus.OK);
    }

}
