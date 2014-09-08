/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cuongnt.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author CuongNT
 */
@WebService(name = "HelloWorld")
public interface HelloWorld {
    @WebMethod
    String sayHelloWorldAsString(@WebParam(name = "name") String name);
}
