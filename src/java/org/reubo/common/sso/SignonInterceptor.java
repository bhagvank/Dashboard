/*
 * SignonInterceptor.java
 *
 * Created on April 4, 2006, 4:24 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.reubo.common.sso;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 *
 * @author bhagvank
 */
public class SignonInterceptor extends HandlerInterceptorAdapter{
    
    /** Creates a new instance of SignonInterceptor */
    public SignonInterceptor() {
    }
    
    	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
            System.out.println("Single Sing on Approved");
            return true;

	}
}
