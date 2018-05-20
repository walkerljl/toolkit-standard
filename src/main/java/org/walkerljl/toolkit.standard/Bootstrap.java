package org.walkerljl.toolkit.standard;

import org.walkerljl.toolkit.logging.Logger;
import org.walkerljl.toolkit.logging.LoggerFactory;
import org.walkerljl.toolkit.standard.machine.Machine;
import org.walkerljl.toolkit.standard.machine.abstracts.AbstractMachine;
import org.walkerljl.toolkit.standard.machine.exception.CannotStartMachineException;
import org.walkerljl.toolkit.standard.machine.exception.CannotStopMachineException;

/**
 * Bootstrap
 *
 * @author xingxun
 * @Date 2016/12/6
 */
public class Bootstrap extends AbstractMachine implements Machine {

    private static Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);

    /**
     * 启动入口
     *
     * @param args
     * @throws CannotStartMachineException
     */
    public static void main(String[] args) throws CannotStartMachineException {
        new Bootstrap().start();
        synchronized (Bootstrap.class) {
            while (true) {
                try {
                    Bootstrap.class.wait();
                } catch (InterruptedException ex) {}
            }
        }
    }

    @Override
    public void processStart() throws CannotStartMachineException {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("process start.");
        }
    }

    @Override
    public void processStop() throws CannotStopMachineException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("process stop.");
        }
    }

    @Override
    public String getId() {
        return "bootstrap";
    }

    @Override
    public String getName() {
        return getId();
    }

    @Override
    public String getGroup() {
        return "toolkit-standard";
    }
}
