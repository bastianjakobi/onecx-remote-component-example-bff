package org.tkit.onecx.remote.component.example.bff.rs.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;

import org.jboss.resteasy.reactive.ClientWebApplicationException;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import org.tkit.onecx.remote.component.example.bff.rs.mappers.ExceptionMapper;

import gen.org.tkit.onecx.remote.component.example.bff.rs.internal.TestApiApiService;
import gen.org.tkit.onecx.remote.component.example.bff.rs.internal.model.ProblemDetailResponseDTO;
import gen.org.tkit.onecx.remote.component.example.bff.rs.internal.model.TextResponseDTO;

@ApplicationScoped
@Transactional(value = Transactional.TxType.NOT_SUPPORTED)
public class ExampleController implements TestApiApiService {
    @Inject
    ExceptionMapper exceptionMapper;

    @Override
    public Response getText() {
        TextResponseDTO textResponseDTO = new TextResponseDTO();
        textResponseDTO.setText("Hello world!");
        return Response.status(200).entity(textResponseDTO).build();
    }

    @ServerExceptionMapper
    public RestResponse<ProblemDetailResponseDTO> constraint(ConstraintViolationException ex) {
        return exceptionMapper.constraint(ex);
    }

    @ServerExceptionMapper
    public Response restException(ClientWebApplicationException ex) {
        return exceptionMapper.clientException(ex);
    }
}
