package cn.admin.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.sys.entity.DataSource;
import cn.admin.modules.sys.service.IDataSourceService;

/**   
 * @Title: 数据源
 * @Description: 数据源
 * @author jeeadmin
 * @date 2017-05-10 12:01:57
 * @version V1.0   
 *
 */
@Transactional
@Service("dataSourceService")
public class DataSourceServiceImpl  extends CommonServiceImpl<DataSource> implements  IDataSourceService {

}
