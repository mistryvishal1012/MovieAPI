package com.jerry1012.MoviesAPI.Security;

public enum ApplicationUserPermission {
    MOVIE_READ("movie:read"),
    MOVIE_WRITE("movie:write"),
    VOTE_READ("vote:read"),
    VOTE_WRITE("vote:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
