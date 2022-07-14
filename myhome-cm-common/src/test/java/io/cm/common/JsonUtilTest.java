package io.cm.common;

import com.fasterxml.jackson.core.type.TypeReference;
import io.myhome.common.util.JsonUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

/**
 * packageName    : io.cm.common
 * fileName       : JsonUtilTest
 * author         : kimdonggyuuuuu
 * date           : 2022/06/27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/06/27        kimdonggyuuuuu       최초 생성
 */
public class JsonUtilTest {

    @ParameterizedTest(
            name = "json util test"
    )
    @ValueSource(strings = { "{\n" +
            "    \"oid\": \"test\",\n" +
            "    \"id\": \"testId\",\n" +
            "    \"name\": \"hong gil dong\",\n" +
            "    \"age\": 1\n" +
            "}" })
    void JsonTest(String json) {
        Map<String, Object> parseMap = JsonUtil.deserialize(json, new TypeReference<>() {});

        Assertions.assertEquals("test", parseMap.get("oid"));
        Assertions.assertEquals(1, parseMap.get("age"));
    }
}
