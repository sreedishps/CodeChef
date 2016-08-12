import java.io.*;

import java.util.HashSet;


/**
 * Created by sreps on 8/5/2016.
 */

public class CHEFRRUN {

    static int answer = 0;
    static  int destination[];

    public static void main(String[] args) throws IOException {
        Reader in;
        PrintWriter out;
        in = new Reader();
        int T = in.nextInt();

        while (T-- > 0) {
            answer = 0;
            int N = in.nextInt();
            int input[] = new int[N];
            destination = new int[N];
            boolean[] magic = new boolean[N];
            boolean[] visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                input[i] = in.nextInt() % N;
                destination[i] = (i + input[i] + 1) % N;
                if(i == destination[i]){
                    magic[i] = true;
                    visited[i] = true;
                    answer++;
                }
            }


            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                makeTrip(i, visited, magic, input, N);
            }
            System.out.println(answer);
        }
    }


    private static void makeTrip(int i, boolean[] visited, boolean[] magic, int[] input, int n) {
        boolean[] visitedNow = new boolean[n];
        visitedNow[i] = true;
        while (true) {
            int nextHope = destination[i];
            if (visitedNow[nextHope] && !magic[nextHope]) {
                while (true) {
                    if (magic[i]) {
                        break;
                    }
                    magic[i] = true;
                    answer++;
                    visited[i] = true;
                    i = destination[i];
                }
                break;
            }
            if (visited[nextHope]) {
                return;
            }

            visited[nextHope] = true;
            visitedNow[nextHope] = true;
            i = nextHope;
        }

    }


}


class Reader {

    final private int BUFFER_SIZE = 1 << 16;

    private DataInputStream din;

    private byte[] buffer;

    private int bufferPointer, bytesRead;


    public Reader() {

        din = new DataInputStream(System.in);

        buffer = new byte[BUFFER_SIZE];

        bufferPointer = bytesRead = 0;

    }


    public Reader(String file_name) throws IOException {

        din = new DataInputStream(new FileInputStream(file_name));

        buffer = new byte[BUFFER_SIZE];

        bufferPointer = bytesRead = 0;

    }


    public String readLine() throws IOException {

        byte[] buf = new byte[1024];

        int cnt = 0, c;

        while ((c = read()) != -1) {

            if (c == '\n')

                break;

            buf[cnt++] = (byte) c;

        }

        return new String(buf, 0, cnt);

    }


    public int nextInt() throws IOException {

        int ret = 0;

        byte c = read();

        while (c <= ' ')

            c = read();

        boolean neg = (c == '-');

        if (neg)

            c = read();

        do {

            ret = ret * 10 + c - '0';

        } while ((c = read()) >= '0' && c <= '9');

        if (neg)

            return -ret;

        return ret;

    }


    public long nextLong() throws IOException {

        long ret = 0;

        byte c = read();

        while (c <= ' ')

            c = read();

        boolean neg = (c == '-');

        if (neg)

            c = read();

        do {

            ret = ret * 10 + c - '0';

        } while ((c = read()) >= '0' && c <= '9');

        if (neg)

            return -ret;

        return ret;

    }


    public double nextDouble() throws IOException {

        double ret = 0, div = 1;

        byte c = read();

        while (c <= ' ')

            c = read();

        boolean neg = (c == '-');

        if (neg)

            c = read();

        do {

            ret = ret * 10 + c - '0';

        } while ((c = read()) >= '0' && c <= '9');

        if (c == '.')

            while ((c = read()) >= '0' && c <= '9')

                ret += (c - '0') / (div *= 10);

        if (neg)

            return -ret;

        return ret;

    }


    private void fillBuffer() throws IOException {

        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);

        if (bytesRead == -1)

            buffer[0] = -1;

    }


    private byte read() throws IOException {

        if (bufferPointer == bytesRead)

            fillBuffer();

        return buffer[bufferPointer++];

    }


    public void close() throws IOException {

        if (din == null)

            return;

        din.close();

    }

}



