package org.walkerljl.toolkit.standard.abstracts;

import org.walkerljl.toolkit.logging.Logger;
import org.walkerljl.toolkit.logging.LoggerFactory;
import org.walkerljl.toolkit.standard.Resource;
import org.walkerljl.toolkit.standard.exception.CannotDestroyResourceException;
import org.walkerljl.toolkit.standard.exception.CannotInitResourceException;
import org.walkerljl.toolkit.standard.support.ResourceRepository;

/**
 * AbstractResource
 *
 * @author lijunlin
 * @Date 2016/12/9
 */
public abstract class AbstractResource implements Resource {

    private static Logger LOGGER = LoggerFactory.getLogger(AbstractResource.class);

    private volatile boolean inited = false;

    public abstract void processInit() throws CannotInitResourceException;

    public abstract void processDestroy() throws CannotDestroyResourceException;

    @Override
    public String getName() {
        return getId();
    }

    @Override
    public String getInstanceId() {
        return this.toString();
    }

    @Override
    public void init() throws CannotInitResourceException {
        long startTime = System.currentTimeMillis();
        try {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info(String.format("%s is initing.", getServerName()));
            }
            if (!inited) {
                synchronized (this) {
                    processInit();
                    ResourceRepository.register(getGroup(), getId(), this);
                    inited = true;
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.info(String.format("%s has inited,consume %s milliseconds.", getServerName(), (System.currentTimeMillis() - startTime)));
                    }
                }
            }
        } catch (Throwable e) {
            LOGGER.error(String.format("%s occurs some erros when initing.", getServerName()), e);
            throw new CannotInitResourceException(e);
        }
    }

    @Override
    public void destroy() throws CannotDestroyResourceException {
        long startTime = System.currentTimeMillis();
        try {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info(String.format("%s is destroying.", getServerName()));
            }
            synchronized (this) {
                processDestroy();
                ResourceRepository.unregister(getGroup(), getId());
                inited = false;
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info(String.format("%s has destroied,consume %s milliseconds.", getServerName(), (System.currentTimeMillis() - startTime)));
                }
            }
        } catch (Throwable e) {
            LOGGER.error(String.format("%s occurs some erros when destroying.", getServerName()), e);
            throw new CannotDestroyResourceException(e);
        }
    }

    /**
     * 获取服务名称
     *
     * @return
     */
    protected String getServerName() {
        return String.format("Resource[id=%s,group=%s,instanceId=%s]", getId(), getGroup(), getInstanceId());
    }
}