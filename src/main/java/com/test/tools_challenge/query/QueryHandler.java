package com.test.tools_challenge.query;

public interface QueryHandler<R, Q extends Query<R>> {
    public R execute(Q query);
}
