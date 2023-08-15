package com.hcl.ClaimsManagementSystem.controller;

import com.hcl.ClaimsManagementSystem.entity.Claim;
import com.hcl.ClaimsManagementSystem.entity.Member;
import com.hcl.ClaimsManagementSystem.exceptions.ClaimsNotFoundException;
import com.hcl.ClaimsManagementSystem.exceptions.MemberNotFoundException;
import com.hcl.ClaimsManagementSystem.service.ClaimsManagementServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	ClaimsManagementServiceImpl claimsManagementServiceImpl;

	@GetMapping("/members")
	public ResponseEntity<List<Member>> getAllMembers() {
		logger.info("Fetching details of all members and their claims.");

		if (!claimsManagementServiceImpl.getAllMembers().isEmpty())
			return new ResponseEntity<>(claimsManagementServiceImpl.getAllMembers(), HttpStatus.OK);

		else
			throw new MemberNotFoundException("No members were found in the database");
	}

	@GetMapping("/members/{memberid}")
	public ResponseEntity<Member> getMembersById(@PathVariable long memberid) {
		logger.info("Fetching details of a member and their claims.");
		if (!claimsManagementServiceImpl.getMember(memberid).isEmpty())
			return new ResponseEntity<>(claimsManagementServiceImpl.getMember(memberid).get(), HttpStatus.OK);
		else
			throw new MemberNotFoundException("The Member was not found in the database");
	}

	@GetMapping("/members/{memberid}/claims")
	public ResponseEntity<List<Claim>> getAllClaimsByMember(@PathVariable long memberid) {
		logger.info("Fetching details of claims for a member.");
		if (!claimsManagementServiceImpl.getAllClaimsByMember(memberid).isEmpty())
			return new ResponseEntity<>(claimsManagementServiceImpl.getAllClaimsByMember(memberid),HttpStatus.OK);
		else
			throw new ClaimsNotFoundException("No claims were found associate to this member in the database");
	}

	@GetMapping("/members/{memberid}/claims/{claimId}")
	public ResponseEntity<Claim> getClaimByMember(@PathVariable long memberid, @PathVariable long claimId) {
		logger.info("Fetching details of a claim for a member.");
		if (claimsManagementServiceImpl.getClaimByMember(memberid, claimId) != null)
			return new ResponseEntity<>(claimsManagementServiceImpl.getClaimByMember(memberid, claimId),HttpStatus.OK);
		else
			throw new ClaimsNotFoundException("There is no claim associate with this claim Id for this member");

	}
	
	@GetMapping("/claims")
	public ResponseEntity<List<Claim>> getAllClaims(){
		logger.info("Fetching details of all claims present in database.");
		if(!claimsManagementServiceImpl.getAllClaims().isEmpty())
		return new ResponseEntity<>(claimsManagementServiceImpl.getAllClaims(),HttpStatus.OK);
		else 
			throw new ClaimsNotFoundException("There is no claims found in the database");

	}

	@PostMapping("/members")
	public ResponseEntity<List<Member>> createMembers(@RequestBody List<Member> members) {
		try {
			logger.info("Creating a list of members along with their claims.");
			return new ResponseEntity<>(claimsManagementServiceImpl.createMembers(members), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/member")
	public ResponseEntity<HttpStatus> createMember(@RequestBody Member member) {
		try {
			logger.info("Creating a member along with their claims.");
			claimsManagementServiceImpl.createMember(member);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/members")
	public ResponseEntity<HttpStatus> updateMember(@PathVariable long memberId, @RequestBody Member member) {
		logger.info("Updating the details of a member along with their claims.");
		if (claimsManagementServiceImpl.getMember(memberId) != null) {
			claimsManagementServiceImpl.updateMember(memberId, member);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			throw new MemberNotFoundException("The Member was not found in the database");
	}

	@PutMapping("/members/{memberId}/claim")
	public ResponseEntity<Claim> updateClaim (long memberId,long claimId, Claim claim){
		logger.info("Updating the details a claim associate with a member");
	
		if(claimsManagementServiceImpl.getClaimByMember(memberId, claimId)!=null)
			return new ResponseEntity<> (claimsManagementServiceImpl.updateClaim(memberId,claimId,claim),HttpStatus.OK);
		else 	
			throw new ClaimsNotFoundException("There is no claim associate with this claim Id for this member");
		
	}
	
	@DeleteMapping("/members/{memberId}")
	public ResponseEntity<HttpStatus> deleteMember(@PathVariable long memberId) {
		logger.info("Deleting a member along with their claims.");

		if (claimsManagementServiceImpl.getMember(memberId) != null) {
			claimsManagementServiceImpl.deleteMember(memberId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			throw new MemberNotFoundException("The Member was not found in the database");
	}

	@DeleteMapping("/members")
	public ResponseEntity<HttpStatus> deleteMembers() {
		try {
			logger.info("Deleting members along with their claims.");
			claimsManagementServiceImpl.deleteAllMembers();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
