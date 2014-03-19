package Szkeleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Torony.ITorony;
import Torony.Torony;
import Varazsko.ITVarazsko;
import Varazsko.KekVarazsko;

public class Main {
	private static BufferedReader in;

	public static String readString() {
		ident();
		try {
			return in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int readInt() {
		while (true) {
			ident();
			try {
				String read = in.readLine();
				try {
					return Integer.parseInt(read);
				} catch (NumberFormatException e) {
				}
			} catch (IOException e) {
				e.printStackTrace();
				return -1;
			}
		}
	}

	public static void log() {
		StackTraceElement e = ident();
		System.out.println(e);
	}

	public static void printLn(String line) {
		ident();
		System.out.println(line);
	}

	private static StackTraceElement ident() {
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		StringBuilder build = new StringBuilder(stack.length + 64);
		for (int i = 0; i < stack.length - 4; i++) {
			build.append("\t");
		}
		System.out.print(build);
		return stack[3];
	}

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		log();
		ITorony t = new Torony();
		ITVarazsko vk = new KekVarazsko(); 
		vk.hat(t);
		vk.getKoltseg();
		in.close();
	}
}