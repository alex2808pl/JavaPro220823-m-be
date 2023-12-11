package de.telran.module_2.lesson_8;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class Cargo {
    private String sender;
    private String receiver;
    private double weight;
}
