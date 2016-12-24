package installer;

import java.io.IOException;

public class Main {
	final static String ADMIN = "runas /user:Administrator ";

	final static String PATH = "D:\\HA\\Setup\\";

	final static String[] INSTALLERS = { "jdk-7u5-windows-i586.exe", "SQLEXPRWT_x64_ENU.exe",
			"AdbeRdr11006_en_US.exe", };

	public static void main(String[] args) {
		install();
	} // MAIN

	static void runBatch() {
		try {
			String path = "D:\\HA\\batches\\installer.bat";
			Runtime.getRuntime().exec(path);
		} catch (IOException e) {
			e.printStackTrace();
		} // try-catch
	} // runBatch

	static void install() {
		try {
			Process process;
			for (String exe : INSTALLERS) {
				process = Runtime.getRuntime().exec(PATH + exe);
				System.out.println(exe + " has started.");
				process.waitFor();
			} // for
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} // try-catch
	} // install
} // class
