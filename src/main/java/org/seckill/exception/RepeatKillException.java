package org.seckill.exception;

/**
 * 重复秒杀异常 (RuntimeException)
 * Created by kukri on 2018/5/7.
 */
public class RepeatKillException extends SeckillException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
