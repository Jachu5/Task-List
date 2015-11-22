package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jachu on 16/11/15.
 * <p>
 * Interactor executor implementation based on a ThreadPoolExecutor
 */
public class ThreadCommandExecutor implements CommandExecutor {

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();

    private ThreadPoolExecutor mThreadPoolExecutor;

    /**
     * Default constructor
     */
    public ThreadCommandExecutor() {
        mThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);
    }

    /**
     * Constructor with parameters
     *
     * @param corePoolSize  executor thread pool size
     * @param maxPoolSize   executor maximum thread pool size
     * @param keepAliveTime executor thread keep alive time
     * @param timeUnit      executor time unit
     */
    public ThreadCommandExecutor(final int corePoolSize, final int maxPoolSize, final int keepAliveTime, final TimeUnit timeUnit) {
        mThreadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, WORK_QUEUE);
    }

    @Override
    public void run(Command command) {
        if (command == null) {
            throw new IllegalArgumentException("Interactor to be executed can not be null");
        }

        mThreadPoolExecutor.submit(command);
    }
}
