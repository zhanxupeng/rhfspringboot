package com.zhan.websys.manager.base.impl;

import com.github.pagehelper.PageHelper;
import com.zhan.websys.common.exception.BusinessException;
import com.zhan.websys.common.exception.SystemException;
import com.zhan.websys.dao.base.BaseMapper;
import com.zhan.websys.entity.base.BaseEntity;
import com.zhan.websys.entity.base.PageQuery;
import com.zhan.websys.manager.base.BaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
public class BaseManagerImpl<T extends BaseMapper<M>, M extends BaseEntity> implements BaseManager<M> {
    @Autowired
    private T mapper;

    @Override
    public M getById(String urid) {
        M entity = mapper.selectById(urid);
        return Optional.ofNullable(entity).orElseThrow(() -> new BusinessException("记录不存在"));
    }

    @Override
    public void insert(M entity) {
        entity.init();
        int insert = mapper.insert(entity);
        if (insert != 1) {
            throw new SystemException("插入记录发生异常");
        }
    }

    @Override
    public void update(M entity) {
        entity.edit();
        int edit = mapper.update(entity);
        if (edit != 1) {
            throw new SystemException("更新记录发生异常");
        }
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deletes(List<M> list) {
        list.forEach(x -> {
            int delete = mapper.delete(x.getUrid(), x.getVersion());
            if (delete != 1) {
                throw new SystemException("删除记录发生异常");
            }
        });
    }

    @Override
    public List<M> find(PageQuery<M> pageQuery) {
        //todo 分页拦截器暂时没法用
        PageHelper.startPage(pageQuery.getPageNum(), pageQuery.getPageSize(), pageQuery.getOrderBy());
        return mapper.find(pageQuery.getEntity());
    }
}
