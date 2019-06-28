package cn.gov.saic.wssq;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtils {

	public static void append(String filePath, String fileName, String content) {
		try {
			Path fileAllPath = Paths.get(filePath, fileName);
			boolean fileExist = Files.exists(fileAllPath);
			if (!fileExist) {
				Files.createFile(fileAllPath);
			}
			Files.write(fileAllPath, content.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> read(String fileName) {
		Path fileAllPath = Paths.get(fileName);
		boolean fileExist = Files.exists(fileAllPath);
		if (!fileExist) {
			return null;
		}
		try {
			return Files.readAllLines(fileAllPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<String> read(String filePath, String fileName) {
		Path fileAllPath = Paths.get(filePath, fileName);
		boolean fileExist = Files.exists(fileAllPath);
		if (!fileExist) {
			return null;
		}
		try {
			return Files.readAllLines(fileAllPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void delete(String filePath, String fileName) {
		try {
			Path fileAllPath = Paths.get(filePath, fileName);
			Files.delete(fileAllPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
