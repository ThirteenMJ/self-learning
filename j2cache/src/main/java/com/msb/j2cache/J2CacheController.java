package com.msb.j2cache;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: thirteenmj
 * @date: 2022-11-20 21:12
 */
@RestController
@RequestMapping("/j2cache")
public class J2CacheController {

    private String key = "myKey";

    private String testKey = "myTestKey";

    private String testRegion = "testRegion";

    @Resource
    private CacheChannel cacheChannel;

    @GetMapping("/getValue")
    public String getValue() {
        CacheObject cacheObject = cacheChannel.get(testRegion, key);
        if (null == cacheObject.getValue()) {
            // 从缓存取不到值，就去数据库查询
            String dbString = "value in db";
            // 放进缓存
            cacheChannel.set(testRegion, key, dbString);
            return dbString;
        }
        return cacheObject.getValue().toString();
    }

    @GetMapping("/getValue1")
    public String getValue1() {
        CacheObject cacheObject = cacheChannel.get(testRegion, key);
        return cacheObject.getValue().toString();
    }

    @GetMapping("/getValue2")
    public String getValue2() {
        CacheObject cacheObject = cacheChannel.get(testRegion, testKey);
        if (null == cacheObject.getValue()) {
            // 从缓存取不到值，就去数据库查询
            String dbString = "testValue in db";
            // 放进缓存
            cacheChannel.set(testRegion, testKey, dbString);
            return dbString;
        }
        return cacheObject.getValue().toString();
    }

    /**
     * 清除一级和二级中的指定key
     * @return
     */
    @GetMapping("evict")
    public String evict() {
        cacheChannel.evict(testRegion, key);
        return "evict success";
    }

    /**
     * 清除指定区域
     * @return
     */
    @GetMapping("clear")
    public String clear() {
        cacheChannel.clear(testRegion);
        return "clear success";
    }

    /**
     * 判断缓存中数据是否存在
     * @return
     */
    @GetMapping("exists")
    public String exists() {
        boolean result = cacheChannel.exists(testRegion, key);
        return "exists:" + result;
    }

    /**
     * 判断从哪一级缓存取数据
     * @return
     */
    @GetMapping("check")
    public String check() {
        int level = cacheChannel.check(testRegion, key);
        return "level:" + level;
    }

}
