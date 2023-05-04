package com.benezeth.MockinApp.controller;

import com.benezeth.MockinApp.entity.Mkwama;
import com.benezeth.MockinApp.exception.MkwamaException;
import com.benezeth.MockinApp.repository.Mkwamarepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/api/mkwama_info")
public class MkwamaController<UserDetails> {
    @Autowired
    private Mkwamarepository mkwamaRepository;
    private Mkwama getUser;
    private Object userDetails;
    private Mkwama updateUser;

    @GetMapping
    public List<Mkwama>getAlluser(){
        return mkwamaRepository.findAll();}

        //code for creating user

     @PostMapping
     public Mkwama createMkwama (@RequestBody Mkwama mkwama){
        return mkwamaRepository.save(mkwama);
     }
     @GetMapping("{id}")
    public ResponseEntity<Mkwama>getUserById(@PathVariable long id)
     {
         Mkwama getMkwama=mkwamaRepository.findById(id).orElseThrow(()->new MkwamaException("user does not exit"));
    return ResponseEntity.ok(getUser);
     }
@PutMapping("{id}")
    public ResponseEntity<Mkwama>updateUser(@PathVariable Long id,@RequestBody Mkwama UserDetails ) {
        Mkwama UpdateUser=mkwamaRepository.findById(id).orElseThrow(()->new MkwamaException("User does not exist"));
        UpdateUser.setUserId(UserDetails.getUserId());
        UpdateUser.setUserPhoneNo(UserDetails.getUserPhoneNo());
        UpdateUser.setUserJob(UserDetails.getUserJob());
        UpdateUser.setUserName(UserDetails.getUserName());
        UpdateUser.setUserAddress(UserDetails.getUserAddress());

        mkwamaRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);

}
}
