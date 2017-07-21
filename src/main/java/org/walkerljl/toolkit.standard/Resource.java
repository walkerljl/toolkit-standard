package org.walkerljl.toolkit.standard;

import org.walkerljl.toolkit.standard.exception.resouce.CannotDestroyResourceException;
import org.walkerljl.toolkit.standard.exception.resouce.CannotInitResourceException;

/**
 * Describe one kind of resource which can init and destroy.
 *
 * @author: lijunlin
 */
public interface Resource extends Identifer {

    /**
     * Get instance id
     *
     * @return
     */
    String getInstanceId();

    /**
     * Init
     *
     * @throws CannotInitResourceException
     */
    void init() throws CannotInitResourceException;

    /**
     * Destroy
     *
     * @throws CannotDestroyResourceException
     */
    void destroy() throws CannotDestroyResourceException;
}
