package org.walkerljl.toolkit.standard.abstracts;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.walkerljl.toolkit.standard.Repository;
import org.walkerljl.toolkit.standard.exception.AppException;

/**
 * 抽象的仓库实现
 *
 * @author xingxun
 */
public class AbstractRepository<KEY, VALUE> implements Repository<KEY, VALUE> {

    private final Map<KEY, VALUE> repository = new HashMap<KEY, VALUE>();

    @Override
    public void register(KEY key, VALUE value) {
        assertKeyNotNull(key);
        assertValueNotNull(value);
        repository.put(key, value);
    }

    @Override
    public void unregister(KEY key) {
        if (key == null) {
            return;
        }
        repository.remove(key);
    }

    @Override
    public VALUE lookup(KEY key) {
        if (key == null) {
            return null;
        }
        return repository.get(key);
    }

    @Override
    public Collection<? extends VALUE> lookupAll() {
        return Collections.unmodifiableCollection(repository.values());
    }

    /**
     * 断言资源Key不能为Null
     *
     * @param key 资源Key
     */
    private void assertKeyNotNull(KEY key) {
        if (key == null) {
            throw new AppException("Repository key is null");
        }
    }

    /**
     * 断言资源值不能为Null
     *
     * @param value 资源值
     */
    private void assertValueNotNull(VALUE value) {
        if (value == null) {
            throw new AppException("Repository value is null");
        }
    }
}