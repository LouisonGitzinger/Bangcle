package com.fengyue.bangcle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemCommand {

	public static void execute(String command) throws IOException, InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("execute " + command);
		Process pr = runtime.exec(command);
		BufferedReader input = new BufferedReader(new InputStreamReader(
				pr.getInputStream()));
		BufferedReader errInput = new BufferedReader(new InputStreamReader(
				pr.getErrorStream()));

		String line = null;

		while ((line = input.readLine()) != null) {
			System.out.println(line);
		}
		while ((line = errInput.readLine()) != null) {
			System.out.println(line);
		}

		int exitVal = pr.waitFor();
		System.out.println("Exited with error code " + exitVal);
	}

}
