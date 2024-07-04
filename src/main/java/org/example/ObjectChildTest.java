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
public class ObjectChildTest {

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
    private TestEnum enumValue;

    // Coleções
    private List<String> stringList;
    private Set<Integer> integerSet;


    public static ObjectChildTest getObjectTest(int multiply) {
        return new ObjectChildTest(
                (byte) (multiply),
                (short) (2 * multiply), (3 * multiply), (4L * multiply), 5.0f * multiply, 6.0 * multiply, 'a', true,
                (byte) (multiply), (short) (2 * multiply), 3 * multiply, 4L * multiply, 5.0f * multiply, 6.0 * multiply, 'a', true,
                "default" + multiply, BigInteger.valueOf(100L * multiply), BigDecimal.valueOf(100.0 * multiply),
                LocalDate.of(2020, 1, 1), LocalTime.of(12, 0),
                LocalDateTime.of(2020, 1, 1, 12, 0), OffsetDateTime.now(), E,
                new ArrayList<>(Arrays.asList("item1", "item2", "item3")),
                new HashSet<>(Arrays.asList(1, 2, 3))
        );
    }
}
