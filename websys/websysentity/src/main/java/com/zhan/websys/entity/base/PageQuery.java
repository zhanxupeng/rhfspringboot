package com.zhan.websys.entity.base;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
@Getter
@Setter
public class PageQuery<T extends BaseEntity> {

    private T entity;
    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 每页记录数量
     */
    private Integer pageSize = 20;

    /**
     * 表格排序字段名
     */
    private String sortName;

    /**
     * 表格排序类型 desc,asc
     */
    private String sortType;

    public String getOrderBy() {
        String sortBy = null;
        if (StrUtil.isNotBlank(sortName) && StrUtil.isNotBlank(sortType)) {
            sortBy = sortName + " " + sortType;
        }
        return sortBy;
    }
}
