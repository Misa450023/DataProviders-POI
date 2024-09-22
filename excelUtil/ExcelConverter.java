package excelUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class ExcelConverter {

	ExcelGetter excel;

	public ExcelConverter(ExcelGetter excel) {
		this.excel = excel;

	}

	public String[][] dataAs2dArray() throws IOException {

		int[] rowsAndColl = excel.numberOf_rowsAndcollumns(0);
		int rows = rowsAndColl[0];
		int coll = rowsAndColl[1];
		String[][] data = new String[rows - 1][coll];

		for (int a = 1; a < rows; a++) {
			for (int b = 0; b < coll; b++) {
				String tempData = excel.getCellData(0, a, b);
				if (!(tempData.isEmpty())) {
					data[a - 1][b] = excel.trim(tempData);
				}
			}
		}
		return data;

	}

	public List<String> getHeaders() throws IOException {

		List<String> listOfHeaders = new ArrayList<>();
		int[] rowsAndColl = excel.numberOf_rowsAndcollumns(0);
		int rows = rowsAndColl[0];
		int coll = rowsAndColl[1];

		for (int a = 0; a < coll; a++) {
			String tempData = excel.getCellData(0, 0, a);
			listOfHeaders.add(tempData);
		}

		return listOfHeaders;

	}

	public List<LinkedHashMap<String, String>> getAsmapList() throws IOException {

		List<LinkedHashMap<String, String>> dataFromExcel = new ArrayList<>();
		int[] rowsAndColl = excel.numberOf_rowsAndcollumns(0);
		int rows = rowsAndColl[0];
		int coll = rowsAndColl[1];
		LinkedHashMap<String, String> mapData;
		List<String> allKeys = new ArrayList<>();

		for (int i = 0; i < rows; i++) {
			mapData = new LinkedHashMap<>();
			if (i == 0) {
				for (int j = 0; j < coll; j++) {
					allKeys.add(excel.getCellData(0, 0, j));
				}
			} else {
				for (int j = 0; j < coll; j++) {
					String tempdata = excel.getCellData(0, i, j);
					mapData.put(allKeys.get(j), excel.trim(tempdata));
				}
			}
			dataFromExcel.add(mapData);
		}

		return dataFromExcel.stream().filter(l -> !l.isEmpty()).filter(l -> l != null).collect(Collectors.toList());

	}

}
