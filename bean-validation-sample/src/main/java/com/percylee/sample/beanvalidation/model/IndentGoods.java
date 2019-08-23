package com.percylee.sample.beanvalidation.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-08-22
 **/
public class IndentGoods {

    @NotNull
    @Min(10000000)
    private Long goodsId;

    @NotNull
    @Min(0)
    private Integer count;
}
