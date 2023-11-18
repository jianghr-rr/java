package com.example.producer.rpc.producer.impl;

import com.example.producer.rpc.producer.SkuService;

public class SkuServiceImpl implements SkuService {
    @Override
    public String findByName(String name) {
        return "sku{}:" + name;
    }
}
