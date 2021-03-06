package com.cosmetica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.entities.Tag;
@Repository
public interface ITagDao extends JpaRepository<Tag, Integer>{

}
