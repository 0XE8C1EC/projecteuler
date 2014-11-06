package com.cs.euler.p050;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.cs.euler.EulerBase;

public class P022NamesScores extends EulerBase {

	/*

  */

	@Test
	public void resolve() {
		Map<String, Integer> map = new TreeMap<>();
		try (InputStream input = new FileInputStream("data" + File.separator
				+ "p022.txt")) {
			List<String> lines = IOUtils.readLines(input);
			for (String line : lines) {
				String[] names = line.replace("\"", "").split(",");
				for (String name : names) {
					map.put(name, score(name));
				}
			}
			int index=1;
			for(String name:map.keySet()){
				map.put(name, map.get(name)*index);
				index++;
			}
			long sum=0;
			for(Integer s:map.values()){
				sum+=s;
			}
			print(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Integer score(String name) {
		int sum=0;
		for(byte b:name.getBytes()){
			sum+=b-'A'+1;
		}
		return sum;
	}
}

