package com.test.database.translate.outandinputstream;

import java.util.zip.CRC32;

public class FileChannelLearn {
    public static void main(String[] args) {
        CRC32 crc32 = new CRC32();
        crc32.update(234234);
        System.out.println(Integer.toHexString((int) crc32.getValue()));
    }
}
