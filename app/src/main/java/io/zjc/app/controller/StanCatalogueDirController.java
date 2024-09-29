package io.zjc.app.controller;

import io.zjc.app.common.CommonResp;
import io.zjc.app.pojo.mariadb.mytest.StanCatalogueDir;
import io.zjc.app.service.mariadb.mytest.StanCatalogueDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/StanCatalogueDirController")
public class StanCatalogueDirController {

    @Autowired
    StanCatalogueDirService stanCatalogueDirService;

    @GetMapping("/list")
    public CommonResp<List<StanCatalogueDir>> list() {
        List<StanCatalogueDir> list = stanCatalogueDirService.list();
        return CommonResp.ok(list);
    }

}
