package com.zhan.websys.dao.menu;

import com.zhan.websys.dao.base.BaseMapper;
import com.zhan.websys.entity.menu.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getByIdList(@Param("idList") Collection<String> idList);

    int updateActiveFlag(@Param("urid") String urid,
                         @Param("version") Long version,
                         @Param("activeFlag") String activeFlag,
                         @Param("preActiveFlag") String preActiveFlag);
}