package com.percylee.sample.base.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-07-19
 **/
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private String name;

    private String isbn;

    private String description;

    private String author;

    private Author authorEntity;

    private LocalDateTime createTime;
}
