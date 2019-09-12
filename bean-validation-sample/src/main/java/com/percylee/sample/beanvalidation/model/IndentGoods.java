package com.percylee.sample.beanvalidation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-08-22
 **/
@Getter
@Setter
@NoArgsConstructor
public class IndentGoods {

    @NotNull
    @Min(value = 10000000, message = "{goods.id.invalid}")
    private Long goodsId;

    @NotNull
    @Min(value = 1, message = "{indent.goods.self.number.invalid}")
    private Integer count;
}
