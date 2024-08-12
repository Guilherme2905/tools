package com.test.tools_challenge.command;

public interface CommandHandler<R, C extends Command<R>> {
    public R execute(C command);
}
