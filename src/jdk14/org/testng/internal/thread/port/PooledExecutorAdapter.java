package org.testng.internal.thread.port;

import org.testng.internal.thread.IPooledExecutor;

import edu.emory.mathcs.util.concurrent.LinkedBlockingQueue;
import edu.emory.mathcs.util.concurrent.ThreadPoolExecutor;
import edu.emory.mathcs.util.concurrent.TimeUnit;

/**
 * IPooledExecutor implementation based on ThreadPoolExecutor.
 *
 * @author <a href='mailto:the_mindstorm@evolva.ro'>Alexandru Popescu</a>
 */
public class PooledExecutorAdapter extends ThreadPoolExecutor implements IPooledExecutor {
   public PooledExecutorAdapter(int poolSize) {
      super(poolSize,
            poolSize,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue());
   }

   public void awaitTermination(long timeout) throws InterruptedException {
      super.awaitTermination(timeout, TimeUnit.MILLISECONDS);
   }
}