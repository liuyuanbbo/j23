package io.zjc.app.controller;

import io.zjc.app.common.CommonResp;
import io.zjc.app.pojo.mariadb.mytest.StanCatalogueDir;
import io.zjc.app.service.mariadb.mytest.StanCatalogueDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/selectCustomList")
    public CommonResp<List<StanCatalogueDir>> selectCustomList() {
        List<StanCatalogueDir> list = stanCatalogueDirService.selectCustomList();
        return CommonResp.ok(list);
    }

    @GetMapping("/selectListByDirId")
    public CommonResp<List<StanCatalogueDir>> selectListByDirId(@RequestParam("dirId") Long dirId) {
        List<StanCatalogueDir> list = stanCatalogueDirService.selectListByDirId(dirId);
        return CommonResp.ok(list);
    }

}
