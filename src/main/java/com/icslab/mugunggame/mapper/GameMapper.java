package com.icslab.mugunggame.mapper;

import com.icslab.mugunggame.dto.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GameMapper {

    /* 게임 참가 */
    void join(User user);

    /* 마지막 참가자 찾기 */
    User findLastuser(User user);

    /* 게임 기록 저장 */
    void saveRecord(String recordScore,String identificationNumber);

    /* 기록 삭제 */
    void deletRecord();


}
