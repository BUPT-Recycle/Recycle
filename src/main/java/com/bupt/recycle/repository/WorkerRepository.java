package com.bupt.recycle.repository;

import com.bupt.recycle.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Integer> {

    @Transactional
    @Modifying
    @Query("update Worker w set w.worker_star=?1 where w.worker_id=?2")
    int setWorkerStarById(Double workerStar,int workerId);

    Worker findByWorkerPhone(String workerPhone);
}
