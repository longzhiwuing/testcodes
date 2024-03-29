package com.lzwing.testcode.utils.vjkit.concurrent.threadpool;

import com.vip.vjtools.vjkit.concurrent.ThreadUtil;
import com.vip.vjtools.vjkit.concurrent.threadpool.QueuableCachedThreadPool;
import com.vip.vjtools.vjkit.concurrent.threadpool.ThreadPoolBuilder;
import com.vip.vjtools.vjkit.concurrent.threadpool.ThreadPoolUtil;
import org.junit.Test;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class QueuableCachedThreadPoolTest {

	public static class LongRunTask implements Runnable {
		@Override
		public void run() {
			ThreadUtil.sleep(5, TimeUnit.SECONDS);
		}
	}

	@Test
	public void test() {
		QueuableCachedThreadPool threadPool = null;
		try {
			threadPool = ThreadPoolBuilder.queuableCachedPool().setMinSize(0).setMaxSize(10).setQueueSize(10).build();
			// 线程满
			for (int i = 0; i < 10; i++) {
				threadPool.submit(new LongRunTask());
			}

			assertThat(threadPool.getActiveCount()).isEqualTo(10);
			assertThat(threadPool.getQueue().size()).isEqualTo(0);

			// queue 满
			for (int i = 0; i < 10; i++) {
				threadPool.submit(new LongRunTask());
			}
			assertThat(threadPool.getActiveCount()).isEqualTo(10);
			assertThat(threadPool.getQueue().size()).isEqualTo(10);

			// 爆
			try {
				threadPool.submit(new LongRunTask());
				fail("should fail before");
			} catch (Throwable t) {
				assertThat(t).isInstanceOf(RejectedExecutionException.class);
			}

		} finally {
			ThreadPoolUtil.gracefulShutdown(threadPool, 1000);
		}
	}

}
