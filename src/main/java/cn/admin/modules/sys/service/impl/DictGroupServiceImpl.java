package cn.admin.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.sys.entity.DictGroup;
import cn.admin.modules.sys.service.IDictGroupService;

@Transactional
@Service("dictGroupService")
public class DictGroupServiceImpl extends CommonServiceImpl<DictGroup> implements IDictGroupService {

}
