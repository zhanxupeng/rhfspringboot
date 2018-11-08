package com.zhan.websys.common.elastic;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhanxp
 * @version 1.0 2018/10/30
 */
public class DataflowJobDemo implements DataflowJob<String> {
    private final static AtomicInteger a = new AtomicInteger(0);

    @Override
    public List<String> fetchData(ShardingContext shardingContext) {
        List<String> data = new LinkedList<>();
        switch (shardingContext.getShardingItem()) {
            case 0:
                data = Arrays.asList("111", "222");
                return data;
            case 1:
                data = Arrays.asList("1212", "3333");
                return data;
            case 2:
                data = Arrays.asList("444", "555");
                return data;
            // case n: ...
        }
        if (a.get() > 2) {
            return null;
        }
        return data;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<String> list) {
        System.out.println("执行了一次");
        list.clear();
        a.addAndGet(1);
    }
}
