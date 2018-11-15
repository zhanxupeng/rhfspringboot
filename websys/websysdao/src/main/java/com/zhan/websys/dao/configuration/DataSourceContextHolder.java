package com.zhan.websys.dao.configuration;

/**
 * @author zhanxp
 * @version 1.0 2018/10/24
 */
public class DataSourceContextHolder {
    private static final String DEFAULT = "sourceOne";
    private static final ThreadLocal<String> CONTEXT_HOLDER = ThreadLocal.withInitial(() -> DEFAULT);


    public static void setSourceKey(String dbType) {
        CONTEXT_HOLDER.set(dbType);
    }


    public static String getSourceKey() {
        return (CONTEXT_HOLDER.get());
    }


    public static void clearSourceKey() {
        CONTEXT_HOLDER.remove();
    }
}
