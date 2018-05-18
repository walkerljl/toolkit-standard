package org.walkerljl.toolkit.standard;

import java.util.Collection;

/**
 * 仓库
 *
 * @author xingxun
 *
 * @param <KEY>
 * @param <VALUE>
 */
public interface Repository<KEY, VALUE> {

    /**
     * 注册资源
     *
     * @param key 资源Key
     * @param value 资源值
     */
    void register(KEY key, VALUE value);

    /**
     * 移除指定资源
     *
     * @param key 资源Key
     */
    void unregister(KEY key);

    /**
     * 查找资源
     *
     * @param key 资源Key
     * @return
     */
    VALUE lookup(KEY key);

    /**
     * 查找所有资源
     *
     * @return
     */
    Collection<? extends VALUE> lookupAll();
}