/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.movieappspring.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SanitizeInputInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Inside prehandle");

        // Check if any request parameter contains HTML, JavaScript, Java, or XML
        if (containsUnsafeInput(request)) {
            // Detected unsafe input, return false
            throw new Exception("Do not enter any html, js, java or xml in the input");
        }

        return true;
    }

    private boolean containsUnsafeInput(HttpServletRequest request) {
        // Iterate through all request parameters and check for unsafe input
        for (String paramName : request.getParameterMap().keySet()) {
            String[] values = request.getParameterValues(paramName);
            for (String value : values) {
                if (containsHTML(value) || containsJavaScript(value) || containsJava(value) || containsXML(value)) {
                    return true; // Detected unsafe input
                }
            }
        }
        return false; // No unsafe input detected
    }

    private boolean containsHTML(String input) {
        return input.matches(".*<[^>]+>.*");
    }

    private boolean containsJavaScript(String input) {
        return input.matches(".*<script>.*");
    }

    private boolean containsJava(String input) {
        return input.matches(".*java:.*");
    }

    private boolean containsXML(String input) {
        return input.matches(".*<\\?xml.*");
    }
}
