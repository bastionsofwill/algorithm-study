import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BOJ1717_io {
    static int[][] univSet = new int[1000001][2];
    static int find(int e) {
        if(univSet[e][0] == e) return e;
        else return find(univSet[e][0]);
    }
    static void union(int e1, int e2) {
        int e1Root = find(e1);
        int e2Root = find(e2);
        if(e1Root != e2Root) {
            int h1 = univSet[e1Root][1];
            int h2 = univSet[e2Root][1];
            if(h1 < h2) univSet[e1Root][0] = e2Root;
            else if(h1 == h2) {
                univSet[e2Root][0] = e1Root;
                univSet[e1Root][1]++;
            } else univSet[e2Root][0] = e1Root;
        }
    }
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String nextLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }  
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void print(int v) throws IOException {
        print(v+"");
    }
    static void print(String s) throws IOException {
        bw.write(s);
    }
    static void println() throws IOException {
        print("\n");
    }
    static void println(int a) throws IOException {
        print(a+"\n");
    }
    static void println(long a) throws IOException {
        print(a+"\n");
    }
    static void println(double a) throws IOException {
        print(a+"\n");
    }
    static void println(String s) throws IOException {
        bw.write(s+"\n");
    }
    public static void main(String[] args) throws IOException{
        Reader rd = new Reader();
        int N = rd.nextInt();
        for(int i = 0; i < N + 1; i++) {
            univSet[i][0] = i;
        }
        int M = rd.nextInt();
        for(int i = 0; i < M; i++) {
            int op = rd.nextInt();
            int e1 = rd.nextInt();
            int e2 = rd.nextInt();
            if(op == 0) union(e1, e2);
            else {
                if(find(e1) == find(e2)) println("YES");
                else println("NO");
            }
        }
        bw.flush();
    }
}