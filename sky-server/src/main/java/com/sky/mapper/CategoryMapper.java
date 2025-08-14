package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CategoryMapper {
    /**
     * 更新分类
     * @param category
     */
    void update(Category category);

    /**
     * 分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 增加类型
     * @param category
     */
    @Insert("insert into category (type,name,sort,status,create_time,update_time,create_user,update_user)" +
            "values " +
            "(#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void addCategory(Category category);

    /**
     * 根据id删除类型
     * @param id
     */
    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);

    @Select("select * from category where type = #{type}")
    Category[] typeQuery(Integer type);
}
