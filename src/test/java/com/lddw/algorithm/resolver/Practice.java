package com.lddw.algorithm.resolver;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>描述 TODO</p>
 * @date 2020/11/27 14:05
 * @author LiuXin
 * @since 1.0
 **/
public class Practice {

	private static final Logger LOGGER = LoggerFactory.getLogger(Practice.class);

	@Test
	public void p1() throws IOException {
		LOGGER.info("请先输入要排序的人数");
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			String line = scanner.next();
			System.out.println(line);
		}



	}

//	public static void main(String[] args) {
//		String[] arr = new String[15];
//		//插入排序
//		Scanner scanner = new Scanner(System.in);
//		int i=0;
//		while (scanner.hasNext()){
//			String line = scanner.next();
//			arr[i++] = line;
//			//从第三个(索引2，采用插入排序再向后一位变成3)位置开始使用插入排序
//			for(int j =3; j < arr.length; j++){
//				for(int n = j -1; n >=2 && arr[n] > arr[n+1]; n--){
//					swap(arr,n, n-1);
//				}
//			}
//		}
//
//	}

	private static void swap(int[] arr, int n, int i) {
		arr[n] = arr[n] ^ arr[i];
		arr[i] = arr[n] ^ arr[i];
		arr[n] = arr[i] ^ arr[n];
	}


	public void print(Map<String, Integer> data, int size, String order) {
		int i = 0;
		if ("0".equals(order)) {
			//降序
			for (Map.Entry<String, Integer> entry : data.entrySet()) {
				if (i == size)
					break;
				LOGGER.info("{} {}", entry.getKey(), entry.getValue());
				i++;
			}

		} else if ("1".equals(order)) {
			//升序
			for (int j = 0; j < data.entrySet().size(); j++) {
				if (i == size)
					break;

				i++;
			}
		}

	}

}
