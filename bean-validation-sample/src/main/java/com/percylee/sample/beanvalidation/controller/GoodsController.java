package com.percylee.sample.beanvalidation.controller;

import com.percylee.sample.beanvalidation.model.Goods;
import com.percylee.sample.beanvalidation.validation.group.AddGoods;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * 商品接口服务
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-08-26
 **/
@RestController
@RequestMapping("/api/goods")
@Validated
public class GoodsController {

    /**
     * 增加商品<code>Goods</code>
     * @param goods 需要保存的商品
     * @return 保存后的商品信息
     */
    @PostMapping("/add")
    public Goods add(@RequestBody @Validated(AddGoods.class) Goods goods) {
        return goods;
    }

    /**
     * 查询商品
     * 下面的@Min生效的条件：
     * 1. 保证MethodValidationPostProcessor已经注入，Spring Boot会自动注入
     * 2. 在class上面有@Validated
     * @param id 商品ID
     * @return
     */
    @GetMapping("/{id}")
    public Goods getById(@PathVariable @Min(10000) Long id) {
        return Goods.builder().id(id).build();
    }

    /**
     * 通过eanCode查询商品
     * 另一种检验方式，如果格式不正确，则会返回404
     * @param eanCode
     * @return
     */
    @GetMapping("/eanCode/{eanCode:[0-9]{13}}")
    public Goods getByEanCode(@PathVariable String eanCode) {
        return Goods.builder().eanCode(eanCode).build();
    }

    /**
     * 还支持脚本验证
     * @return
     */
    @RequestMapping(value = "/eanCode2/{eanCode}")
    @ParameterScriptAssert(lang = "javascript",
            script = "eanCode && eanCode.length == 13 && eanCode.startsWith('110')",
            message = "{goods.eanCode.invalid}")
    public Goods getByEanCode2(@PathVariable(required = false) String eanCode) {
        return Goods.builder().eanCode(eanCode).build();
    }

    /**
     * 搜索一个商品ID
     * @param key 关键字
     *            支持模糊搜索
     * @return
     * @deprecated 未实现或者
     * 过期，请参考xxx
     */
    @GetMapping("/search")
    public Long[] searchOne(@RequestParam(required = false, defaultValue = "This is default 关键字") String key) {
        return new Long[]{100L};
    }

    /**
     * 搜索商品
     * @param keys
     * @return 符合条件的商品信息列表
     */
    @GetMapping("/search2")
    public List<Goods> searchTwo(List<String> keys) {
        return null;
    }

}
