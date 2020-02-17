package com.xzy.services;

import com.xzy.model.goods_table;
import com.xzy.model.goods_tableVO;

import java.util.List;

public interface SearchService {
    List<goods_table> search( String key );
    List<goods_tableVO> search2(String key);
}
