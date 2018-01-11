package cn.admin.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.sys.entity.Log;
import cn.admin.modules.sys.service.ILogService;

@Transactional
@Service("logService")
public class LogServiceImpl extends CommonServiceImpl<Log> implements ILogService {

}
