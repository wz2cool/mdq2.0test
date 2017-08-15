package com.github.wz2cool.mdqtest.controller;

import com.github.wz2cool.mdqtest.mapper.ProductDao;
import com.github.wz2cool.mdqtest.model.entity.table.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value = "getProducts", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return productDao.selectAll();
    }

}