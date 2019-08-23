package com.percylee.sample.base.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-07-22
 **/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {

    private String name;

    private String address;

    private String company;
}
