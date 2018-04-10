package com.springboot.springboot.repository;

import com.springboot.springboot.bean.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author gaoyun
 * 2018/4/10 13:37
 * 描述:
 */
public interface CatRepository extends JpaRepository<Cat, Integer> {
    /**
     * 通过名字查询
     *
     * @param catName 名字
     * @return cat类
     */
    Cat findCatByCatName(String catName);

    /**
     * 自定义SQL查询
     *JPQL语句
     * @param age 年龄
     * @return cat类
     */
    @Query("from Cat where catAge=:age")
    Cat findByCatAge(@Param("age") Integer age);
}
