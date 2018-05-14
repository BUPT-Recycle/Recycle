package com.bupt.recycle.repository;

import com.bupt.recycle.entity.Worker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class WorkerRepositoryTest {

    @Autowired
    WorkerRepository workerRepository;

    @Test
    public void register(){
        Worker worker = new Worker();
        worker.setWorker_name("tanshangou");
        worker.setWorker_password("123456");
        worker.setWorker_area("HK");
        worker.setWorker_star(5.0);
        worker.setWorker_tel("13011816363");
        worker.setWorker_id_card("440918****4242");


        workerRepository.save(worker);
    }

}