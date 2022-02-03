package no.hvl.dat102.adt;

	import no.hvl.dat102.exceptions.EmptyCollectionException;
	import no.hvl.dat102.kjedet.KjedetKoe;
	import org.junit.jupiter.api.Assertions;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

	public abstract class KoeADTTest {
		
	    protected Integer i0, i1, i2, i3, i4;
	    protected KjedetKoe<Integer> koe;

	    protected abstract KoeADT<Integer> reset();

	    @BeforeEach
	    void setup() {
	        koe = new KjedetKoe<>();
	        i0 = 0;
	        i1 = 1;
	        i2 = 2;
	        i3 = 3;
	        i4 = 4;
	    }

	    @Test
	     void innOgUtTest() {

	        Assertions.assertTrue(koe.erTom());
	        koe.innKoe(i0);
	        koe.innKoe(i1);
	        koe.innKoe(i2);
	        koe.innKoe(i3);
	        koe.innKoe(i4);
	        Assertions.assertFalse(koe.erTom());
	        try {
	            Assertions.assertEquals(i0, koe.utKoe());
	            Assertions.assertEquals(i1, koe.utKoe());
	            Assertions.assertEquals(i2, koe.utKoe());
	            Assertions.assertEquals(i3, koe.utKoe());
	            Assertions.assertEquals(i4, koe.utKoe());
	        }
	        catch (EmptyCollectionException e) {
	            Assertions.fail(e.getMessage());
	        }
	        Assertions.assertTrue(koe.erTom());
	    }

	    @Test
	    void popFromEmpty() {
	        Assertions.assertThrows(EmptyCollectionException.class, () -> koe.utKoe());
	        Assertions.assertThrows(EmptyCollectionException.class, () -> koe.foerste());
	    }
}
