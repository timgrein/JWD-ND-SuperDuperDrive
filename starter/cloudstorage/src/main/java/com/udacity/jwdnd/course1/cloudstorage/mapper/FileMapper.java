package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;

@Mapper
public interface FileMapper {

    @Insert("INSERT INTO FILES (id, name, content_type, size, user_id, data) " +
            "VALUES(#{id}, #{name}, #{contentType}, #{size}, #{userId}, #{data})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertFile(File file);

    @Select("SELECT * FROM FILES WHERE user_id = #{userId}")
    File[] getFiles(int userId);

    @Delete("DELETE FROM FILES WHERE id = #{id} AND user_id = #{userId}")
    Integer deleteFile(Integer id, Integer userId);

    @Select("SELECT * FROM FILES WHERE id = #{id}")
    File getFile(Integer id);

    @Select("SELECT * FROM FILES WHERE name = #{name} and user_id = #{userId}")
    File getFileByName(String name, Integer userId);
}