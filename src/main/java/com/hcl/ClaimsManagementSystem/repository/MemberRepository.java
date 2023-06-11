package com.hcl.ClaimsManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ClaimsManagementSystem.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

}
