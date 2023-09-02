package com.fiap.grupo9.AppEletroControl.config.interceptor;

import com.fiap.grupo9.AppEletroControl.config.interceptor.exception.InvalidHeaderFieldException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class HeaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("Requisição interceptada: " + request.getHeader("usuario-auth-key"));
        String uri = request.getRequestURI();
        if(StringUtils.isAllBlank(request.getHeader("usuario-auth-key")) &&
                !uri.contains("swagger-") &&
                !uri.contains("api-docs")
        ){
            throw new InvalidHeaderFieldException("Usuário não informado");
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}