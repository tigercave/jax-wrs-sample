/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cuongnt.ws;

import javax.jws.WebService;

/**
 *
 * @author CuongNT
 */
@WebService(endpointInterface = "com.cuongnt.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String sayHelloWorldAsString(String name) {
        return "JAX-WS Webservice: " + name;
    }
    
}
