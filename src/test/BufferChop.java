package test;

public class BufferChop {
	public static void main(String[] args) {

		// buffer size should be at least max word size.
		chopBuffer("One two three111 four five six seven eight nine", 10);
	}

	public static void chopBuffer(String input, int buffersize) {
		int size = 0, start = 0, end = 0;
		boolean isError = false;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == ' ' || i == input.length() - 1) {
				end = i;
			}
			if (size == buffersize || i == input.length() - 1) {
				if (start > end) {
					isError = true;
					break;

				}

				sb.setLength(0);
				sb.append(input, start, end + 1);
				System.out.println(sb.toString());

				i = end + 1;
				start = end + 1;
				size = 0;
			}

			size++;

		}

		if (isError) {
			System.out.println("Buffer size is too small.");
		}

	}
}
