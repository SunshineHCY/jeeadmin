package cn.admin.modules.dept.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.dept.entity.Dept;
import cn.admin.modules.dept.service.IDeptService;

@Transactional
@Service("deptService")
public class DeptServiceImpl extends CommonServiceImpl<Dept> implements IDeptService {

}
