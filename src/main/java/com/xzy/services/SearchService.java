package com.xzy.services;

import com.xzy.model.goods_table;

import java.util.List;

public interface SearchService {
    List<goods_table> search( String key );
}
