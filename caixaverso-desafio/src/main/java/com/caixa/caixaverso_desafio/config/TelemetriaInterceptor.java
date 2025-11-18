package com.caixa.caixaverso_desafio.config;

import com.caixa.caixaverso_desafio.services.TelemetriaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TelemetriaInterceptor implements HandlerInterceptor {

    @Autowired
    private TelemetriaService telemetriaService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute("startTime", System.currentTimeMillis());

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {

        Long startTime = (Long) request.getAttribute("startTime");

        if(startTime != null) {
            Long duration = System.currentTimeMillis() - startTime;

            telemetriaService.registrarChamada(request.getRequestURI(), duration);
        }
    }
}
