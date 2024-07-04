package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.*;

import static org.example.TestEnum.E;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectTest {

    // Tipos primitivos
    private byte primitiveByte;
    private short primitiveShort;
    private int primitiveInt;
    private long primitiveLong;
    private float primitiveFloat;
    private double primitiveDouble;
    private char primitiveChar;
    private boolean primitiveBoolean;

    // Wrappers de tipos primitivos
    private Byte wrapperByte;
    private Short wrapperShort;
    private Integer wrapperInt;
    private Long wrapperLong;
    private Float wrapperFloat;
    private Double wrapperDouble;
    private Character wrapperChar;
    private Boolean wrapperBoolean;

    // Tipos imutáveis comuns
    private String stringValue;
    private BigInteger bigIntegerValue;
    private BigDecimal bigDecimalValue;
    private LocalDate localDateValue;
    private LocalTime localTimeValue;
    private LocalDateTime localDateTimeValue;
    private OffsetDateTime offsetDateTimeValue;
    private  TestEnum enumValue;

    // Coleções
    private List<String> stringList;
    private Set<Integer> integerSet;
    private Map<String, Double> stringDoubleMap;

    private List<ObjectChildTest> objectChildTests;


    public static ObjectTest getObjectTest() {
        Map<String, Double> map = new HashMap<>();
        map.put("a", 1.0);
        map.put("b", 2.0);
        map.put("c", 3.0);
        map.put("d", 4.0);
        return new ObjectTest(
                (byte) 1,
                (short) 2, 3, 4L, 5.0f, 6.0, 'a', true,
                (byte) 1, (short) 2, 3, 4L, 5.0f, 6.0, 'a', true,
                "default", BigInteger.valueOf(100), BigDecimal.valueOf(100.0),
                LocalDate.of(2020, 1, 1), LocalTime.of(12, 0),
                LocalDateTime.of(2020, 1, 1, 12, 0), OffsetDateTime.now(), E,
                new ArrayList<>(Arrays.asList("item1", "item2", "item3")),
                new HashSet<>(Arrays.asList(1, 2, 3)),
                map,
                new ArrayList<>(Arrays.asList(ObjectChildTest.getObjectTest(2),ObjectChildTest.getObjectTest(3)))
        );
    }
}
