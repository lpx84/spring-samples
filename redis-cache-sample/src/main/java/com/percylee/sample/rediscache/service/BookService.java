package com.percylee.sample.rediscache.service;

import com.percylee.sample.base.model.Book;
import com.percylee.spring.cache.annotantion.CacheExpire;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-08-22
 **/
@Slf4j
@Service
@CacheConfig
public class BookService {

    /**
     * 使用@CacheExpire指定缓存时间，不加使用默认过期时间
     *
     * @param isbn
     * @return
     */
    @CacheExpire(value = 1, timeUnit = TimeUnit.MINUTES)
    @Cacheable(cacheNames = "book.isbn", key = "#isbn")
    public Book getOne(String isbn) {
        try {
            // 模拟数据库查询
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        return Book.builder()
                .isbn(isbn)
                .name("人性的弱点")
                .author("戴尔卡耐基")
                .description("该书汇集了卡耐基的思想精华和最激动人心的内容，是作者最成功的励志经典，出版后立即获得了广大读者的欢迎，" +
                        "成为西方世界最持久的人文畅销书。无数读者通过阅读和实践书中介绍的各种方法，不仅走出困境，有的还成为世人仰慕的杰出人士。" +
                        "只要不断研读本书，相信你也可以发掘自己的无穷潜力，创造辉煌的人生。")
                .createTime(LocalDateTime.now())
                .build();
    }

    /**
     * 修改
     *
     * @param isbn
     * @param name
     * @return
     */
    @CacheExpire(value = 1, timeUnit = TimeUnit.MINUTES)
    @CachePut(cacheNames = "book.isbn", key = "#isbn")
    public Book update(String isbn, String name) {
        Book book = getOne(isbn);
        book.setName(name);
        // 数据库更新操作
        return book;
    }

    /**
     * 删除
     *
     * @param isbn
     */
    @CacheEvict(cacheNames = "book.isbn", key = "#isbn")
    public void delete(String isbn) {
        // 数据库删除操作
    }

}
