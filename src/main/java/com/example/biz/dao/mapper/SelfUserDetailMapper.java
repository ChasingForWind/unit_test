package com.example.biz.dao.mapper;


import com.example.biz.dao.domain.SelfUserDetail;
import com.example.biz.dao.example.SelfUserDetailExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SelfUserDetailMapper {
    int countByExample(SelfUserDetailExample example);

    int deleteByExample(SelfUserDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SelfUserDetail record);

    int insertSelective(SelfUserDetail record);

    List<SelfUserDetail> selectByExampleWithBLOBs(SelfUserDetailExample example);

    List<SelfUserDetail> selectByExample(SelfUserDetailExample example);

    SelfUserDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SelfUserDetail record, @Param("example") SelfUserDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") SelfUserDetail record, @Param("example") SelfUserDetailExample example);

    int updateByExample(@Param("record") SelfUserDetail record, @Param("example") SelfUserDetailExample example);

    int updateByPrimaryKeySelective(SelfUserDetail record);

    int updateByPrimaryKeyWithBLOBs(SelfUserDetail record);

    int updateByPrimaryKey(SelfUserDetail record);
}