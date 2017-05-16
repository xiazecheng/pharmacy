package com.yaojie.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaojie.mapper.ItemparamexdMapper;
import com.yaojie.pojo.EasyUIDataGridResult;
import com.yaojie.pojo.ItemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author  madao
 * Created by madao on 2016/11/14.
*/
@Service
public class ItemParmService extends BaseService<ItemParam> {
    @Autowired
    private ItemparamexdMapper itemparamexdMapper;

    public EasyUIDataGridResult getItemParamList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        //执行查询

        List list = itemparamexdMapper.selectList();
        //取分页信息
        PageInfo pageInfo = new PageInfo<>(list);
        //返回处理结果
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(pageInfo.getList());
        return result;
    }
}
