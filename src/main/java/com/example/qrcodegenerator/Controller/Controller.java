package com.example.qrcodegenerator.Controller;


import com.example.qrcodegenerator.QRcoder.QRcoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private QRcoder qrCoder;

    public Controller(QRcoder qrCoder){
        this.qrCoder = qrCoder;
    }

    @GetMapping("/qr")
    public String generateQR() {
        String data = "Guys i gætter aldrig hvem som nu kan lave QR koder til ting ";
        String path = "demo.png";
        String charset = "UTF-8";
        try {
            qrCoder.createQR(data,path,charset, 400,400);
            return "qr code generated";
        } catch (Exception e) {
            return "Error";
        }
    }


}
