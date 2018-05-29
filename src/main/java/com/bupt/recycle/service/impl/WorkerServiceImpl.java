package com.bupt.recycle.service.impl;

import com.bupt.recycle.entity.Worker;
import com.bupt.recycle.repository.WorkerRepository;
import com.bupt.recycle.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.jvm.hotspot.jdi.DoubleValueImpl;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */

@Service
@Transactional
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    @Override
    public Worker register(Worker worker) {

        return workerRepository.save(worker);
    }

    @Override
    public void login() {

    }

    @Override
    public int star(Double star, int workerId) {
        workerRepository.setWorkerStarById(star,workerId);
        return 0;
    }

    @Override
    public Object getWorker(int workerId) {

        return workerRepository.findById(workerId).orElse(null);
    }
}
