package com.miscbits.officehours.daos;

import com.miscbits.officehours.models.Request;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "requests", path = "requests")
public interface RequestDao extends PagingAndSortingRepository<Request, Long> {

    @PreAuthorize("@requestRepository.findOne(#id)?.user?.username == authentication.name or HAS_ROLE('ROLE_ADMIN')")
    void deleteById(@Param("id") Long id);

    @Override
    @PreAuthorize("#request.user?.username == authentication.name or HAS_ROLE('ROLE_ADMIN')")
    void delete(@Param("request") Request request);

    @Override
    @PreAuthorize("#request.user?.username == authentication.name or HAS_ROLE('ROLE_ADMIN')")
    Request save(Request request);

    Request findOneById(Long id);
}
