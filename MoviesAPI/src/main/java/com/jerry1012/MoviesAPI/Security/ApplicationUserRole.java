package com.jerry1012.MoviesAPI.Security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.jerry1012.MoviesAPI.Security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(MOVIE_READ, MOVIE_WRITE, VOTE_READ, VOTE_WRITE)),
    USER(Sets.newHashSet(MOVIE_READ, VOTE_READ, VOTE_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
