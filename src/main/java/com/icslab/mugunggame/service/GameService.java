package com.icslab.mugunggame.service;

import com.icslab.mugunggame.dto.User;
import com.icslab.mugunggame.mapper.GameMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GameService {

    @Autowired
    private GameMapper gameMapper;

    /* 게임 참가 */
    public void join(User user){

        //사용자가 존재 하지 않을 경우
        if(user.getIdentificationNumber() == null){
            log.info("사용자 존재 하지 않을 경우");
            gameMapper.join(user);
        }
        //사용자가 존재 할경우
        else {
            log.info("사용자 존재 할 경우");
            deleteUser(user.getIdentificationNumber(), user.getUserName());
            gameMapper.join(user);
        }
    }

    /* 마지막 참가자 찾기 */
    public User findLastUser(User user){
        return gameMapper.findLastuser(user);
    }

    /* 게임 기록 저장 */
    public void saveRecord(float recordScore, String identificationNumber){
        /* 사용자가 기록이 0 일때 */
        if (recordScore == 0.0){
            User user1 = gameMapper.findUser(identificationNumber);
            deleteUser(user1.getIdentificationNumber(), user1.getUserName());
        }

        /* 정상 기록이 들어 왔을 때 */
        else {
        gameMapper.saveRecord(recordScore, identificationNumber);
        }
    }

    /* Null 기록 삭제 */
    public void deleteRecord(){
        gameMapper.deletRecord();
    }

    /* 특정 인물 삭제 */
    public void deleteUser(String identificationNumber, String name){
        gameMapper.deleteUser(identificationNumber,name);
    }

    /* 외부 프로그램 실행 */
    /* 파이썬 코드를 실행 시키기 위함 */
    public void excueteRun() throws IOException, InterruptedException {
        String[] command = new String[] { "python3", "test.py" };
        GameService runner = new GameService();
        runner.byRuntime(command);
    }

    public void byRuntime(String[] command)
        throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        printStream(process);
    }

    private void printStream(Process process)
        throws IOException, InterruptedException {
        process.waitFor();
        try (InputStream psout = process.getInputStream()) {
            copy(psout, System.out);
        }
    }

    public void copy(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[1024];
        int n = 0;
        while ((n = input.read(buffer)) != -1) {
            output.write(buffer, 0, n);
        }
    }
}

