package com.github.wz2cool.mdqtest.controller;

import com.github.wz2cool.dynamic.*;
import com.github.wz2cool.mdqtest.model.entity.table.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// test serialize to json
@RestController
@RequestMapping("/serialize")
public class TestSerializeController {

    @RequestMapping(value = "getPriceFilters", method = RequestMethod.GET)
    public List<FilterDescriptorBase> getPriceFilters() {
        FilterDescriptor priceFilter =
                new FilterDescriptor(Product.class, Product::getPrice, FilterOperator.GREATER_THAN, 10);
        FilterDescriptor priceFilter2 =
                new FilterDescriptor(Product.class, Product::getPrice, FilterOperator.LESS_THAN, 20);

        List<FilterDescriptorBase> result = new ArrayList<>();
        result.add(priceFilter);
        result.add(priceFilter2);
        return result;
    }

    @RequestMapping(value = "getGroupPriceFilters", method = RequestMethod.GET)
    public List<FilterDescriptorBase> getGroupPriceFilters() {
        FilterDescriptor priceFilter =
                new FilterDescriptor(Product.class, Product::getPrice, FilterOperator.GREATER_THAN, 10);
        FilterDescriptor priceFilter2 =
                new FilterDescriptor(Product.class, Product::getPrice, FilterOperator.LESS_THAN, 20);

        FilterGroupDescriptor priceGroupFilter = new FilterGroupDescriptor();
        priceGroupFilter.addFilters(priceFilter, priceFilter2);

        FilterDescriptor categoryFilter =
                new FilterDescriptor(Product.class, Product::getCategoryId, FilterOperator.EQUAL, 3);

        List<FilterDescriptorBase> result = new ArrayList<>();
        result.add(priceGroupFilter);
        result.add(categoryFilter);
        return result;
    }
}