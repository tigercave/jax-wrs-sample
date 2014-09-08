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
@WebService
public class HelloWorldWS {
    
    // DI via Spring
    HelloWorld helloWorld;
    
    @WebMethod(exclude = true)
    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }
    
    @WebMethod(exclude = false)
    public String sayHello(@WebParam(name = "name") String name) {
        return helloWorld.sayHelloWorldAsString(name);
    }
}
