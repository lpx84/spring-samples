package com.percylee.sample.beanvalidation.model;

import com.percylee.sample.beanvalidation.validation.group.AddGoods;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-08-22
 **/
@Setter
@Getter
@NoArgsConstructor
public class Goods {

    /**
     * 商品编号，8位整数
     */
    @Min(value = 10000000, groups = AddGoods.class)
    private Long id;

    /**
     * 国际商品码
     */
//    @NotBlank
    @Pattern(regexp = "[0-9]{13}", message = "{goods.eanCode.invalid}", groups = AddGoods.class)
    private String eanCode;

    /**
     * 名称
     */
    @NotBlank(groups = AddGoods.class)
    private String name;

    /**
     * 价格
     */
    @Min(value = 0, groups = AddGoods.class)
    private Long price;
}
