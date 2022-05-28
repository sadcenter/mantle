package io.sadcenter.mantle.controller;

import io.sadcenter.mantle.repository.UserRepository;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CapeController {

  private static final ResponseEntity<?> NOT_FOUND = ResponseEntity.notFound().build();

  private final HttpHeaders headers;
  private final UserRepository repository;

  @Autowired
  public CapeController(UserRepository repository) {
    this.repository = repository;
    this.headers = new HttpHeaders();
    this.headers.setContentType(MediaType.IMAGE_PNG);
  }

  @GetMapping(value = "/capes/{name}.png", produces = MediaType.IMAGE_PNG_VALUE)
  @ResponseBody
  public CompletableFuture<ResponseEntity<?>> getUserCape(@PathVariable String name) {
    return this.repository.findByName(name)
        .thenApply(user -> {
          try (InputStream inputStream = user == null ? this.getOptifineCape(name)
              : this.getCape(user.getCape())) {
            if (inputStream == null) {
              return NOT_FOUND;
            }

            return new ResponseEntity<>(toByteArray(inputStream), this.headers, HttpStatus.OK);
          } catch (Exception exception) {
            exception.printStackTrace();
            return NOT_FOUND;
          }
        });
  }

  private byte[] toByteArray(InputStream inputStream) throws IOException {
    byte[] bytes = IOUtils.toByteArray(inputStream);
    inputStream.close();
    return bytes;
  }

  private InputStream getCape(String capeName) throws FileNotFoundException {
    return new FileInputStream(capeName + ".png");
  }

  private InputStream getOptifineCape(String capeName) throws IOException {
    return new URL("http://107.182.233.85/capes/" + capeName + ".png").openStream(); //optifine ip
  }

}
