
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Queue;

class Node21 implements Comparable<Node20>{
	long value;
	int index;
	
	public Node21(int index, long value) {
		this.index= index;
		this.value= value;
	}

	@Override
	public int compareTo(Node20 o) {
		
		if(value != o.value)
			return new Long(o.value - value).intValue();
		else
			return index - o.index;
	}
}

public class Monk1 {

	public static void main(String[] args) {
	InputReader s = new InputReader(System.in);
        PrintWriter p = new PrintWriter(System.out);
		
		int n=s.nextInt();
		int k=s.nextInt();
		
		String str= s.nextLine();
		
		String st[]=str.split("\\s+");
		
		Queue<Node20> queue=new PriorityQueue<>();
		
		for(int i=1;i<=n;i++)
			queue.add(new Node20(i, Long.parseLong(st[i-1])));
		
		while(k-->0) {
			Node20 obj= queue.poll();
			
			p.print(obj.index+" ");
			obj.value--;
			if(obj.value!=0)
			    queue.add(obj);
		}
		
	}
	
static class InputReader {
 
    private final InputStream stream;
    private final byte[] buf = new byte[8192];
    private int curChar, snumChars;
    private SpaceCharFilter filter;
 
    public InputReader(InputStream stream) {
      this.stream = stream;
    }
 
    public int snext() {
      if (snumChars == -1)
      throw new InputMismatchException();
      if (curChar >= snumChars) {
        curChar = 0;
        try {
          snumChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (snumChars <= 0)
        return -1;
      }
      return buf[curChar++];
    }
 
    public int nextInt() {
      int c = snext();
      while (isSpaceChar(c)) {
        c = snext();
      }
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = snext();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9')
        throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = snext();
      } while (!isSpaceChar(c));
      return res * sgn;
    }
 
    public long nextLong() {
      int c = snext();
      while (isSpaceChar(c)) {
        c = snext();
      }
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = snext();
      }
      long res = 0;
      do {
        if (c < '0' || c > '9')
        throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = snext();
      } while (!isSpaceChar(c));
      return res * sgn;
    }
 
    public int[] nextIntArray(int n) {
      int a[] = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = nextInt();
      }
      return a;
    }
 
    public String readString() {
      int c = snext();
      while (isSpaceChar(c)) {
        c = snext();
      }
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = snext();
      } while (!isSpaceChar(c));
      return res.toString();
    }
 
    public String nextLine() {
      int c = snext();
      while (isSpaceChar(c))
      c = snext();
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = snext();
      } while (!isEndOfLine(c));
      return res.toString();
    }
 
    public boolean isSpaceChar(int c) {
      if (filter != null)
      return filter.isSpaceChar(c);
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    private boolean isEndOfLine(int c) {
      return c == '\n' || c == '\r' || c == -1;
    }
 
    public interface SpaceCharFilter {
      public boolean isSpaceChar(int ch);
    }
  }
 
}
