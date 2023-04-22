package com.zkdlu.metric;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Endpoint(id = "custom", enableByDefault = true)
class CustomEndpoint {

    private List<String> list = new ArrayList<>();

    @ReadOperation
    public List<String> list() {
        return list;
    }

    @WriteOperation
    public List<String> addList(String text) {
        list.add(text);
        return list;
    }

    @DeleteOperation
    public List<String> deleteList(int index) {
        list.remove(index);
        return list;
    }
}
