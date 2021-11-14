package com.icslab.mugunggame.service;

import com.icslab.mugunggame.dto.User;
import com.icslab.mugunggame.mapper.GameMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameService {

    @Autowired
    private GameMapper gameMapper;


    public void join(User user){
        gameMapper.join(user);
        return ;
    }

    public String reciveFinishTime(String recordScore){
        return gameMapper.reciveFinishTime(recordScore);
    }

    public User findLastUser(User user){
        return gameMapper.findLastuser(user);
    }

    public void saveRecord(String recordScore, String identificationNumber){
        gameMapper.saveRecord(recordScore, identificationNumber);
    };

    public void excueteRun() throws IOException, InterruptedException {
        String[] command = new String[] { "Python3", "test" };
        GameService runner = new GameService();
        runner.byRuntime(command);
        runner.byProcessBuilder(command);
        runner.byProcessBuilderRedirect(command);
    }

    public void byProcessBuilderRedirect(String[] command)
        throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(command);
        builder.redirectOutput(Redirect.INHERIT);
        builder.redirectError(Redirect.INHERIT);
        builder.start();
    }

    public void byRuntime(String[] command)
        throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        printStream(process);
    }

    public void byProcessBuilder(String[] command)
        throws IOException,InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = builder.start();
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

