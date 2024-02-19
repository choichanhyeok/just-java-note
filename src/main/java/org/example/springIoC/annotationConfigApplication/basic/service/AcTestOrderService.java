package org.example.springIoC.annotationConfigApplication.basic.service;

public class AcTestOrderService {
    public FindTestProductDTO findAllOrder(){

        String id = "hyeok01";

        return new FindTestProductDTO(id, ("상품" + id));
    }

}
