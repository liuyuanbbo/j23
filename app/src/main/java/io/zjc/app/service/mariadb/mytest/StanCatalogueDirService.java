package io.zjc.app.service.mariadb.mytest;

import io.zjc.app.config.DataSourceContextHolder;
import io.zjc.app.mapper.mariadb.mytest.StanCatalogueDirMapper;
import io.zjc.app.pojo.mariadb.mytest.StanCatalogueDir;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StanCatalogueDirService {

    @Resource
    StanCatalogueDirMapper stanCatalogueDirMapper;

    public List<StanCatalogueDir> list() {
        DataSourceContextHolder.setDataSourceType(DataSourceContextHolder.DATA_SOURCE_MYSQL_DATAPORTAL_156O3);
        return stanCatalogueDirMapper.selectList(null);
    }

    public List<StanCatalogueDir> selectCustomList() {
        DataSourceContextHolder.setDataSourceType(DataSourceContextHolder.DATA_SOURCE_MYSQL_DATAPORTAL_156O3);
        return stanCatalogueDirMapper.selectCustomList();
    }

    public List<StanCatalogueDir> selectListByDirId(Long dirId) {
        return stanCatalogueDirMapper.selectListByDirId(dirId);
    }
}
