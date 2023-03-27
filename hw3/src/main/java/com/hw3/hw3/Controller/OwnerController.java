package com.hw3.hw3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hw3.hw3.Model.Owner;
import com.hw3.hw3.Service.OwnerService;

@RestController
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/owners")
    public ResponseEntity<List<Owner>> getAllOwners() {
        return ResponseEntity.ok().body(ownerService.getAllOwners());
    }

    @GetMapping("/owners/{owner_id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Integer owner_id) {
        return ResponseEntity.ok().body(ownerService.getOwnerById(owner_id));
    }

    @PostMapping("/owners")
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        return ResponseEntity.ok().body(this.ownerService.createOwner(owner));
    }

    @PutMapping("/owners/{owner_id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Integer owner_id, @RequestBody Owner owner) {
        owner.setOwnerId(owner_id);
        return ResponseEntity.ok().body(this.ownerService.updateOwner(owner));
    }

    @DeleteMapping("/owners/{owner_id}")
    public HttpStatus deleteOwner(@PathVariable Integer owner_id) {
        this.ownerService.deleteOwner(owner_id);
        return HttpStatus.OK;
    }
}
