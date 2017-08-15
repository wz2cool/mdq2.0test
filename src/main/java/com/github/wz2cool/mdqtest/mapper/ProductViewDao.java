package com.github.wz2cool.mdqtest.mapper;

import com.github.wz2cool.mdqtest.model.entity.view.ProductView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Frank
 * \* Date: 8/15/2017
 * \* Time: 1:49 PM
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Mapper
public interface ProductViewDao {

    List<ProductView> getProductViewByDynamicQuery(Map<String, Object> params);
}