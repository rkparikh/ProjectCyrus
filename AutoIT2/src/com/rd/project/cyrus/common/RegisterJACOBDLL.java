package com.rd.project.cyrus.common;
import java.io.File;

import com.jacob.com.LibraryLoader;

public class RegisterJACOBDLL {

	public static void registerDLLs() {
		String jacobDllVersionToUse;
		if (jvmBitVersion().contains("32")) {
			jacobDllVersionToUse = "jacob-1.16-x86.dll";
		} else {
			jacobDllVersionToUse = "jacob-1.16-x64.dll";
		}
		File file = new File("lib", jacobDllVersionToUse);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

	}

	/**
	 * 
	 * Returns if the JVM is 32 or 64 bit version
	 */
	private static String jvmBitVersion() {
		return System.getProperty("sun.arch.data.model");
	}
}
