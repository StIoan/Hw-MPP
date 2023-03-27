package com.hw3.hw3.Service;

import java.util.List;

import com.hw3.hw3.Model.Owner;

public interface OwnerServiceInterface {
    Owner createOwner(Owner owner);
    Owner updateOwner(Owner owner);
    List<Owner> getAllOwners();
    Owner getOwnerById(Integer owner_id);
    void deleteOwner(Integer owner_id);
}
