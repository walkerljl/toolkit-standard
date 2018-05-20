package org.walkerljl.toolkit.standard.machine.abstracts;

import org.walkerljl.toolkit.logging.Logger;
import org.walkerljl.toolkit.logging.LoggerFactory;
import org.walkerljl.toolkit.standard.machine.Machine;
import org.walkerljl.toolkit.standard.machine.MachineRepository;
import org.walkerljl.toolkit.standard.machine.exception.CannotStartMachineException;
import org.walkerljl.toolkit.standard.machine.exception.CannotStopMachineException;
import org.walkerljl.toolkit.standard.machine.exception.MachineException;
import org.walkerljl.toolkit.standard.resource.abstracts.AbstractResource;
import org.walkerljl.toolkit.standard.resource.exception.CannotDestroyResourceException;
import org.walkerljl.toolkit.standard.resource.exception.CannotInitResourceException;

/**
 * AbstractMachine
 *
 * @author xingxun
 * @Date 2016/12/9
 */
public abstract class AbstractMachine extends AbstractResource implements Machine {

    private static Logger LOGGER = LoggerFactory.getLogger(AbstractMachine.class);

    /** 是否初始化标志*/
    private volatile boolean running = false;

    /**
     * 处理启动
     *
     * @throws CannotStartMachineException
     */
    public abstract void processStart() throws CannotStartMachineException;

    /**
     * 处理停止
     *
     * @throws CannotStopMachineException
     */
    public abstract void processStop() throws CannotStopMachineException;

    @Override
    public void processInit() throws CannotInitResourceException {

    }

    @Override
    public void processDestroy() throws CannotDestroyResourceException {

    }

    @Override
    public void start() throws CannotStartMachineException {

        long startTime = System.currentTimeMillis();
        try {
            if (!running) {
                synchronized (this) {
                    if (!running) {
                        if (LOGGER.isInfoEnabled()) {
                            LOGGER.info(String.format("%s is starting.", getServerName()));
                        }

                        init();
                        processStart();
                        MachineRepository.register(getGroup(), getId(), this);
                        running = true;

                        if (LOGGER.isInfoEnabled()) {
                            LOGGER.info(String.format("%s has started,consume %s milliseconds.", getServerName(), (System.currentTimeMillis() - startTime)));
                        }

                        //do call back
                        try {
                            callbackOnSuccessToStart();
                        } catch (Throwable ignore) {
                            //ignore
                        }
                    }
                }
            }
        } catch (Throwable e) {
            LOGGER.error(String.format("%s occurs some erros when starting.", getServerName()), e);
            //do call back
            try {
                callbackOnFailureToStart();
            } catch (Throwable ignore) {
                //ignore
            }
            throw new CannotStartMachineException(e);
        }
    }

    @Override
    public void callbackOnSuccessToStart() throws MachineException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s callback when success to start.", getServerName()));
        }
    }

    /**
     * Do process run.
     *
     * @throws MachineException
     */
    protected void processRun() throws MachineException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s is running.", getServerName()));
        }
    }

    @Override
    public void run() throws MachineException {
        if (isRunning()) {
            processRun();
        }
    }

    @Override
    public void callbackOnFailureToStart() throws MachineException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s callback when failure to start.", getServerName()));
        }
    }

    @Override
    public void stop() throws CannotStopMachineException {
        long startTime = System.currentTimeMillis();
        try {
            if (running) {
                synchronized (this) {
                    if (running) {
                        if (LOGGER.isInfoEnabled()) {
                            LOGGER.info(String.format("%s is stopping.", getServerName()));
                        }

                        processStop();
                        MachineRepository.unregister(getGroup(), getId());
                        running = false;

                        if (LOGGER.isInfoEnabled()) {
                            LOGGER.info(String.format("%s has stopped,consume %s milliseconds.", getServerName(), (System.currentTimeMillis() - startTime)));
                        }

                        //do call back
                        try {
                            callbackOnSuccessToStop();
                        } catch (Throwable ignore) {
                            //ignore
                        }
                    }
                }
            }
        } catch (Throwable e) {
            LOGGER.error(String.format("%s occurs some erros when stopping.", getServerName()), e);
            //do call back
            try {
                callbackOnFailureToStop();
            } catch (Throwable ignore) {
                //ignore
            }
            throw new CannotStopMachineException(e);
        }
    }

    @Override
    public void callbackOnSuccessToStop() throws MachineException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s callback when success to stop.", getServerName()));
        }
    }

    @Override
    public void callbackOnFailureToStop() throws MachineException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("%s callback when failure to stop.", getServerName()));
        }
    }

    @Override
    public void restart() throws CannotStartMachineException, CannotStopMachineException {
        synchronized (this) {
            stop();
            start();
        }
    }

    @Override
    public boolean isRunning() {
        synchronized (this) {
            return running;
        }
    }

    /**
     * Get service name
     *
     * @return
     */
    protected String getServerName() {
        return String.format("Machine[id=%s,group=%s,instanceId=%s]", getId(), getGroup(), getInstanceId());
    }
}
