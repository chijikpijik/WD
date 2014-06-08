package com.example.start;

import com.example.start.cache.memory.MemoryCacheAware;
import com.example.start.cache.memory.impl.LargestLimitedMemoryCache;

/**
 * Created with IntelliJ IDEA.
 * User: ANDDEV
 * Date: 20.03.14
 * Time: 0:47
 * To change this template use File | Settings | File Templates.
 */
public enum CACHE {

    INSTANCE;

    private final LargestLimitedMemoryCache mBitmapCache = new LargestLimitedMemoryCache(1 * 1024 * 1024);

    public LargestLimitedMemoryCache getCache() {
        return mBitmapCache;
    }

}
