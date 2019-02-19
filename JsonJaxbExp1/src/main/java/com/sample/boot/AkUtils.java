package com.sample.boot;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.ak.Root;

public class AkUtils {
	public static Root readAndCreateContent() {
		File file = new File("src/main/resources/akdata1.xml");
		Root root = null;
		try {
			InputStream inputStream = FileUtils.openInputStream(file);
			JAXBContext jc = JAXBContext.newInstance(Root.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Source source = new StreamSource(new BufferedInputStream(inputStream));
			JAXBElement<Root> je = unmarshaller.unmarshal(source, Root.class);
			root = (Root) je.getValue();
		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (root != null) {
			System.out.println(root.getFirstElement());
			System.out.println(root.getSecondElement());
		} else {
			System.out.println("no good");
		}
		return root;
	}

	public static void main(String[] args) throws IOException {
		int[][] arr = new int[5][2];
		System.out.println(arr.length);
		String parent = null;
		File file = new File(parent, "aakash.txt");
		file.createNewFile();
	}
	
	public static void copyFile(MultipartFile file) {
		String inputFolder =".";
		try {
			Files.copy(file.getInputStream(),
			        new File(new URL(inputFolder).getPath() + "/" + file.getOriginalFilename()).toPath(),
			        StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
