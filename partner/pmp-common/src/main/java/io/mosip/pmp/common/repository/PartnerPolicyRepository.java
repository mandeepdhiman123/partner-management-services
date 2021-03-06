package io.mosip.pmp.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.mosip.pmp.common.entity.PartnerPolicy;

/**
 * @author Nagarjuna
 *
 */

@Repository
public interface PartnerPolicyRepository extends JpaRepository<PartnerPolicy, String> {

	@Query(value = "select * from partner_policy ppr where ppr.part_id=?1 and ppr.policy_id=?2", nativeQuery = true )
	public PartnerPolicy findByPartnerId(String partId, String policyId);
	
	@Query(value = "select * from partner_policy ppr where ppr.policy_api_key=?", nativeQuery = true )
	public PartnerPolicy findByApiKey(String policy_api_key);
	
	@Query(value = "select * from partner_policy ppr where ppr.part_id=?", nativeQuery = true )
	public PartnerPolicy findByPartnerId(String partId);
}

