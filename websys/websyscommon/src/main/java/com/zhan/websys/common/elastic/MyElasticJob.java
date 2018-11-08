package com.zhan.websys.common.elastic;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @author zhanxp
 * @version 1.0 2018/10/30
 */
public class MyElasticJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        switch (context.getShardingItem()) {
            case 0:
                // do something by sharding item 0
                System.out.println("hello World");
                break;
            case 1:
                // do something by sharding item 1
                System.out.println("hello World1");
                break;
            case 2:
                // do something by sharding item 2
                System.out.println("hello World2");
                break;
            // case n: ...
        }
    }
}
