package com.bupt.recycle.service;

import com.bupt.recycle.entity.Worker;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description
 */
public interface WorkerService {

    //注册
    public Worker register(Worker worker);

    //登陆
    public Worker login(String workerPhone,String workerPassword);

    //评分
    public int star(Double star,int workerId);

    Object getWorker(int workerId);
}
