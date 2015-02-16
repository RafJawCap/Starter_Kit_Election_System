package com.capgemini.StarterKit.testMain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.capgemini.StarterKit.*;
import com.capgemini.StarterKit.entities.ZipCode;
import com.capgemini.StarterKit.repository.ZipCodeRepo;

public class TestRun {

	@Autowired
	private static ZipCodeRepo repo = new ZipCodeRepo() {
		
		@Override
		public <S extends ZipCode> S save(S arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public ZipCode findOne(Long arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean exists(Long arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(Iterable<? extends ZipCode> arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(ZipCode arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(Long arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Page<ZipCode> findAll(Pageable arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends ZipCode> S saveAndFlush(S arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends ZipCode> List<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public ZipCode getOne(Long arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public List<ZipCode> findAll(Iterable<Long> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<ZipCode> findAll(Sort arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<ZipCode> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void deleteInBatch(Iterable<ZipCode> arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}
	};
	
	public static void main(String[] args) {

//		ZipCode aaa = new ZipCode(10, "12-345");
//		
//		repo.saveAndFlush(aaa);
//		
//		System.out.println(repo.findAll());

	}

}
