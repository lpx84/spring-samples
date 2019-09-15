package com.percylee.sample.beanvalidation.model;

import lombok.*;

/**
 * @author lpxiangvip@126.com
 * @date 2019/9/13
 */
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RestResult<D> {

    private int code;
    private String message;
    private D data;
}
