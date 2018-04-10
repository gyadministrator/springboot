package com.springboot.springboot.controller;

import com.springboot.springboot.bean.Cat;
import com.springboot.springboot.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gaoyun
 * 2018/4/10 13:44
 * 描述:
 */
@RestController
public class CatController {
    @Autowired
    private CatService catService;

    /**
     * 增加数据
     *
     * @param cat
     */
    @PostMapping(value = "/cat")
    public void save(Cat cat) {
        Cat c = new Cat();
        c.setCatAge(20);
        c.setCatName("放到地方");
        catService.save(c);
        //catService.save(cat);
    }

    /**
     * 修改数据
     *
     * @param id
     * @param c
     */
    @PutMapping("/cat/{id}")
    public void update(@PathVariable("id") Integer id, Cat c) {
        Cat cat = new Cat();
        cat.setId(id);
        cat.setCatName(c.getCatName());
        cat.setCatAge(c.getCatAge());
        catService.update(cat);
    }

    /**
     * 删除一个数据
     *
     * @param id
     */
    @DeleteMapping("/cat/{id}")
    public void delete(@PathVariable("id") Integer id) {
        catService.delete(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("/findAll")
    public List<Cat> findAll() {
        return catService.findAll();
    }

    @GetMapping("/findByName/{name}")
    public Cat findCatByName(@PathVariable("name") String name) {
        return catService.findCatByCatName(name);
    }

    @GetMapping("/findByAge/{age}")
    public Cat findByAge(@PathVariable("age") Integer age) {
        return catService.findCatByAge(age);
    }
}
