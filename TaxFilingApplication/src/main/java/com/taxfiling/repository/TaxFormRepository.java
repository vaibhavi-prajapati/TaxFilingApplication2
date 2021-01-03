package com.taxfiling.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taxfiling.entity.TaxForm;

@Transactional
@Repository
public interface TaxFormRepository extends JpaRepository<TaxForm, Long> {

	@Modifying
	@Query("update TaxForm tf set tf.verifiedStatus='approvePending' where tf=:t")
	int fileReturn(TaxForm t);

	@Query("SELECT t FROM TaxForm t where t.pan=:pan")
	TaxForm getTaxFormByPan(String pan);

	@Modifying
	@Query("update TaxForm t set t.verifiedStatus=:status where t.taxformId=:taxformId")
	int updateTaxForm(long taxformId, String status);

	@Query("select t from TaxForm t where t.verifiedStatus='pending'")
	List<TaxForm> getTaxFormsForRepresentative();

	@Query("select t from TaxForm t where t.verifiedStatus='approvePending'")
	List<TaxForm> getTaxFormsForAdmin();
}
