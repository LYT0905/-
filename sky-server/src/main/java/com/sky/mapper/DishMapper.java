package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.anotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    @AutoFill(OperationType.INSERT)
    void insert(Dish dish);

    void insertBatch(List<DishFlavor> flavors);

    /**
     * 菜品分页功能
     * @param queryDTO
     * @return
     */
    Page<DishVO> pageQuery(DishPageQueryDTO queryDTO);

    /**
     * 通过id找菜品
     * @param id
     * @return
     */
    @Select("select * from dish where id = #{id};")
    Dish getById(Integer id);

    void deleteBatch(List<Integer> dishIds);
}
