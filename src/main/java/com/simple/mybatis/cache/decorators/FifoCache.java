package com.simple.mybatis.cache.decorators;

import com.simple.mybatis.cache.Cache;

import java.util.Deque;

/**
 * FIFO (first in, first out) cache decorator
 *
 * @author SinceNovember
 * @date 2022/10/18
 */
public class FifoCache implements Cache {

    private Cache delegate;
    private Deque<Object> keyList;
    private int size;

    public FifoCache(Cache delegate, Deque<Object> keyList, int size) {
        this.delegate = delegate;
        this.keyList = keyList;
        this.size = size;
    }

    @Override
    public String getId() {
        return delegate.getId();
    }

    @Override
    public void putObject(Object key, Object value) {
        cycleKeyList(key);
        delegate.putObject(key, value);
    }

    @Override
    public Object getObject(Object key) {
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        return delegate.removeObject(key);
    }

    @Override
    public void clear() {
        delegate.clear();
        keyList.clear();
    }

    @Override
    public int getSize() {
        return delegate.getSize();
    }

    private void cycleKeyList(Object key) {
        keyList.addLast(key);
        if (keyList.size() > size) {
            Object oldestKey = keyList.removeFirst();
            delegate.removeObject(oldestKey);
        }
    }
}
