package com.icslab.mugunggame.mapper;

import com.icslab.mugunggame.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GameMapper {

    void join(User user);

    String reciveFinishTime(String recordScore);

    User findLastuser(User user);

    void saveRecord(String recordScore,String identificationNumber);

}
