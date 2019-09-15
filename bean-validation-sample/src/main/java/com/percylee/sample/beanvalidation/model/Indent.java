package com.percylee.sample.beanvalidation.model;

import com.percylee.sample.beanvalidation.validation.group.CreateIndent;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-08-22
 **/
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Indent {

    @Null(message = "{indent.id.must.null}", groups = CreateIndent.class)
    private Long id;

    /**
     * 订单号(实际提交订单订单号是在后端生成，这里只是为了测试)
     */
    @Size(min = 10, max = 11, message = "{indent.orderNo.invalid}", groups = CreateIndent.class)
    private String orderNo;

    /**
     * 单位：分
     */
    @Min(value = 0, message = "{indent.money.must.greater.than}", groups = CreateIndent.class)
    private Long money;

    /**
     * 订单商品
     */
    @Valid
    @Size(min = 1, message = "{indent.goods.num.invalid}", groups = CreateIndent.class)
    List<IndentGoods> indentGoodsList;

    /**
     * 创建时间
     */
    @Deprecated
    private LocalDateTime createTime;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 发货时间/邮寄时间
     */
    private LocalDateTime mailTime;
}
