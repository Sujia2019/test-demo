package com.cxl;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在自旋锁中 另有三种常见的锁形式:TicketLock ，CLHlock 和MCSlock
 */
public class OtherSpinLock {
    /**
     * Ticket锁主要解决的是访问顺序的问题，主要的问题是在多核cpu上
     *
     * 每次都要查询一个serviceNum 服务号，影响性能（必须要到主内存读取，并阻止其他cpu修改）。
     */
     class TicketLock{
        private AtomicInteger serviceNum=new AtomicInteger();
        private AtomicInteger ticketNum=new AtomicInteger();
        private final ThreadLocal<Integer> LOCAL=new ThreadLocal<Integer>();

        public void lock(){
            int myTicket=ticketNum.getAndIncrement();
            LOCAL.set(myTicket);
            while(myTicket!=serviceNum.get()){
            }
        }
        public void unlock(){
            int myTicket=LOCAL.get();
            serviceNum.compareAndSet(myTicket,myTicket+1);
        }
    }

    /**
     *
     */

}
