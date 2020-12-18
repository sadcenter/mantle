package xyz.sadcenter.spring.controller;

import org.apache.commons.io.IOUtils;
import org.bson.Document;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.sadcenter.spring.SpringWebApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author sadcenter on 16.12.2020
 * @project mantle
 */
@Controller
public final class CapeController {

    @GetMapping(
            value = "/capes/{name}.png",
            produces = MediaType.IMAGE_JPEG_VALUE
    )

    @ResponseBody
    public ResponseEntity<byte[]> getUserCape(@PathVariable String name) throws IOException {
        Document cape = SpringWebApplication
                .getMongoCollection()
                .find(new Document("name", name))
                .first();

        InputStream in;
        if (cape == null) {
            in = getOptifineCape(name);
        } else {
            in = getCape(cape.getString("cape"));
        }

        if (in == null) {
            return null;
        }

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
    }

    private InputStream getCape(String capeName) throws FileNotFoundException {
        return new FileInputStream(capeName + ".png");
    }

    private InputStream getOptifineCape(String capeName) throws IOException {
        try {
            return new URL("http://107.182.233.85/capes/" + capeName + ".png").openStream();
        } catch (FileNotFoundException e) {
            return null;
        }
    }

}
