package com.csh.JavaIO.nettyDemo.lbrpc.server.service;

import java.util.List;

public interface TestService {
    List<String> listAll();

    String listByid(Integer id);
}
