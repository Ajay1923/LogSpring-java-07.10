package com.crud.demo.repository;

import com.crud.demo.model.StatisticsFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StatisticsFinalRepository extends JpaRepository<StatisticsFinal, Long> {
    
    List<StatisticsFinal> findAllByUserId(Long userId);
    
    StatisticsFinal findTopByUserIdOrderByIdDesc(Long userId);
}
