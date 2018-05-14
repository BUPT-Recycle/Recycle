package com.bupt.recycle.controller;

import com.bupt.recycle.entity.Worker;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import static org.junit.Assert.*;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */
public class WorkerControllerTest {

    @Autowired
    WorkerController workerController;

    @Test
    public void register() {

        Worker worker = new Worker();
        worker.setWorker_name("tanshangou");
        worker.setWorker_password("123456");
        worker.setWorker_area("HK");
        worker.setWorker_star(5.0);
        worker.setWorker_tel("13011816363");
        worker.setWorker_id_card("440918****4242");
    }
}