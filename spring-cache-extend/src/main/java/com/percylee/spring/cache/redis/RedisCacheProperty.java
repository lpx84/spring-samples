package com.percylee.spring.cache.redis;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.StringUtils;

import java.time.Duration;

/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-07-19
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.cache.redis.support")
public class RedisCacheProperty {

    /**
     * 默认redis过期时间（必须）
     *
     * @return
     */
    private Duration defaultExpireTime;

    /**
     * redisKey的前缀（必须）
     *
     * @return
     */
    private String keyPrefix;

    /**
     * 是否缓存NULL值，默认为true（可选）
     *
     * @return
     */
    private Boolean cacheNullValues;

    /**
     * 是否开启事务，默认false（可选）
     * 原文注释：Enable RedisCache to synchronize cache put/evict operations with ongoing Spring-managed transactions.
     */
    private Boolean enableTransactions;

    /**
     * 是否允许创建没有配置过的缓存，默认true（可选）
     */
    private Boolean enableCreateOnMissingCache;

    /**
     * key序列化（可选）
     *
     * @return
     */
    @Setter(AccessLevel.NONE)
    private RedisSerializer<String> keySerializer;

    /**
     * value序列化（可选）
     *
     * @return
     */
    @Setter(AccessLevel.NONE)
    private RedisSerializer<?> valueSerializer;

    /**
     * 类型转换服务接口（可选）
     *
     * @return
     */
    @Setter(AccessLevel.NONE)
    private ConversionService conversionService;

    public void setKeySerializer(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (StringUtils.isEmpty(className)) {
            return;
        }
        this.keySerializer = (RedisSerializer<String>) Class.forName(className).newInstance();
    }

    public void setValueSerializer(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (StringUtils.isEmpty(className)) {
            return;
        }
        this.valueSerializer = (RedisSerializer<?>) Class.forName(className).newInstance();
    }

    public void setConversionService(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (StringUtils.isEmpty(className)) {
            return;
        }
        this.conversionService = (ConversionService) Class.forName(className).newInstance();
    }
}
