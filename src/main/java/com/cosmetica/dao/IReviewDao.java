package com.cosmetica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cosmetica.entities.Review;
@Repository
public interface IReviewDao extends JpaRepository<Review, Integer>{
	@Query( value = "SELECT * FROM reviews WHERE status = 1",
			nativeQuery = true)
			List<Review> findAllClient();

}
