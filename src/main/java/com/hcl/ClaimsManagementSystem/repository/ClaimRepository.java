package com.hcl.ClaimsManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ClaimsManagementSystem.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long>{

}
