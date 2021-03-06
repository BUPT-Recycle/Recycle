package com.bupt.recycle.controller;

import com.bupt.recycle.Enum.ResultEnum;
import com.bupt.recycle.entity.Worker;
import com.bupt.recycle.exception.WorkerException;
import com.bupt.recycle.model.ResultModel;
import com.bupt.recycle.service.WorkerService;
import com.bupt.recycle.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @anthor tanshangou
 * @time 2018/4/8
 * @description 回收员逻辑层
 */

@RestController
@RequestMapping("/recycle")
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @PostMapping("/worker")
    public ResultModel register(@RequestBody @Valid Worker worker, BindingResult bindingResult){

        if(bindingResult.hasErrors()){

            throw new WorkerException(1,bindingResult.getFieldError().getDefaultMessage());
        }

        Worker worker_ = workerService.register(worker);
        if (worker_!=null){
            return ResultUtil.success(worker_);
        }
        throw new WorkerException(ResultEnum.REGISTER_FAILED.getCode(),ResultEnum.REGISTER_FAILED.getMsg());
    }
}
