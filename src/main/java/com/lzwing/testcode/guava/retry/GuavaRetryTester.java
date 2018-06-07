package com.lzwing.testcode.guava.retry;

import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.google.common.base.Predicates;
import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/7
 * Time: 14:02
 */
public class GuavaRetryTester {

    public static void main(String[] args) {
        new GuavaRetryTester().retry();
    }

    Callable<Boolean> callable = new Callable<Boolean>() {
        public Boolean call() throws Exception {
//            return null; // do something useful here

            TimeUnit.MILLISECONDS.sleep(1000);

            int i = RandomUtils.nextInt(1, 10);

            System.out.printf("i=%d\n",i);

            if (i % 7 == 0) {
                return true;
            } else {
                return null;
            }
        }
    };

    public void retry() {
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfResult(Predicates.<Boolean>isNull())
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .build();
        try {
            retryer.call(callable);
        } catch (RetryException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
