package com.miscbits.officehours.daos;

import com.miscbits.officehours.models.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "roles", path = "roles")
public interface RoleDao extends PagingAndSortingRepository<Role, Long>{
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Role save(Role role);
}
