package com.test.tools_challenge.query;

import java.util.List;

import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

import com.test.tools_challenge.exception.HandlerNotFoundException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class QueryHandlerDiscovery {

    List<QueryHandler<?, ? extends Query<?>>> handlers;

    @SuppressWarnings("unchecked")
    public <R, Q extends Query<R>> QueryHandler<R, Q> lookup(Query<R> query) throws HandlerNotFoundException {

        for (var handler : handlers) {
            Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(handler.getClass(), QueryHandler.class);

            Class<? extends Query<R>> queryRequestType = (Class<? extends Query<R>>) generics[1];

            if(queryRequestType.getName().equals(query.getClass().getName())) {
                return (QueryHandler<R, Q>) handler;
            }
        }

        throw new HandlerNotFoundException();
    }

}
