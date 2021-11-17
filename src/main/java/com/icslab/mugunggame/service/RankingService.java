package com.icslab.mugunggame.service;

import com.icslab.mugunggame.dto.User;
import com.icslab.mugunggame.mapper.RankingMapper;
import java.util.List;
import java.util.concurrent.Phaser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RankingService {

    @Autowired
    private RankingMapper rankingMapper;

    /* 성공한 사용자수 구하기 */
    public int userCount(){
        int n = rankingMapper.userCount();
        log.info(Integer.toString(n));
        return n;
    }

    /* 랭킹 불러오기 */
    public List<User> clearUser(){
        return rankingMapper.clearShowUser();
    }

}
