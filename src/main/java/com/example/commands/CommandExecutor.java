package com.example.commands;

import org.springframework.stereotype.Component;

@Component
public class CommandExecutor {
    public <R> R execute(Command<R> command) {
        return command.execute();
    }
}
