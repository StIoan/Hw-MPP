package com.hw3.hw3.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hw3.hw3.Model.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Integer>{
    List<Owner> findByHeightGreaterThan(int height);
    List<Owner> findByWeightGreaterThan(int weight);
}
