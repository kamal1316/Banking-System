package com.wellsfargo.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.onlinebanking.entity.BaseSeq;

public interface BaseSeqRepository extends JpaRepository<BaseSeq, Integer>{

}
