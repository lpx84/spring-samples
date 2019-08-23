package com.percylee.sample.beanvalidation.controller;

import com.alibaba.fastjson.JSON;
import com.percylee.sample.beanvalidation.model.Indent;
import com.percylee.sample.beanvalidation.validation.group.CreateIndent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-08-22
 **/
@Slf4j
@RestController
@RequestMapping("/api/indent")
// 如果想要group生效，必须在class上面加这个
@Validated
public class IndentController {

    /**
     * 提交订单
     * @param indent
     * @return
     */
    @PostMapping("/submit")
    @Validated(value = CreateIndent.class)
    public Indent submit(@Valid @RequestBody Indent indent) {
        return indent;
    }

}
