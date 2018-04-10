package com.springboot.springboot.service;

import com.springboot.springboot.bean.Cat;
import com.springboot.springboot.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gaoyun
 * 2018/4/10 13:39
 * 描述:
 */
@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    //增加数据
    @Transactional
    public void save(Cat cat) {
        catRepository.save(cat);
    }

    //修改数据
    @Transactional
    public void update(Cat cat) {
        catRepository.save(cat);
    }

    //删除数据
    @Transactional
    public void delete(Integer id) {
        catRepository.deleteById(id);
    }

    //查询数据
    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    //通过名字查询
    public Cat findCatByCatName(String catName) {
        return catRepository.findCatByCatName(catName);
    }

    //通过年龄查询，自定义SQL
    public Cat findCatByAge(Integer age) {
        return catRepository.findByCatAge(age);
    }
}
