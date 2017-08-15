package com.github.wz2cool.mdqtest.controller;

import com.github.wz2cool.dynamic.*;
import com.github.wz2cool.dynamic.mybatis.MybatisQueryProvider;
import com.github.wz2cool.mdqtest.mapper.ProductDao;
import com.github.wz2cool.mdqtest.mapper.ProductViewDao;
import com.github.wz2cool.mdqtest.model.entity.table.Product;
import com.github.wz2cool.mdqtest.model.entity.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Frank
 * \* Date: 8/15/2017
 * \* Time: 9:55 AM
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
@RequestMapping("/data")
public class TestDataController {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductViewDao productViewDao;

    @RequestMapping(value = "getProducts", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return productDao.selectAll();
    }

    @RequestMapping(value = "getProductsByDynamicQuery", method = RequestMethod.POST)
    public List<Product> getProductsByDynamicQuery(@RequestBody FilterDescriptorBase[] filters) {
        DynamicQuery<Product> dynamicQuery = new DynamicQuery<>(Product.class);
        for (FilterDescriptorBase filter : filters) {
            dynamicQuery.addFilter(filter);
        }

        return productDao.selectByDynamicQuery(dynamicQuery);
    }

    @RequestMapping(value = "getProductViewsDemo", method = RequestMethod.GET)
    public List<ProductView> getProductViewsDemo() throws Exception {
        DynamicQuery<ProductView> dynamicQuery = new DynamicQuery<>(ProductView.class);

        FilterDescriptor priceFilter =
                new FilterDescriptor(ProductView.class, ProductView::getPrice, FilterOperator.GREATER_THAN, 10);
        FilterDescriptor priceFilter2 =
                new FilterDescriptor(ProductView.class, ProductView::getPrice, FilterOperator.LESS_THAN, 20);

        FilterGroupDescriptor priceGroupFilter = new FilterGroupDescriptor();
        priceGroupFilter.addFilters(priceFilter, priceFilter2);
        FilterDescriptor categoryNameFilter =
                new FilterDescriptor(ProductView.class, ProductView::getCategoryName, FilterOperator.EQUAL, "Condiments");

        dynamicQuery.addFilter(priceGroupFilter);
        dynamicQuery.addFilter(categoryNameFilter);


        Map<String, Object> params = MybatisQueryProvider.getQueryParamMap(dynamicQuery,
                "whereExpression",
                "sortExpression",
                "columnsExpression");
        return productViewDao.getProductViewByDynamicQuery(params);
    }
}