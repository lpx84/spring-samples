package com.percylee.sample.beanvalidation.model;

import com.percylee.sample.beanvalidation.validation.group.AddGoods;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-08-22
 **/
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    /**
     * 商品编号，8位整数
     *
     * @deprecated 不用传这个值了以后
     */
    @Min(value = 10000000, groups = AddGoods.class)
    private Long id = 10000000L;

    /**
     * 国际商品码
     *
     * @required
     * @default 1234567890123
     * @rule [0-9]{13}
     */
    @NotBlank(message = "{goods.eanCode.notBlank}", groups = AddGoods.class)
    @Size(min = 13, max = 13, message = "{goods.eanCode.invalid}", groups = AddGoods.class)
    @Pattern(regexp = "[0-9]{13}", message = "{goods.eanCode.invalid}", groups = AddGoods.class)
    private String eanCode;

    /**
     * 名称
     */
    @NotBlank(message = "{goods.name.invalid}", groups = AddGoods.class)
    @Size(min = 4, max = 100, message = "{goods.name.invalid}", groups = AddGoods.class)
    private String name;

    /**
     * 价格(分)
     */
    @NotNull(message = "{goods.price.invalid}", groups = AddGoods.class)
    @Min(value = 0, message = "{goods.price.invalid}", groups = AddGoods.class)
    private Long price;

    /**
     * 商品信息提交人
     */
    @Deprecated
    private UserInfo creator;

    @AssertTrue(message = "{goods.must.from.china}", groups = AddGoods.class)
    public boolean isChinaGoods() {
        return eanCode.startsWith("690");
    }
}
