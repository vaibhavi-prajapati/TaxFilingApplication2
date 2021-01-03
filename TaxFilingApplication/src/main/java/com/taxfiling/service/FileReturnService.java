package com.taxfiling.service;

import java.util.List;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Notice;
import com.taxfiling.entity.Representative;
import com.taxfiling.entity.TaxForm;

public interface FileReturnService {

	public int fileReturn(TaxForm t);

	public TaxForm getTaxFromByPan(String pan);

	public Customer getCustomerById(Long id);

	List<TaxForm> getTaxFormsForRepresentative();

	public Customer getCustomerByTaxFormId(Long taxformId);

	public Representative getRepresentativeById(Long representativeID);

	public int addNotice(Notice n);

	public int updateTaxForm(long taxformId, String status);

	public Admin getAdmin();

	public List<TaxForm> getTaxFormsForAdmin();
}
