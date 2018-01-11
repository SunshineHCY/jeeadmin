package cn.admin.core.common.service;

import java.io.Serializable;

import cn.admin.core.common.entity.tree.TreeNode;

public interface ITreeCommonService<T extends Serializable & TreeNode<ID>, ID extends Serializable>
		extends ICommonService<T> {

}