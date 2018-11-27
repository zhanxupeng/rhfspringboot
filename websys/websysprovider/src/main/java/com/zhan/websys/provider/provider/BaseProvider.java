package com.zhan.websys.provider.provider;

import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.common.enums.ENMsgCode;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
public class BaseProvider {
    private final static String SUCCESS = "操作成功";

    protected <T> ResultContext<T> success(T t) {
        ResultContext<T> resultContext = new ResultContext<>();
        resultContext.setCode(ENMsgCode.SUCCESS.getValue());
        resultContext.setData(t);
        resultContext.setInfo(SUCCESS);
        return resultContext;
    }

    protected ResultContext<Void> success() {
        ResultContext<Void> resultContext = new ResultContext<>();
        resultContext.setCode(ENMsgCode.SUCCESS.getValue());
        resultContext.setInfo(SUCCESS);
        return resultContext;
    }
}
