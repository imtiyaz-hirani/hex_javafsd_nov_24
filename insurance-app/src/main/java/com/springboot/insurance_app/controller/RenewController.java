package com.springboot.insurance_app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RenewController {

	
	@PostMapping("/policy/renew/{pid}/{phid}/{eid}")
	public void policyRenew() {
		
		/*update policy_policyholder table with new 
		 	date_of_puchase, -- current date
		 	date_of_renewal,  --plus 1 year 
		 	premium  -- calculate based on claims 
		 	
		 	
			This info should be inserted in renewal_info table for record keeping.
		 */
	}
}
