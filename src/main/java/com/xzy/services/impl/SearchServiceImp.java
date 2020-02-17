package com.xzy.services.impl;

import com.xzy.dao.goods_tableMapper;
import com.xzy.model.goods_table;
import com.xzy.services.SearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SearchServiceImp implements SearchService {
    @Resource
    goods_tableMapper goods_tablemapper;

    @Override
    public List<goods_table> search(String key) {
        List<goods_table> goods_tableList=goods_tablemapper.search1(key);
        return goods_tableList;
    }
}
