package io.zjc.app.mapper.mariadb.mytest;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.zjc.app.pojo.mariadb.mytest.StanCatalogueDir;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StanCatalogueDirMapper extends BaseMapper<StanCatalogueDir> {
    List<StanCatalogueDir> selectCustomList();

    List<StanCatalogueDir> selectListByDirId(@Param("dirId") Long dirId);
}
