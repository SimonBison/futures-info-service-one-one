package com.gmail.spbisoft.futuresinfoserviceoneone.repository;

import com.gmail.spbisoft.futuresinfoserviceoneone.model.FuturesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuturesRepository extends JpaRepository<FuturesModel, Integer> {
    List<FuturesModel> findByFuturesMarginLessThan(int margin);
}