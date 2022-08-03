package com.example.springbootasm.api;

import com.example.springbootasm.entity.dto.AccoutRegisterDto;
import com.example.springbootasm.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@RequiredArgsConstructor
public class AccountController {
    final AccountService accountService;
    @RequestMapping(path = "register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody AccoutRegisterDto accoutRegisterDto){
        return ResponseEntity.ok(accountService.register(accoutRegisterDto));
    }
    //    @RequestMapping(path = "login", method = RequestMethod.POST)
//    public ResponseEntity<?> login(@RequestBody AccountLoginDto accountLoginDto){
//        return ResponseEntity.ok(accountService.login(accountLoginDto));
//    }
    @RequestMapping(method = RequestMethod.GET)
    public String getInformation(){
        return "";
    }
}