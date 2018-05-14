package com.bupt.recycle.repository;

import com.bupt.recycle.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {

}
