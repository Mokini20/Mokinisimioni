package com.benezeth.MockinApp.controller;

import com.benezeth.MockinApp.entity.VillageEntity;
import com.benezeth.MockinApp.exception.VillageException;
import com.benezeth.MockinApp.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/village_info")
@SuppressWarnings("ALL")
public class VillageController {
    @Autowired
    private VillageRepository villageRepository;
    private com.benezeth.MockinApp.entity.VillageEntity VillageEntity;

    //code for getting all user info
    @GetMapping
    public List<VillageEntity>getAllUser(){
        return villageRepository.findAll();
    }
    @PostMapping
    public VillageEntity CreateUser
            (@RequestBody VillageEntity villageEntity){
        return villageRepository.save(VillageEntity);
    }
@GetMapping("{id}")
    public ResponseEntity<VillageEntity>GetUserById(@PathVariable Long id){
        VillageEntity getUser=villageRepository.findById(id).orElseThrow(()->new VillageException("user does not exist"));
        return ResponseEntity.ok(getUser);}
        @PutMapping("{id}")
    public ResponseEntity<VillageEntity>UpdateUser(@PathVariable Long id,@RequestBody VillageEntity UserDetails){
VillageEntity UpdateUser=villageRepository.findById(id).orElseThrow(()->new VillageException("User does not exit"));
UpdateUser.setUserId(UserDetails.getUserId());
UpdateUser.setUserAddress(UserDetails.getUserAddress());
UpdateUser.setUserJob(UserDetails.getUserJob());
UpdateUser.setUserName(UserDetails.getUserName());
UpdateUser.setUserPhoneNo(UserDetails.getUserPhoneNo());
villageRepository.save(UpdateUser);
return ResponseEntity.ok(UpdateUser);

}
    @DeleteMapping("{id}")
    public ResponseEntity<VillageEntity>deleteUser(long id){
        VillageEntity user=villageRepository.findById(id).orElseThrow(()->new VillageException("User does not Exist"));
        villageRepository.delete(user);
        return ResponseEntity.ok(user);
    }
}
