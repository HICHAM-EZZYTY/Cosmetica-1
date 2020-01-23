package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cosmetica.DAO.IInvoiceHeadDao;
import com.cosmetica.Entities.InvoiceHead;
import com.cosmetica.IServices.IInvoiceHeadService;

public class InvoiceHeadService implements IInvoiceHeadService{

	@Autowired
	IInvoiceHeadDao dao;

	@Override
	public List<InvoiceHead> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<InvoiceHead> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(InvoiceHead InvoiceHead) {
		dao.save(InvoiceHead);
	}

	@Override
	public void delete(InvoiceHead InvoiceHead) {
		dao.delete(InvoiceHead);
	}
	
}