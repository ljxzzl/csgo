package com.example.demo.serviceIpl;

import com.example.demo.pojo.OrnamentInfo;
import com.example.demo.service.ornamentService;

import java.util.List;

public class ornamentIpl implements ornamentService {
    @Override
    public int addOrnament(OrnamentInfo ornament) {
        return 0;
    }



    @Override
    public List<OrnamentInfo> ornamentList() {
        return null;
    }

    @Override
    public List<OrnamentInfo> qureyOrnamentList(String name) {
        return null;
    }

    @Override
    public List<OrnamentInfo> classOrnemntList(String name) {
        return null;
    }

    @Override
    public List<OrnamentInfo> PriceOrnemntList(String name) {
        return null;
    }
}
