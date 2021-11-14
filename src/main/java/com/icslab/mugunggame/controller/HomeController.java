package com.icslab.mugunggame.controller;

import com.icslab.mugunggame.dto.User;
import com.icslab.mugunggame.service.GameService;
import java.io.IOException;
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


    private final GameService gameService;
    @Autowired
    public HomeController(GameService gameService) {
        this.gameService = gameService;
    }

    // 게임 참가 이름 작성
    @PostMapping(value = "/join")
    public void join(@RequestBody User user) throws IOException, InterruptedException {
        log.info(user.toString());
        gameService.join(user);
        log.info(user.getUserName()+"님이 참가 하셧습니다.");
        gameService.excueteRun();
    }

    //게임 기록 저장
    @PostMapping(value = "/record")
    public void saveRecordTime(User user) {
        User user1 = gameService.findLastUser(user);
        String id = user1.getIdentificationNumber();
        String name = user1.getUserName();
        gameService.saveRecord(user.getRecordScore(),id);
        user1 = gameService.findLastUser(user);
        log.info(name + "님의 기록이 "+ user1.getRecordScore()+"로 저장되었습니다.");
    }

}
