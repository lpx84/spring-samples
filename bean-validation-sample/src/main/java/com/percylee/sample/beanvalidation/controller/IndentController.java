package com.percylee.sample.beanvalidation.controller;

import com.alibaba.fastjson.JSON;
import com.percylee.sample.beanvalidation.model.Indent;
import com.percylee.sample.beanvalidation.validation.group.CreateIndent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-08-22
 **/
@Slf4j
@RestController
@RequestMapping("/api/indent")
public class IndentController {

    /**
     * 提交订单
     * @param indent
     * @return
     */
    @PostMapping("/submit")
    public Indent submit(@Validated(value = CreateIndent.class) @RequestBody Indent indent) {
        log.info(JSON.toJSONString(LocaleContextHolder.getLocale()));
        return indent;
    }

}
