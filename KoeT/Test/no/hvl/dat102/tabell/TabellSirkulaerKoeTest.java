package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTTest;
import no.hvl.dat102.exceptions.EmptyCollectionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TabellSirkulaerKoeTest extends KoeADTTest {

	@Override
    protected KoeADT<Integer> reset() {
        return new TabellSirkulaerKoe<>();
    }

    @Test
    void utvidTest() {

        koe.innKoe(i0);
        koe.innKoe(i1);
        koe.innKoe(i2);
        koe.innKoe(i3);
        koe.innKoe(i4);
        try {
            koe.innKoe(i0);
            Assertions.assertEquals(i0, koe.utKoe());
            Assertions.assertEquals(i1, koe.utKoe());
            Assertions.assertEquals(i2, koe.utKoe());
            koe.innKoe(i3);
            Assertions.assertEquals(i3, koe.utKoe());
            Assertions.assertEquals(i4, koe.utKoe());
            Assertions.assertEquals(i0, koe.utKoe());
            Assertions.assertEquals(i3, koe.utKoe());
        }
        catch (EmptyCollectionException e) {
            Assertions.fail(e.getMessage());
        }
    }
}
