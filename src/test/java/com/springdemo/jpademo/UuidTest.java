package com.springdemo.jpademo;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

@Slf4j
public class UuidTest {


    public static String getJdkUUID() {
        System.out.println(UUID.randomUUID());
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }

    @Test
    public void GeneratorUUIDTest() {
//        String generatorUUID = Generators.timeBasedGenerator().generate().toString().replaceAll("-", "");
        String generatorUUID = Generators.timeBasedGenerator(EthernetAddress.fromInterface()).generate().toString().replaceAll("-", "");
        log.info("generatorUUID: {}", generatorUUID);
    }

    @Test
    public void jdkUUIDTest() {
        String jdkUUID = getJdkUUID();
        Assert.assertNotNull(jdkUUID);
        log.info("jdkUUID: {}", jdkUUID);
    }

}
