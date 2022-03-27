package org.jabref.model.entry.event;

import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.UnknownField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldChangedEventTest {

    @Test
    void testComputeMajorCharacterChange() {
        String value1 = new String("teste");
        String value2 = new String("casa");
        String value3 = new String("teste");
        String value4 = new String("carro");

        // CT1 - oldValue e newValue apontando para o mesmo endereço
        assertEquals(0,new FieldChangedEvent(new BibEntry(), new UnknownField(""), value1, value1).getMajorCharacterChange());
        // CT2 - oldValue == null e newValue != null
        assertEquals(5,new FieldChangedEvent(new BibEntry(), new UnknownField(""), value1, null).getMajorCharacterChange());
        // CT3 - oldValue != null e newValue == null
        assertEquals(4,new FieldChangedEvent(new BibEntry(), new UnknownField(""), null, value2).getMajorCharacterChange());
        // CT4 - oldValue e newValue com conteúdos diferentes, mas tamanhos iguais
        assertEquals(5,new FieldChangedEvent(new BibEntry(), new UnknownField(""), value1, value4).getMajorCharacterChange());
        // CT5 - oldValue e newValue com o mesmo conteúdo
        assertEquals(0,new FieldChangedEvent(new BibEntry(), new UnknownField(""), value1, value3).getMajorCharacterChange());
        // CT6 - oldValue e newValue com strings de tamanhos diferentes
        assertEquals(1,new FieldChangedEvent(new BibEntry(), new UnknownField(""), value1, value2).getMajorCharacterChange());

    }

}
