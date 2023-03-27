package com.hw3.hw3.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hw3.hw3.Model.Owner;
import com.hw3.hw3.Repository.OwnerRepo;
import com.hw3.hw3.Exception.Exception;

@Service
@Transactional
public class OwnerService implements OwnerServiceInterface {
    @Autowired
    private OwnerRepo ownerRepo;

    @Override
    public Owner createOwner(Owner owner) {
        if (owner.getHeight() > 0 && owner.getWeight() > 0) {
            return ownerRepo.save(owner);
        } else {
            throw new Exception("The input is wrong!");
        }
    }

    @Override
    public Owner updateOwner(Owner owner) {
        Optional<Owner> ownerDb = this.ownerRepo.findById(owner.getOwnerId());
        if (ownerDb.isPresent()) {
            Owner ownerUpdate = ownerDb.get();
            ownerUpdate.setOwnerId(owner.getOwnerId());
            ownerUpdate.setWeight(owner.getWeight());
            ownerUpdate.setName(owner.getName());
            ownerUpdate.setHeight(owner.getHeight());
            ownerUpdate.setDescription(owner.getDescription());
            ownerUpdate.setAddres(owner.getAddres());
            ownerRepo.save(ownerUpdate);
            return ownerUpdate;
        } else {
            throw new Exception("Owner not found!");
        }
    }

    @Override
    public List<Owner> getAllOwners() {
        return this.ownerRepo.findAll();
    }

    @Override
    public Owner getOwnerById(Integer owner_id) {
        Optional<Owner> ownerDb = this.ownerRepo.findById(owner_id);
        if (ownerDb.isPresent()) {
            return ownerDb.get();
        } else {
            throw new Exception("Owner not found!");
        }
    }

    @Override
    public void deleteOwner(Integer owner_id) {
        Optional<Owner> ownerDb = this.ownerRepo.findById(owner_id);
        if (ownerDb.isPresent()) {
            this.ownerRepo.delete(ownerDb.get());
        } else {
            throw new Exception("Owner not found!");
        }
    }
}
