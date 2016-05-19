

import java.io.*;
import java.util.*;

public class LasProcessor {
	private TreeMap<Integer, Stack<Integer>> tree;
	int[] las;
	static private int counter = 0;
	

	private List<Integer> p;

	private List<Integer> data;
	private int c;

	public LasProcessor(List<Integer> data, int c, int counter) {
		this.data = data;
		this.c = c;

		tree = new TreeMap<>();
		p = new ArrayList<>(data.size());
	}

	public int[] generateLAS() {
		int n = data.size();

		for (int i = 0; i < n; ++i) {

			counter++;
			int xi = data.get(i);

			Map.Entry<Integer, Stack<Integer>> predecessor = tree.lowerEntry(xi);

			counter++;
			if (predecessor != null)
				p.add(i, predecessor.getValue().get(0));
			else
				p.add(i, i);

			Stack<Integer> stack = tree.get(xi);
			// Increment counter for tree search
			counter++;
			if (stack == null) {
				stack = new Stack<>();
				tree.put(xi, stack);
			}
			stack.push(i);
			Map.Entry<Integer, Stack<Integer>> s = tree.ceilingEntry(xi + c);

			counter++;

			if (s != null) {
				Stack<Integer> tempStack = s.getValue();
				if (tempStack.size() < 2) {
					tree.remove(s.getKey());
				}
				else {
					tempStack.pop();
				}
			}
			System.out.print("z - "+(i+1)+": ");
			for(int zed : tree.keySet())
				System.out.print((zed) + " ");
			System.out.println();

			System.out.print("p - "+(i+1)+": ");
			for (int m:p)
				System.out.print((m+1)+" ");

			System.out.println();
			System.out.println();
		}
		int l = getLength(tree);
		// Increment counter for tree search
		counter++;

		int m = tree.lastEntry().getValue().get(0);
		// Increment counter for tree search
		counter++;
		int xm = data.get(m);

		las = new int[l];
		int pos_lais = l;
		for (int i = n - 1; i > m; --i) {
			int xi = data.get(i);
			if (xm - c < xi && xi <= xm) {
				las[--pos_lais] = xi;
			}
		}

		las[--pos_lais] = xm;

		int t = m;
		int pt = p.get(t);
		while (t != pt) {
			// Increment counter for iteration
			counter++;
			int xpt = data.get(pt);
			for (int i = t - 1; i > pt; --i) {
				// Increment counter for iteration
				counter++;
				int xi = data.get(i);
				if (xpt - c < xi && xi <= xpt) {
					las[--pos_lais] = xi;
				}
			}
			las[--pos_lais] = xpt;

			t = pt;
			pt = p.get(t);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(las.length).append("\t").append(counter);
		
		try (FileWriter fw = new FileWriter("Results.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(sb.toString());
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return las;
	}

	private int getLength(TreeMap<Integer, Stack<Integer>> z) {
		int l = 0;
		for (Map.Entry<Integer, Stack<Integer>> treei : z.entrySet()) {
			l += treei.getValue().size();
		}
		return l;
	}
}