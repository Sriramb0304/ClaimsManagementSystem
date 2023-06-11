package com.hcl.ClaimsManagementSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.ClaimsManagementSystem.entity.Claim;
import com.hcl.ClaimsManagementSystem.entity.Member;
import com.hcl.ClaimsManagementSystem.repository.ClaimRepository;
import com.hcl.ClaimsManagementSystem.repository.MemberRepository;

@Service
public class ClaimsManagementServiceImpl implements ClaimsManagementService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	ClaimRepository claimRepository;

	@Override
	public List<Member> getAllMembers() {

		return memberRepository.findAll();
	}

	@Override
	public Optional<Member> getMember(long memberId) {

		return memberRepository.findById(memberId);
	}
	
	@Override
	public List<Claim> getAllClaims(){
		List<Claim> claims=new ArrayList<>();
		
		List<Member> members=getAllMembers();
		
		for(Member member:members) {
			List<Claim> memberClaim = member.getClaims();
			for(Claim claim :memberClaim) {
				claims.add(claim);
			}
		}
		return claims;
	}
	
	@Override
	public List<Claim> getAllClaimsByMember(long memberid) {
		Optional<Member> member = memberRepository.findById(memberid);
		if (!member.isEmpty())
			return member.get().getClaims();
		else
			return null;
	}

	@Override
	public Claim getClaimByMember(long memberId, long claimId) {
		Optional<Member> member = memberRepository.findById(memberId);
		if (!member.isEmpty()) {
			List<Claim> claims = member.get().getClaims();
			for (Claim claim : claims) {
				if (claimId == claim.getClaimsId()) {
					return claim;
				}
			}
		}
		return null;
	}
	
	@Override
	public List<Member> createMembers(List<Member> members) {
		for (Member member : members) {
			memberRepository.save(member);
			List<Claim> claims = member.getClaims();
			for (Claim claim : claims) {
				claimRepository.save(claim);
			}
		}
		return memberRepository.findAll();
	}

	@Override
	public void createMember(Member member) {
		memberRepository.save(member);
		List<Claim> claims = member.getClaims();
		for (Claim claim : claims) {
			claimRepository.save(claim);
		}

	}
	
	@Override
	public Member updateMember(long memberId, Member member) {

		if (!memberRepository.findById(memberId).isEmpty()) {
			Optional<Member> memberdata = memberRepository.findById(memberId);
			Member updatedmember = memberdata.get();
			updatedmember.setFirstName(member.getFirstName());
			updatedmember.setLastName(member.getLastName());
			updatedmember.setAge(member.getAge());
			updatedmember.setContactNumber(member.getContactNumber());
			updatedmember.setRole(member.getRole());
			updatedmember.setEmail(member.getEmail());
			updatedmember.setClaims(member.getClaims());

			memberRepository.save(updatedmember);
			return updatedmember;
		}

		return null;

	}
	
	@Override
	public Claim updateClaim(long memberId,long claimId, Claim newClaim) {
		if (!memberRepository.findById(memberId).isEmpty()) {
			Optional<Member> memberdata = memberRepository.findById(memberId);
			Member updatedmember = memberdata.get();
			Claim updatedClaim=new Claim();
			List<Claim> claims= updatedmember.getClaims();
			for(Claim claim:claims) {
				if(claim.getClaimsId()==claimId) {
					claim=newClaim;
					claimRepository.save(claim);
				}
			}
			return updatedClaim;
		}
		return null;
	}

	
	@Override
	public void deleteMember(long memberId) {
		memberRepository.deleteById(memberId);

	}

	@Override
	public void deleteAllMembers() {
		memberRepository.deleteAll();
	}

}
