package io.myhome.common.util;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * packageName    : io.myhome.common.util
 * fileName       : UuidUtil
 * author         : kimdonggyuuuuu
 * date           : 2022/06/27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/06/27        kimdonggyuuuuu       최초 생성
 */
public class UuidUtil {
    private static final TimeBasedGenerator idGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());

    private UuidUtil() {}

    public static String uuid() {
        return Base64.getEncoder()
                .encodeToString(
                        idGenerator
                        .generate()
                        .toString()
                        .getBytes(StandardCharsets.UTF_8)
                );
    }
}
