package algodat;

public class Test02 {
	public static void main(String[] args) {

		int count = 1;

		System.out.println("Starting Run 1. Hash of Size 17");
		System.out.println("");

		KleineHash hash = new KleineHash(17);

		String s1 = "foo";
		String s2 = "bar"; 

		if(!hash.add(s1)){
			System.out.println("[Issue "+ count++ + "] Add returned false, although there should be space in the hash.");
		}
		if(!hash.add(s2)){
			System.out.println("[Issue "+ count++ + "] Add returned false, although there should be space in the hash.");
		}

		String[] array = hash.getArray();
		if(array[16] == null || !array[16].equals("foo")){
			System.out.println("[Issue "+ count++ + "] Illegal state of array. Index 16 should be 'foo', was '" + array[16] + "'.");
		}
		if(array[8] == null || !array[8].equals("bar")){
			System.out.println("[Issue "+ count++ + "] Illegal state of array. Index 8 should be 'bar', was '" + array[8] + "'.");
		}


		System.out.println("");
		System.out.println("Starting Run 2. Hash of Size 17");
		System.out.println("");

		hash = new KleineHash(17);

		s1 = "foo";
		s2 = "foo"; 
		String s3 = "foo";

		if(!hash.add(s1)){
			System.out.println("[Issue "+ count++ + "] Add returned false, although there should be space in the hash.");
		}
		if(!hash.add(s2)){
			System.out.println("[Issue "+ count++ + "] Add returned false, although there should be space in the hash.");
		}
		if(!hash.add(s3)){
			System.out.println("[Issue "+ count++ + "] Add returned false, although there should be space in the hash.");
		}

		array = hash.getArray();

		if(array[16] == null || !array[16].equals("foo")){
			System.out.println("[Issue "+ count++ + "] Illegal state of array. Index 16 should be 'foo', was '" + array[16] + "'.");
		}
		if(array[0] == null || !array[0].equals("foo")){
			System.out.println("[Issue "+ count++ + "] Illegal state of array. Index 0 should be 'foo', was '" + array[0] + "'.");
		}
		if(array[1] == null || !array[1].equals("foo")){
			System.out.println("[Issue "+ count++ + "] Illegal state of array. Index 1 should be 'foo', was '" + array[1] + "'.");
		}

		System.out.println("");
		System.out.println("Starting Run 3. Hash of Size 3");
		System.out.println("");

		hash = new KleineHash(3);

		s1 = "Does";
		s2 = "Not";
		s3 = "Matter";
		String s4 = "!";

		if(!hash.add(s1)){
			System.out.println("[Issue "+ count++ + "] Add returned false, although there should be space in the hash.");
		}
		if(!hash.add(s2)){
			System.out.println("[Issue "+ count++ + "] Add returned false, although there should be space in the hash.");
		}
		if(!hash.add(s3)){
			System.out.println("[Issue "+ count++ + "] Add returned false, although there should be space in the hash.");
		}
		if(hash.add(s4)){
			System.out.println("[Issue "+ count++ + "] Add returned true, although the hash should be full.");
		}

		array = hash.getArray();

		if(array[0] == null || !array[0].equals("Not")){
			System.out.println("[Issue "+ count++ + "] Illegal state of array. Index 0 should be 'Not', was '" + array[0] + "'.");
		}
		if(array[1] == null || !array[1].equals("Matter")){
			System.out.println("[Issue "+ count++ + "] Illegal state of array. Index 1 should be 'Matter', was '" + array[1] + "'.");
		}
		if(array[2] == null || !array[2].equals("Does")){
			System.out.println("[Issue "+ count++ + "] Illegal state of array. Index 2 should be 'Does', was '" + array[2] + "'.");
		}

		if(count == 1){
			System.out.println("All tests passed. Please note that this is only a basic case, which does _not_ cover all corner cases which will be tested for the correction.");
		}
	}


}
