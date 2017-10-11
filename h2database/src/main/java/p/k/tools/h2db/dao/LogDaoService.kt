package p.k.tools.h2db.dao

import p.k.tools.datasource.DataStoreService
import javax.sql.DataSource

interface LogDaoService : DataStoreService
{
    /**
     * @param dataSource the jdbcTemplate to set
     */
    fun setDataSource(dataSource: DataSource)

}
