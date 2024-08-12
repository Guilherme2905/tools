package com.test.tools_challenge.command;

import java.util.List;

import com.test.tools_challenge.exception.HandlerNotFoundException;

import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CommandHandlerDiscovery {

    List<CommandHandler<?, ? extends Command<?>>> handlers;

    @SuppressWarnings("unchecked")
    public <R, C extends Command<R>> CommandHandler<R, C> lookup(Command<R> command) throws HandlerNotFoundException {
        for (var handler : handlers) {
            Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(handler.getClass(), CommandHandler.class);

            Class<? extends Command<R>> commandType = (Class<? extends Command<R>>) generics[1];

            if(commandType.getName().equals(command.getClass().getName())) {
                return (CommandHandler<R, C>) handler;
            }
        }

        throw new HandlerNotFoundException();
    }

}
