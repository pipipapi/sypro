package liutf.fileTest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Excl操作
 *
 * @author ltf
 * @create 2017-03-02 下午 8:42
 **/
public class ExcelTest {

    public static void main(String[] args) throws Exception {
        String fileUrl = "E:\\test.xlsx";
        Map<String, List<String>> sheet1 = readExcel(fileUrl, 1);
        Map<String, List<String>> sheet2 = readExcel(fileUrl, 2);
        Map<String, List<String>> sheet3 = readExcel(fileUrl, 3);


        String excelName = "E:\\test22.xlsx";
        String[] headList = {"订单号", "运单号", "收货人地址", "收货人手机", "收货人姓名", "商家姓名", "商家电话", "商家地址"};
        String[] fieldList = {"1", "2", "3", "4", "5", "6", "7", "8"};
        List<Map<String, Object>> dataList = new ArrayList<>();

        for (List<String> list : sheet1.values()) {
            Map<String, Object> map = new HashMap<>();
            if (sheet2.containsKey(list.get(0)) && sheet3.containsKey(list.get(1))) {

                List<String> sheet2List = sheet2.get(list.get(0));
                List<String> sheet3List = sheet3.get(list.get(1));

                map.put("1", sheet2List.get(0));
                map.put("2", sheet2List.get(1));
                map.put("3", sheet2List.get(2) + sheet2List.get(3) + sheet2List.get(4) + sheet2List.get(5));
                map.put("4", sheet2List.get(6));
                map.put("5", sheet2List.get(7));
                map.put("6", sheet3List.get(1));
                map.put("7", sheet3List.get(2));
                map.put("8", sheet3List.get(3));

                dataList.add(map);
            }
        }

        createExcel(excelName, headList, fieldList, dataList);

    }


    public static Map<String, List<String>> readExcel(String fileUrl, int sheet) throws IOException, InvalidFormatException {
        Map<String, List<String>> resultMap = new HashMap<>();

        File file = new File(fileUrl);

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheet);

        int rowstart = xssfSheet.getFirstRowNum();
        int rowEnd = xssfSheet.getLastRowNum();
        for (int i = rowstart; i <= rowEnd; i++) {
            List<String> list = new ArrayList<>();

            XSSFRow row = xssfSheet.getRow(i);
            if (null == row) continue;
            int cellStart = row.getFirstCellNum();
            int cellEnd = row.getLastCellNum();

            for (int k = cellStart; k <= cellEnd; k++) {
                XSSFCell cell = row.getCell(k);
                if (null == cell) continue;

                switch (cell.getCellType()) {
                    case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                        list.add(cell.getNumericCellValue() + "");
                        break;
                    case HSSFCell.CELL_TYPE_STRING: // 字符串
                        list.add(cell.getStringCellValue() + "");
                        break;
                    case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                        list.add(cell.getBooleanCellValue() + "");
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA: // 公式
                        list.add(cell.getCellFormula() + "");
                        break;
                    case HSSFCell.CELL_TYPE_BLANK: // 空值
                        list.add("");
                        break;
                    case HSSFCell.CELL_TYPE_ERROR: // 故障
                        list.add("");
                        break;
                    default:
                        list.add("");
                        break;
                }
            }
            resultMap.put(list.get(0), list);
        }
        return resultMap;
    }


    /**
     * 导出excel
     *
     * @param excel_name 导出的excel路径（需要带.xlsx)
     * @param headList   excel的标题备注名称
     * @param fieldList  excel的标题字段（与数据中map中键值对应）
     * @param dataList   excel数据
     * @throws Exception
     */
    public static void createExcel(String excel_name, String[] headList, String[] fieldList, List<Map<String, Object>> dataList)
            throws Exception {
        // 创建新的Excel 工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 在Excel工作簿中建一工作表，其名为缺省值
        XSSFSheet sheet = workbook.createSheet();
        // 在索引0的位置创建行（最顶端的行）
        XSSFRow row = sheet.createRow(0);
        // 设置excel头（第一行）的头名称
        for (int i = 0; i < headList.length; i++) {

            // 在索引0的位置创建单元格（左上端）
            XSSFCell cell = row.createCell(i);
            // 定义单元格为字符串类型
            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
            // 在单元格中输入一些内容
            cell.setCellValue(headList[i]);
        }
        // ===============================================================
        //添加数据
        for (int n = 0; n < dataList.size(); n++) {
            // 在索引1的位置创建行（最顶端的行）
            XSSFRow row_value = sheet.createRow(n + 1);
            Map<String, Object> dataMap = dataList.get(n);
            // ===============================================================
            for (int i = 0; i < fieldList.length; i++) {

                // 在索引0的位置创建单元格（左上端）
                XSSFCell cell = row_value.createCell(i);
                // 定义单元格为字符串类型
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                // 在单元格中输入一些内容
                cell.setCellValue((dataMap.get(fieldList[i])).toString());
            }
            // ===============================================================
        }
        // 新建一输出文件流
        FileOutputStream fos = new FileOutputStream(excel_name);
        // 把相应的Excel 工作簿存盘
        workbook.write(fos);
        fos.flush();
        // 操作结束，关闭文件
        fos.close();
    }
}
