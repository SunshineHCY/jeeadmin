package cn.admin.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.sys.entity.DictEntity;
import cn.admin.modules.sys.service.IDictService;

@Transactional
@Service("dictService")
public class DictServiceImpl extends CommonServiceImpl<DictEntity> implements IDictService {

}
