package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cosmetica.DAO.IInvoiceBodyDao;
import com.cosmetica.Entities.InvoiceBody;
import com.cosmetica.IServices.IInvoiceBodyService;

public class InvoiceBodyService implements IInvoiceBodyService{

	@Autowired
	IInvoiceBodyDao dao;

	@Override
	public List<InvoiceBody> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<InvoiceBody> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(InvoiceBody InvoiceBody) {
		dao.save(InvoiceBody);
	}

	@Override
	public void delete(InvoiceBody InvoiceBody) {
		dao.delete(InvoiceBody);
	}
	
}