package com.github.wz2cool.mdqtest.controller;

import com.github.wz2cool.dynamic.FilterCondition;
import com.github.wz2cool.dynamic.FilterDescriptor;
import com.github.wz2cool.dynamic.FilterDescriptorBase;
import com.github.wz2cool.dynamic.FilterOperator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// test serialize to json
@RestController
@RequestMapping("/serialize")
public class TestSerializeController {

    @RequestMapping(value = "getTestFilters", method = RequestMethod.GET)
    public FilterDescriptorBase[] getTestFilters() {
        FilterDescriptor filterDescriptor = new FilterDescriptor(FilterCondition.AND, "age", FilterOperator.END_WITH, "a");

        return new FilterDescriptorBase[]{filterDescriptor};
    }
}