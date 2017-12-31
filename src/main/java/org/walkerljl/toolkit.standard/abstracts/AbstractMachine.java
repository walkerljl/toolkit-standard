package org.walkerljl.toolkit.standard.abstracts;

import org.walkerljl.toolkit.logging.Logger;
import org.walkerljl.toolkit.logging.LoggerFactory;
import org.walkerljl.toolkit.standard.Machine;
import org.walkerljl.toolkit.standard.exception.resouce.CannotDestroyResourceException;
import org.walkerljl.toolkit.standard.exception.resouce.CannotInitResourceException;
import org.walkerljl.toolkit.standard.exception.machine.CannotStartMachineException;
import org.walkerljl.toolkit.standard.exception.machine.CannotStopMachineException;
import org.walkerljl.toolkit.standard.exception.machine.MachineException;
import org.walkerljl.toolkit.standard.support.MachineRepository;

/**
 * AbstractMachine
 *
 * @author xingxun
 * @Date 2016/12/9
 */
public abstract class AbstractMachine implements Machine {

    private static Logger LOGGER = LoggerFactory.getLogger(AbstractMachine.class);

    private volatile boolean running = false;

    public abstract void processStart() throws CannotStartMachineException;

    public abstract void processStop() throws CannotStopMachineException;

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
            LOGGER.debug(String.format("%s has run.", getServerName()));
        }
    }

    @Override
    public void run() throws MachineException {
        if (isRunning()) {
            synchronized (this) {
                if (isRunning()) {
                    processRun();
                }
            }
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

    }

    @Override
    public void destroy() throws CannotDestroyResourceException {
        long startTime = System.currentTimeMillis();
        try {
            synchronized (this) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info(String.format("%s is destroying.", getServerName()));
                }

                stop();

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
     * Get service name
     *
     * @return
     */
    protected String getServerName() {
        return String.format("Machine[id=%s,group=%s,instanceId=%s]", getId(), getGroup(), getInstanceId());
    }
}
