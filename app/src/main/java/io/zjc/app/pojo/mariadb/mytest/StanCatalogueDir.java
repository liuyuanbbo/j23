package io.zjc.app.pojo.mariadb.mytest;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName(value = "stan_catalogue_dir")
public class StanCatalogueDir {

    @TableId
    private Integer dirId;


    private String dirCode;


    private String dirName;


    private String dirType;


    private Integer parentDirId;


    private String dirFullPath;


    private Integer dirSort;


    private String dirDesc;


    private Integer cataId;


    private String cataType;


    private String statusCd;


    private Integer createBy;


    private Date createDate;


    private Integer lastModifyBy;


    private Date lastModifyDate;


    private Integer comAcctId;


    private Integer coderuleId;


    private Integer dataWarehouseId;


    private Integer datasourceId;


    private Long projectId;


    private String metaDataType;


    private String area;


    private Integer level;


    private String sourceSystem;


    private String indexFlag;


    private String dirSource;
}