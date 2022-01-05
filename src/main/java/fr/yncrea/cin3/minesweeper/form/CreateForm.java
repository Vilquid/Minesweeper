package fr.yncrea.cin3.minesweeper.form;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Setter
@Getter
public class CreateForm {
    private UUID id;
    private long width;
    private long height;
    private long count;
}