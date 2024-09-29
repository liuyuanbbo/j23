package io.zjc.app.config;

public class DataSourceContextHolder {
    public static final String DATA_SOURCE_MARIADB_MYTEST = "DataSourceMariadbMyTest";

    public static final String DATA_SOURCE_MYSQL_DATAPORTAL_156O3 = "DataSourceMysqlDataPortal156O3";

    public static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
