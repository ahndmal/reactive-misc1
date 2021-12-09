package com.andmal.rc.reactor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlsTests {

    @Test
    public void urlTests() {

        try {

            URL url = new URL("https://projectreactor.io/");
            InputStream inputStream = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Assertions.assertTrue(reader.readLine().startsWith("<!--"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
