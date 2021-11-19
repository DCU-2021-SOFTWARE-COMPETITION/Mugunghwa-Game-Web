package com.icslab.mugunggame.controller;

import com.icslab.mugunggame.dto.User;
import com.icslab.mugunggame.mapper.RankingMapper;
import com.icslab.mugunggame.service.GameService;
import com.icslab.mugunggame.service.RankingService;
import java.io.IOException;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/home")
@RestController
public class HomeController {

    @Autowired
    private final GameService gameService;

    @Autowired
    private final RankingService rankingService;

    public HomeController(GameService gameService, RankingService rankingService) {
        this.gameService = gameService;
        this.rankingService = rankingService;
    }

    // 게임 참가 이름 작성
    @PostMapping(value = "/join")
    public void join(@RequestBody User user) throws IOException, InterruptedException {
        log.info(user.toString());
        gameService.deleteRecord();
        gameService.join(user);
        log.info(user.getUserName()+"님이 참가 하셨습니다.");
        gameService.excueteRun();
    }

    //게임 기록 저장
    @PostMapping(value = "/record")
    public float saveRecordTime(@RequestBody User user){
        float record = user.getRecordScore();
        User user1 = gameService.findLastUser(user);
        String id = user1.getIdentificationNumber();
        String name = user1.getUserName();
        gameService.saveRecord(record,id);
        log.info(name + "님의 기록이 "+ record+"로 저장되었습니다.");
        return record;
    }

    //성공한 User 수 구하기
    @GetMapping(value = "/showCountRank")
    public int showCountRanking(){
        return rankingService.userCount();
    }

    //성공한 사람 나타내기
    @GetMapping(value = "/showRankUser")
    public List<User> showUserRank(){
        return rankingService.clearUser();
    }

    @PostMapping(value = "/motiondetec")
    public void detectMotion(@RequestBody Integer value){
        User user = null;
        User user1 = gameService.findLastUser(user);
        /*if (value == 1) {
            if (Float.paruser1.getRecordScore() = null;){
                gameService.deleteUser(user1.getIdentificationNumber(), user1.getUserName());
            }*/
        }
}


