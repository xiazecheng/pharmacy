package com.yaojie.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaojie.mapper.ContentMapper;
import com.yaojie.pojo.Content;
import com.yaojie.pojo.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Author  madao
 * Created by madao on 2016/12/3.
 */
@Service
public class ContentService extends BaseService<Content> {
   @Autowired
    private ContentMapper contentMapper;

    public EasyUIDataGridResult queryListByCategoryId(Long categoryId, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);


        Example expample=new Example(Content.class);
        expample.createCriteria().andCondition("category_id").andEqualTo(categoryId);
        expample.orderBy("updated").desc();
        List<Content> contents = contentMapper.selectByExample(expample);
        PageInfo<Content> pageInfo=new PageInfo<>(contents);
        return new EasyUIDataGridResult(pageInfo.getList(),pageInfo.getTotal());

    }
}
