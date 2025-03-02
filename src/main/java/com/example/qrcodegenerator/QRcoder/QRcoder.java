package com.example.qrcodegenerator.QRcoder;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class QRcoder {

    private Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType,ErrorCorrectionLevel>();

    public QRcoder() {
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    }

    public void createQR(String data, String path, String chars, int hight, int width) throws WriterException, IOException {

        BitMatrix matrix = new MultiFormatWriter().encode( new String(data.getBytes(chars),chars), BarcodeFormat.QR_CODE,width,hight,this.hashMap);

        // Write the QR code to a file
        MatrixToImageWriter.writeToStream(
                matrix,
                path.substring(path.lastIndexOf('.') + 1),
                new java.io.FileOutputStream(path),
                new MatrixToImageConfig()
        );
    }
}
