package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	class WordNode {
		String word;
		int numSteps;

		public WordNode(String word, int numSteps) {
			this.word = word;
			this.numSteps = numSteps;
		}
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordListSet = new HashSet<String>(wordList);
		return ladderLength(beginWord, endWord, wordListSet);
	}

	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if (beginWord == null || beginWord.isEmpty()) {
			return 0;
		}

		Queue<WordNode> q = new LinkedList<WordNode>();

		q.add(new WordNode(beginWord, 1));

		while (!q.isEmpty()) {

			WordNode qd = q.remove();
			String word = qd.word;

			System.out.println(word + "->" + endWord);

			if (word.equals(endWord)) {
				return qd.numSteps;
			}

			char[] data = word.toCharArray();
			for (int i = 0; i < data.length; i++) {
				for (char j = 'a'; j <= 'z'; j++) {
					char temp = data[i];

					if (data[i] != j) {
						data[i] = j;
					}

					String newWord = data.toString();

					if (wordList.contains(newWord)) {
						q.add(new WordNode(newWord, qd.numSteps + 1));
						wordList.remove(newWord);
					}

					data[i] = temp;
				}
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" });
		WordLadder sol = new WordLadder();
		int ans = sol.ladderLength("hit", "cog", list);
		System.out.println(ans);

	}

}
