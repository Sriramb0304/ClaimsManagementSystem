package com.hcl.ClaimsManagementSystem.service;

import java.util.List;
import java.util.Optional;

import com.hcl.ClaimsManagementSystem.entity.Claim;
import com.hcl.ClaimsManagementSystem.entity.Member;

public interface ClaimsManagementService {

	 List <Member> getAllMembers();
	 
	 Optional<Member> getMember(long memberId);

	 List<Member> createMembers(List<Member> members);
	 
	 void createMember(Member member);
	 
	 Member updateMember(long memberId,Member member);

	 Claim updateClaim (long memberId,long claimId,Claim claim);

	 List<Claim> getAllClaims();
	 
	 void deleteMember(long memberId);
	 
	 void deleteAllMembers();
	 
	 List<Claim> getAllClaimsByMember(long memberId);
	
	 Claim getClaimByMember(long memberId,long claimId);
	 
}
